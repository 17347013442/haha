<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="springmvc02/testUpload" method="post" enctype="multipart/form-data">
<input type="file" name="uploads" multiple="multiple">
名字:<input type="text" name="uname" >
<input type="submit" name="登录">
</form>
</body>
</html>