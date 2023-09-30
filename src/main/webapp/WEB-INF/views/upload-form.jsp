<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
</head>
<body>
<h1>File upload form</h1>
<form method="post" action="/spring/upload" enctype="multipart/form-data">
  <c:if test="${!empty fileok}">
    <h2>${fileok}</h2>
    <hr>
  </c:if>
  <ul>
    <li>상품명: <input type="text" name="itemName"></li>
    <li>파일: <input type="file" name="file"></li>
  </ul>
  <input type="submit" value="OK">
</form>
</body>
</html>