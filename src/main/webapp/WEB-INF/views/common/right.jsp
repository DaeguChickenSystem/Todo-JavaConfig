<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="right-container">
<div class="right-back"> ◁ </div>
<div class="right-body">
  <div class="profile-avatar">

   <form action="setAvatar" id="setAvatar" method="post"  enctype="multipart/form-data">
     <input type="file" id="avatar-input" style="display: none;" onchange="rightChange(this)">
    </form> 
  </div>
</div>
<!-- <div class="right-bottom">
 <div class="right-button">확인</div>
</div> -->
</div>
<script>

$("#avatar-input").on('change', function(){ imageRefresh($(this)); });

function rightChange(arg){
	console.log(arg);
	
}

</script>