<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<div style="width: 25vw; border: 1px solid lightslategrey">
  <div style="background-color: lightgrey; text-align: center">
    <h2>상품 등록</h2>
  </div>
  <hr>
  <form method="post" enctype="multipart/form-data">
    <ul>
      <li>상품명: <input type="text" name="itemName"></li>
      <li>첨부파일: <input type="file" name="attachFile"></li>
      <li>첨부이미지: <input type="file" name="imageFiles" multiple="multiple"></li>
    </ul>
    <input type="submit" value="등록">
  </form>
</div>
</body>
</html>