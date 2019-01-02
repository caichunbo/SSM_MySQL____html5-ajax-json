<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户页面</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/page/add.do">注册</a>&nbsp;<br/>
<a href="index_JSON.jsp">json请求+AJAX</a>&nbsp;<br/>

<form action="${pageContext.request.contextPath}/user/getUser.do" method="post">
	id:<input type="text" name="id" value="输入id"/><br/>
	<input type="submit" value="提交"/><br/>
</form>

<h1>-----------------------登录---------------------------------</h1>
<form action="${pageContext.request.contextPath}/user/login.do" method="post">
	userName:<input type="text" name="userName" value="${userName}"/><br/>
	passWord:<input type="password" name="passWord" value="${passWord}"/><br/>
	<input type="submit" value="登录"/><br/>
</form>



</body>
</html>