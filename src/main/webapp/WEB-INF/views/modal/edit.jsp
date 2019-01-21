<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<input type="hidden" id="taskId" name="taskId">
<input type="hidden" id="boardIdx" name="boardIdx">
<div class="modal-close-button">X</div>
<div class="modal-container">
	<div class="modal-title">
		<div class="modal-title-text">◎ TITLE </div>
		<input class="modal-title-input" id="title">
	</div>
	<div class="modal-contents">
		<div class="modal-contents-text" id="content">◎ CONTENTS </div>
		<div class="modal-contents-input" id="editor">  </div>

		<div class="modal-contents-calender">
			<div class="modal-title-text">◎ CALENDAR</div>
			<div class="modal-calendar-div">
			<div class="startDt date-div">Start Date</div> 
			<input type="text" id="startDt" class="cal-div">
			</div>
			<div class="modal-calendar-div">
			<div class="startDt date-div" >End Date</div>
			<input type="text" id="endDt" class="cal-div">
			
			</div>
		</div>
	</div>


	<div class="modal-submit-button task-submit">SUBMIT</div>
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
$( "#startDt" ).datepicker();
$( "#endDt" ).datepicker();

InlineEditor
.create( document.querySelector( '#editor' ) )
.then( editor => {
	console.log(editor);
   ekEditor = editor;
} )
.catch( error => {
    console.error( error );
} );
</script>
