<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="/resources/js/unitTest.js"></script>
</head>
<body>
<div class="main-container" ondragover="allowDrop(event)">
 <div class="main-menu">
  <div class="title"></div> 
  <img class="title-avatar" src="/resources/img/bin.png">
 </div>
 <div class="main-body">
  <div class="task-board">


  
 <c:forEach var="item_0" items="${result}" varStatus="i">
  <div class="task-depth-0" ondrop="drop(event)"  ondragover="allowDrop(event)">
   <c:forEach var="item_1" items="${item_0}" varStatus="status" >
    <div class="task-depth-1 task-button state-${item_1.status}" boardid=${i.index} draggable="true", ondragstart="drag(event)"  id="${item_1.task_id}" ondrop="drop(event)"  ondragover="allowDrop(event)">
    
      <div class="task-count"></div>
      <div class="task-title"> ${item_1.title}  </div>
      <div class="task-info" >
        <img class="task-avatar" src="/resources/img/man.png"/>
      </div>      
    </div>
   </c:forEach>
   <div class="add-task task-button"  boardid=${i.index}>+</div>
  </div>
</c:forEach>
<div class="board-add-button">+</div>

  </div> 
 </div>
 <div class="side-wall"></div>
 <div class="dim-mask"></div>
 <div class="modal-box">
<!--  <div class="modal-error" >
        <div class="modal-error-msg" ></div>
        <div class="modal-error-button">CONFRIM</div>
 </div> -->
 
  <div class="modal">
       <jsp:include page="./modal/edit.jsp"/>
  </div>
  <div class="modal-board">
        <jsp:include page="./modal/board.jsp"/> 
 </div>
 
  <jsp:include page="./common/right.jsp"/>
 
</div>
</body>
<script src="/resources/js/common.js"></script>
<script>
 (function(){
	 var taskEdit = new customModal();
	     taskEdit.init({target:'task-title', url:'/modal', custom: true});
	     taskEdit.build(modalCommon);
 })();

</script>
</html>