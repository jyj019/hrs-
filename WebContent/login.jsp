<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<title>用户登录</title>
</head>
<body>
	<h1>用户登录</h1>
	<div style="color:red;fontsize:12px" >${hint}</div>
	<hr>
	<form action="login" method="post">
		<input type="text" name="username" placeholder="请输入用户名">
		<br><br>
		<input type="password" name="password" placeholder="请输入密码">
		<br><br>
		<input type="submit" value="登录">
	</form>
	<a href="register.jsp">现在就注册</a>
</body>
</html>