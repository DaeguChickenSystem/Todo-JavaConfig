<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/common.js"></script>
<meta charset="EUC-KR">
<title>login</title>
</head>
<body src="/resources/img/background.jpg">
 <div class="main-container">
  <div class="login-wrapper">
   <div class="login-head"></div>
   <div class="login-body">
    <div class="id-input">
    <input id="id-input"/>
    </div>
   <!--  <div class="pw-input">
    <input id="pw-input"/>
    </div> -->
   </div>
   <div class="login-bottom">
     SUBMIT
   </div>  
   </div> 
 </div>

</body>
<script>
$('.login-bottom').bind('click', function(){	
	commonAjax({url:'/loginProcess', type: 'POST', param:{"id":$("#id-input").val()}}, function(){ window.location.href = '/main';})
});

</script>
</html>