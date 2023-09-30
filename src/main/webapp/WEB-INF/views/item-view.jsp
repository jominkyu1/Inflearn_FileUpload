<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
</head>
<body>
  <h2>상품 조회</h2>
  <hr>
  <p>상품명: ${item.itemName}</p>
  <p>첨부파일: <a href="/attach/${item.id}">${item.attachFile.uploadFileName}</a></p>
  <hr>
  <c:forEach items="${item.imageFiles}" var="imageFile" >
    <img src="/images/${imageFile.storeFileName}" width="300px" >
  </c:forEach>
</body>
</html>