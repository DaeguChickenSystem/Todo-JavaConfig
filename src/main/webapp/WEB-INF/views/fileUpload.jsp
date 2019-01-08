<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BORAJI.COM</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>

  <h1>Spring MVC - File Upload Example</h1>
  <hr />

  <h3>Single file Upload</h3>
  <form action="fileUpload" id="uploadTest" method="post" enctype="multipart/form-data">
    <table>
      <tr>
        <td>Select File</td>
        <td><input type="file" name="file"></td>
        <td><button type="submit">Upload</button></td>
      </tr>
    </table>
  </form>
  <br />
  <hr />
  <h3>Multiple file Upload</h3>
  <form action="fileUpload" method="post" enctype="multipart/form-data">
    <table>
      <tr>
        <td>Select Files</td>
        <td><input type="file" name="file" multiple="multiple"></td>
        <td><button type="submit">Upload</button></td>
      </tr>
    </table>
  </form>
  <br>
  <hr />
  <span style="color: red; font-size: 14px;">${msg}</span>

</body>
</html>
