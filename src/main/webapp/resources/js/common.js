
/*커스텀 모달*/
var customModal = (function cM(){
    
    function customModal(){
      this.id = ''; 
      this.url='';
      this.width='';
      this.custom="";
      this.callback='';
      this.div= document.createElement('div');     
      this.div.setAttribute('class', 'modal-custom');
      this.div_body=document.createElement('div');
      this.div.setAttribute('class', 'modal-body');
      this.div_body_custom= document.createElement('div'); 
      this.div_body_custom.setAttribute('class', 'modal-body_msg');
      this.div_body.appendChild(this.div_body_custom);
      
      
      this.div_bottom= document.createElement('div');
      this.div.setAttribute('class', 'modal-bottom');   
      this.msg;
    }
    
    customModal.prototype.init = function(arg){      
      this.id = arg.id; 
      this.url= arg.url;
      this.custom = arg.custom;
    }
    
     customModal.prototype.build = function(callback){
           that = this;        
           if(this.custom==true){
        	   callback.call(this);
           }else{        	   
        	   
        	this.div.appendChild(this.div_body);
        	this.div.appendChild(this.div_bottom);
        	   
        	  $('.modal').append(this.div);
           }
           
     }
    return customModal;        
})()


function modalCommon(){
	
	$this = this;
	
    $('.task-button').bind('click', taskAdd);	
    
    $('.board-add-button').bind('click', function(event){
   	 $('.modal-board').css('display', 'block'); 
	 $('.dim-mask').css('display', 'block');
    });
    
}

function taskAdd(event){ 
	 $('.modal').css('display', 'block'); 
	 $('.dim-mask').css('display', 'block');
	 var param = {index: parseInt(event.currentTarget.getAttribute("boardid"))};
	 if(event.currentTarget.id){
		 param['task_id'] = parseInt(event.currentTarget.id);

   	 commonAjax({url: $this.url, type:'POST', param: param}, 
   	    	 function(data){     
   	    		 console.log(data);
   	    		        	 $('.main-container').append(that.div);	
   	                        /* $('.modal').html(data);           */            
   	    		        	 $('#title').val(JSON.parse(data).title);
   	    		        	 $('.modal-contents-input').val(JSON.parse(data).contents);
   	    		           	 $('#startDt').val(JSON.parse(data).start_dt);
   	    		             $('#endDt').val(JSON.parse(data).end_dt);
   	    		        	 $('#boardIdx').val(event.currentTarget.getAttribute("boardid"));
   	    		        	 $('#taskId').val(JSON.parse(data).task_id); 		     
   	         }  
   	    	)  
		 
	 }else{
		 param['task_id'] = '';
   	 $('#title').val('');
   	 $('.modal-contents-input').val('');
      	 $('#startDt').val('');
        $('#endDt').val('');
   	 $('#boardIdx').val(event.currentTarget.getAttribute("boardid"));
   	 $('#taskId').val(''); 	    		 
	 }
	 
}



function commonAjax(arg, callback){
	
    $.ajax({
        url : arg.url,
        type : arg.type,
        data : arg.param,
        dataType:'text',
        success : function(data) {
        	try{
        	     callback.call(this, data);
        	}catch(e){
        		$('.modal').css('display', 'none'); 
                $('.dim-mask').css('display', 'none'); 
        	}
     
        },
        error: function(request, error){
         console.log(error);
         }
});
	
}


var customDrag = (function(){	

   	function customDrag(){	
   		this.dragElement = document.createElement("div");
   		this.dragElement.setAttribute("class", "taskDragOver");  
   		this.dragEvents=[];   	
   	}
   	
 	customDrag.prototype.set= function(arg){   	 		
   		this.dragEvents.push(arg);   		
 	}
 	

   	customDrag.prototype.build= function(arg){
   		this.dragEvents.forEach(function(e){
   	 	 document.querySelector(e.target).addEventListener(e.type, e.callback, e.bubble);
//   	   	 document.querySelector(this.drop.target).addEventListener('drop', this.drop.callbackk, this.bubble);
//   	   	 document.querySelector(this.dragdrop.target).addEventListener('dragover', this.dragover.callbackk, this.bubble);   	  
//   	   
   		});
  	}
   	
   	return customDrag;
})()



function drag(event){
	event.dataTransfer.effectAllowed='move';
	event.dataTransfer.setData("task", event.target.id);
	event.dataTransfer.setData("board", event.target.getAttribute('boardid'));
}

function allowDrop(event) {
	
	event.preventDefault();
	event.stopPropagation();
	 
	event.dataTransfer.setData("task-target", event.currentTarget.getAttribute('id'));	 
	 console.log(event.currentTarget.getAttribute('id'));
	 console.log(event.target.getAttribute('id'));
	var dragover = document.createElement("div");
	    dragover.setAttribute("class", "task-drag-over");
	    dragover.setAttribute("id", event.currentTarget.getAttribute('id'));
	    dragover.ondrag=drop;
	    dragover.ondragover=allowDrop;	    
	 
/*    드래그엔드롭 할때 무조건 current로 하자. target 이랑 currentTarget은 완전히 별게다*/
	 if(event.currentTarget.className=="task-depth-0"){		   
		 if($(".task-drag-over").length>0){$(".task-drag-over").remove();}
		 event.currentTarget.appendChild(dragover);
	 }else if(event.currentTarget.className.indexOf("task-depth-1")>=0){
		 if($(".task-drag-over").length>0){$(".task-drag-over").remove();}
		 event.currentTarget.after(dragover);	 
	 }else if(event.target.className=="task-drag-over"){
		 		 
	 }else if(event.currentTarget.className=="main-container"){
		 if($(".task-drag-over").length>0){$(".task-drag-over").remove();}	
	 }
	
	 
	 
    return false;
}


function drop(event){
	event.preventDefault();
	event.stopPropagation();
	
    var data = event.dataTransfer.getData("task");
    var target = event.dataTransfer.getData("task-target");
    var target_id =event.currentTarget.getAttribute('id');

    if(event.currentTarget.className.indexOf("task-depth-1")>=0){		
	    event.currentTarget.after(document.getElementById(data));
	}else if(event.currentTarget.className =="task-depth-0 "){		
		 $(event.currentTarget).find('add-task').before(document.getElementById(data));
	}else if(event.target.className =="task-drag-over"){		
		 event.target.replaceWith(document.getElementById(data));
	}
    
   console.log( event.target.getAttribute('id'));
    commonAjax({url: '/taskDrop', type: 'POST',
        param: {task_id:target_id, task_id_from: data , board_id: event.currentTarget.getAttribute("boardid") ,board_id_from: event.dataTransfer.getData("board")}, 
       function(data){}  
});
    
	
	$(".task-drag-over").remove();
	return false

}


window.onerror= function(msg, url, line, col, error){
	
    var div= document.createElement('div');     
    div.setAttribute('class', 'modal-error');
    var div_body= document.createElement('div');  
    div_body.setAttribute('class', 'modal-error-msg');
    div_body.innerText=msg;
    var div_button= document.createElement('div');  
    div_button.setAttribute('class', 'modal-error-button');
    div_button.innerText="CONFRIM";
    div_button.onclick= function(){
    	$('.modal-error').remove();
    }
    
    div.appendChild(div_body);
    div.appendChild(div_button);
    $('.modal-box').append(div);
//	alert("error 발생!!!!"+"\n"+msg);
}

$('.task-submit').bind('click', function(event){

	 var param = {
			      board_id: $('#boardIdx').val(),
			      task_id: $('#taskId').val(), 
			      title: $($('.modal-title-input')[0]).val(), 
			      content: ekEditor.getData() ,
			      start_dt: $("#startDt").val(),
			      end_dt: $("#endDt").val()
			      }
	 
	  commonAjax({url: '/taskUpdate', type: 'POST',
		         param: param , 
   	         function(data){}  
	   });
	 
	 	console.log($('#taskId').val());
	 	if($('#taskId').val()===""){
	 		var task_depth = $($('.task-depth-1')[0]).clone();
			$(task_depth).attr('boardid', $('#boardIdx').val());
			task_depth.find('.task-count');		
			
			task_depth.find('.task-title').text($($('.modal-title-input')[0]).val());
			task_depth.find('.task-info');
		    task_depth.ondrag=drop;
		    task_depth.ondragover=allowDrop;
		  
		    
		    $($('div[boardid='+$('#boardIdx').val()+']')[$('div[boardid='+$('#boardIdx').val()+']').length-1]).before(task_depth);
		    
		 	
	 	}else{
	 	   
		  		
	 	}
	
});



/*$('.board-submit').bind('click', function(){
	
	 commonAjax({url: "/addBoard" , type:'POST', param: {'title': $("#board-title-input").val(), 'people': []}}); 
	
});
*/
$('.board-submit').bind('click', function(){
	
	 commonAjax({url:"/boardAdd", type:'POST', param: {}}, 
			 function(e){
		 		$(".modal-close-button").trigger("click");
		 		$("#board-title-input").val("")
		 		var board = document.createElement("div");
		 		board.setAttribute("class", "task-depth-0");
		 		document.ondrop = drop;
		 		document.ondragover = allowDrop;

		 		var boardAdd = document.createElement("div");
		 		boardAdd.setAttribute("class", "add-task task-button");
		 		boardAdd.setAttribute("boardid", $(".add-task").length);
		 		boardAdd.innerText ="+";
		 		boardAdd.onclick=taskAdd;
		 		board.append(boardAdd);
		 			
		 		$(".board-add-button").before(board);	 		
	 
	 });
	
	
});

$('.title-avatar , .right-back').bind('click', function(){
	if($('.right-container').css('display')=='block'){
		$('.right-container').css('display', 'none');
	}else{
		$('.right-container').css('display', 'block');
	}
});

$('.right-body').bind('click',function(){
	$('input:file')[0].click();
	 
});

$('.modal-close-button').bind('click', function(){
  	$('.modal').css('display', 'none'); 
  	$('.modal-board').css('display', 'none'); 
	
  	$('.dim-mask').css('display', 'none'); 
});





function imageRefresh(obj) {
    ext = obj.val().split('.').pop().toLowerCase();

    if( $.inArray(ext, ['png', 'jpg', 'jpeg']) == -1 && obj.val() != '' ) {
        window.alert('png, jpg, jpeg 만 업로드 가능 합니다.');
        obj.attr("type", 'text');
        obj.val('');
        obj.attr("type", "file");
        obj.closest('label').find('input[type=text]').val('');
        return false;
    } else if( $.inArray(ext, ['png', 'jpg', 'jpeg']) != -1 && obj.val() != '' ) {
        var file = obj.prop("files")[0];
        blobURL = window.URL.createObjectURL(file);
        //$("#viewImg").attr('src', blobURL);
     
        try{
        	 var formData = new FormData($("#setAvatar")[0]);
        	   $.ajax({
        	        url:"/setAvatar",
        	        type:'post',
        	        contentType: false,
        	        processData: false,
        	        data:formData,
        	        success:function(){
        	        	   $(".right-body").css("background-image","url('" + blobURL + "')");
        	               $(".title-avatar").attr('src', blobURL); 
        	       }
        	   });
        	
        }catch(e){
        	
        	throw e;
        }
        $(".right-body").slideDown();
    }
}

$( "#startDt" ).datepicker();
$( "#endDt" ).datepicker();