<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<input type="hidden" id="taskId" name="taskId" value=${result.task_id}>
<input type="hidden" id="boardIdx" name="boardIdx" value=${board_idx}>
<div class="modal-close-button">X</div>
<div class="modal-container">
	<div class="modal-title">
		<div class="modal-title-text">◎ TITLE </div>
		<input class="modal-title-input" id="title" value= ${result.title}>
	</div>
	<div class="modal-contents">
		<div class="modal-contents-text" id="content">◎ CONTENTS </div>
		<textarea class="modal-contents-input" >${result}  </textarea>

		<div class="modal-contents-calender">
			<div class="modal-title-text">◎ CALENDAR</div>

			<div class="startDt"></div>
			<div class="endDt"></div>
		</div>
	</div>


	<div class="modal-submit-button">SUBMIT</div>
</div>
<div class="particle-container"
	style="position: relative; width: 48%; float: left; margin-left: 1%; height: 96%; /* border: 1px solid #e2dada; */ background-color: #607d8b12;">
	<div class="tabs" style="width: 100%; height: 5%; position: relative;"></div>
	<div class="particle-type"
		style="width: 100%; height: 95%; position: relative; overflow-y: auto;">



		<div class="particle"
			style="width: 97%; height: 25%; margin-left: 1.5%; position: relative; margin-bottom: 1%; margin-top: 1%; overflow-y: auto; border-radius: 2%; /* box-shadow: 2px 2px 2px 2px #9e9d9d; */ background: #FFC107;">
			<div class="particle-title"
				style="position: relative; width: 97% 5;
	/* border: 1px solid gray; */ height: 20%; font-size: small; padding-left: 3%; margin: 1%; font-weight: bold">
				이미지</div>
			<div class="particle-body"
				style="position: relative;
	/* width: 97%; */ border-top: 1px solid #e8e8e8; height: 66%; margin: 1%;"></div>

		</div>

		<div class="particle"
			style="width: 97%; height: 25%; margin-left: 1.5%; position: relative; margin-bottom: 1%; margin-top: 1%; overflow-y: auto; border-radius: 2%; /* box-shadow: 2px 2px 2px 2px #9e9d9d; */ background: #FFC107;">
			<div class="particle-title"
				style="position: relative; width: 97% 5;
	/* border: 1px solid gray; */ height: 20%; font-size: small; padding-left: 3%; margin: 1%; font-weight: bold">
				영상</div>
			<div class="particle-body" style="position: relative; border-top: 1px solid #e8e8e8; height: auto; margin: 1%;">
			</div>
		</div>
		<div class="particle"
			style="width: 97%; height: 25%; margin-left: 1.5%; position: relative; margin-bottom: 1%; margin-top: 1%; overflow-y: auto; border-radius: 2%; /* box-shadow: 2px 2px 2px 2px #9e9d9d; */ background: #FFC107;">
			<div class="particle-title"
				style="position: relative; width: 97% 5;
	/* border: 1px solid gray; */ height: 20%; font-size: small; padding-left: 3%; margin: 1%; font-weight: bold;">
				링크</div>
			<div class="particle-body"
				style="position: relative;
	/* width: 97%; */ border-top: 1px solid #e8e8e8; height: 66%; margin: 1%;"></div>

		</div>
	</div>
</div>

<script>
$('.modal-close-button').bind('click', function(){
          	$('.modal').css('display', 'none'); 
      		$('.dim-mask').css('display', 'none'); 
});

$('.modal-submit-button').bind('click', function(){

	 var param = {index: $('#boardIdx').val() , task_id: $('#taskId').val(), title: $($('.modal-title-input')[0]).val(), content: $($('.modal-contents-input')[0]).val() }
	 
	 commonAjax({url: '/taskUpdate', 
		         type: 'POST',
		         param: param , 
    	         function(data){     
		   			console.log(data);
    	   	     /* $('.modal-close-button').trigger('click'); */
    		
			var task_depth = $($('.task-depth-1')[0]).clone();
			task_depth.find('.task-count');
			task_depth.find('.task-title').text($($('.modal-title-input')[0]).val());
			task_depth.find('.task-info');
		    task_depth.ondrag=drop;
		    task_depth.ondragover=allowDrop;
		    
		    $($('div[boardid='+$('#boardIdx').val()+']')[$('div[boardid='+$('#boardIdx').val()+']').length-1]).before(task_depth);
		    
         }  
	   });
});

</script>