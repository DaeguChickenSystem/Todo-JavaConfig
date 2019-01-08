<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/mosaic.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/dom-to-image/2.6.0/dom-to-image.js"></script>

<script src="/resources/js/mosaic.js"></script>
</head>
<body>

	<div class="mosaic-menu">
		<div class="mosaic-close-button">X</div>
	</div>
	<div class="mosaic-containter">
		<div class="mosaic-left">
			<div class="mosaic-left-top">
				<div class="mosaic-button mosaic-button-common" id="mosaic-preview">미리보기</div>
				<div class="mosaic-button mosaic-button-common" id="mosaic-default">초기화</div>
			</div>
			<div class="mosaic-body-wrappper">
				<div class="mosaic-body" id="mosaic_id"  >
				<div class="mosaic-area" id="mosaic-area_0"></div>
				</div>
<%-- 								<div class="mosaic-body" id="mosaic_id" draggable="true", ondragstart="drag(event)"  id="${item_1.task_id}" ondrop="drop(event)"  ondragover="allowDrop(event)" --%>
			</div>
			<div class="mosaic-result" id="mosaic_result_id"></div>
		</div>
		<div class="mosaic-right">
			<div class="mosaic-sub-title"></div>
			<div class="mosaic-area-share">
				<div class="mosaic-sub-share-area">
    <div class="mosaic-shape-circle mosaic-shape" name="circle"></div>
    <div class="mosaic-shape-square mosaic-shape" name="square"></div>
</div>
			</div>
			<div class="mosaic-sub-title"></div>
			<div class="mosaic-fixel-size">
				<div class="mosaic-sub-fixel-area">
				  <input type="range" min="1" max="3" value="2" id="density" oninput="density()">
				</div>
				<div class="mosaic-sub-fixel-button">
					<div class="mosaic-submit-button mosaic-button-common">적용</div>
					<div class="mosaic-cancel-button mosaic-button-common">취소</div>
				</div>

			</div>

			<!-- <div class="mosaic-convert"></div>
   <div class="mosaic-bottom"></div> -->
		</div>

	</div>


	<!-- <div class="mosaic-containter">
  <div class="mosaic-body" id="mosaic_id"> </div>
  <div class="mosaic-result"  id="mosaic_result_id"> </div>
  <div class="mosaic-convert">Editor</div>
  <div class="mosaic-bottom">Convert</div>
</div>
 -->
 <div class="mosaic-preview" style="
    position: fixed;
    top: 33px;
    display: none;
    left: 0;
    width: 100%;
    background: #efefef;
    height: 100%;
">

  <div class="mosaic-result" id="mosaic_result_id"> </div>
  <div class="mosaic-button mosaic-button-common" id="return-view" 
  style=" 
    /* position: relative; */
    position: fixed;
    bottom: 10%;
    padding-bottom: 5px;
    height: 25px;
    margin-left: 45%;
    /* background-color: #1d9fda; */
">확인</div>
 </div>
 <div class="dim-mask"></div>

</body>

<script>

customMosaic.init({width: 800, height:450, url: '/resources/img/wb.jpg'});

$('#mosaic-default').click(function(e){
	customMosaic.defaultmosaic(1);
});


 $('#mosaic-preview').click(function(){
   $('.dim-mask').css('display','block');
   
 if($('canvas').length>0){
     $('canvas').remove();

 }
   html2canvas(document.querySelector(".mosaic-body")).then(function(canvas){
	   allowTaint: true,
	$('.mosaic-body').css('display', 'none');
	$('.mosaic-preview').css('display', 'block');
		
	$('.mosaic-result').css('left', (1-Number($('.mosaic-result').css('width').replace('px',''))/customMosaic.meta.width)*50+"%" );
	$('.mosaic-result').css('top', (1-Number($('.mosaic-result').css('height').replace('px',''))/customMosaic.meta.width)*20+"%" );
	 
       $('.mosaic-result').append(canvas);
       $('.dim-mask').css('display','none');
   });
 })

$("#return-view").click(function(){
	$('.mosaic-body').css('display', 'block');
    $('.mosaic-preview').css('display', 'none');
})
 
$(".mosaic-shape").click(function(e){

	 $('.dim-mask').css('display','block');	
	 $('.dim-mask').css('display','none');
	
	 customMosaic.selectShape(e.currentTarget.getAttribute('name'));
	 $('.mosaic-shape').css('border','1px solid #1e85d8');
	 $(e.currentTarget).css('border','2px dashed red');
}); 
 

 
function density(){
   	
 

 
}	

$('.mosaic-submit-button').click(function(e){	
	
  	if(Number(document.getElementById('density').value)==2){
   		customMosaic.density=5;
   		$('.mosaic-area').css('flter', 'blur(7px)');
   	}else if(Number(document.getElementById('density').value)==3){
   		customMosaic.density=10;	  
   		$('.mosaic-area').css('flter', 'blur(5px)');
   	}
	
    $('.dim-mask').css('display','block');
/* 	customMosaic.defaultmosaic(2); */
    setTimeout(function(){  $('.dim-mask').css('display','none'); }, 3000);
	
	
});

 $('.mosaic-body-wrappper').click(function(e){
	  if(e.target.className !='mosaic-part'){
	 		 $('.mosaic-area').css("left", 0);
	 		 $('.mosaic-area').css("top", 0);
	 		 $('.mosaic-area').css("width", 0);
	 		 $('.mosaic-area').css("height", 0);
	 }
	
  } 
 ) 
 
</script>
</html>
