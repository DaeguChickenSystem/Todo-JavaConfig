<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<input type="hidden" id="boardIdx" name="boardIdx">
<div class="modal-close-button">X</div>
<div class="modal-container">
	
	
    <div class="boardTitle">
<div class="modal-title-text">◎ BOARD TITLE</div>
     <input type="text" id="board-title-input">
    </div>

	<div class="modal-submit-button board-submit" >SUBMIT</div>
</div>
<div class="board-join-container" >
	<div class="boardGroup" >
   <div class="modal-title-text">◎ SHARE</div>
<input type="text" id="board-share-input">
<div class="autoComplete"> 
</div>

<div class="boardPeople">
    <div class="boardPerson" >
<div class="boardP">    
    <img class="avatar"  src="/resources/img/bin.png">
     <div class="avatarNm">아무개</div>
   </div>
    </div>
	
</div>
<script>
$('#board-share-input').bind('click', function(){ 


	var people= ['a','b','c','d','e'];

	if($('.autoResult').length==0){
	for(var i=0; i<people.length; i++){

	var result = document.createElement('div');
		result.setAttribute('class', 'autoResult');
		result.textContent = people[i];
		result.onclick = function(e){
			console.log(e.target.innerText);	
			$(".autoComplete").empty();
		};
	
		
	$('.autoComplete').append(result);
	}
	}
})

$('.autoResult').bind('click',function(e){
 console.log(e.target.text);
})



</script>