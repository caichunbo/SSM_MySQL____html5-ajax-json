<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
<script>
	function fun(){
		alert("确认返回登录页面");
/* 		location.href ="http://localhost:8080/mybatis06-spring-springmvc/index.jsp";
 */		
 		window.history.go(-2);
	}
	
</script>
</head>
<body>
<input type="button" value="注册成功，返回登录页面" onclick="fun()"/>

</body>
</html>