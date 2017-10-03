<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<title>用户注册</title>
</head>
<body>
	<h1>用户注册</h1>
	<div style="color:red;fontsize:12px" >${hint}</div>
	<hr><form action="register" method="post">
		<input type="text" name="username" placeholder="请输入用户名">
		<br><br>
		<input type="password" name="password" placeholder="请输入密码">
		<br><br>
		<input type="password" name="passwordAgain" placeholder="请再次输入密码">
		<br><br>
		<input type="text" name="email" placeholder="请输入邮箱">
		<br><br>
		<input type="submit" value="注册">
		<br>
	</form>
	<a href="login.jsp">返回登录</a>
</body>
</html>