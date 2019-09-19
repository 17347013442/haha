<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="springmvc/testMethod" method="POST">
<input type="submit" value="提交">
</form>

<form action="springmvc/taget/12" method="POST">
<input type="hidden" name="_method" value="DELETE">
<input type="submit" value="delete 提交">
</form>

<form action="springmvc/taget/13" method="POST">
<input type="hidden" name="_method" value="put">
<input type="submit" value="update 提交">
</form>

<form action="springmvc/testpo?age=12" method="POST">
<input type="text" name="uname" value="">
<input type="text" name="pwd" value="">
<input type="text" name="addr.area" value="">
<input type="submit" value="po 提交">
</form>
<a href="springmvc/testSessionAbttribute">testSessionAbttribute</a></br>
<a href="springmvc/requestparmdad?username=asd">requestparm</a>


<form action="springmvc/testModelAttribute?age=12" method="POST">
<input type="text" name="uname" value="">

<input type="text" name="addr.area" value="">
<input type="submit" value="req 提交">
</form>
</body>
</html>