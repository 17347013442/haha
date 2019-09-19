<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="springmvc02/testmodelandview">testmodelandview</a></br>
<input type="button" value="ajxs" id="btn">
<a href="springmvc02/testException">testException</a></br>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">

$('#btn').click(function(){
	//alert("hahhaha");
	


	
	$.ajax({
	  url:"springmvc02/testAjax",
	 type:"POST",
	  data:'{"uname":"zhangsan","pwd":"a"}',//json格式
	  contentType:"application/json; charset=utf-8",//发送json格式内容
	  dataType:"json",//返回json格式内容
	 success: function(data){
		console.log(data);
			
	  }})
	
	
	
	
	
	
	//$.ajax({
		//  url:"springmvc02/testAjax",
		//  type:"POST",
		//  data:{uname:"zhangsan",pwd:"a"},
		//  contentType:"application/json; charset=utf-8",
		 // dataType:"json",
		 // success: function(data){
		//	console.log(data);
				
		//  }});
	
});
</script>
</html>