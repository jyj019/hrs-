<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<title>修改部门</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
			<h1>修改第${param.dno}号部门</h1>
			<div style="color:red;fontsize:12px" >${hint}</div>
			<hr>
			<form action="editDept" method="post">	
			<input type="text" name="name" placeholder="更改部门名字">
			<br><br>
			<input type="text" name="location" placeholder="更改部门地址">
			<br><br>
			<input type="hidden" name="dno" value="${param.dno}">
			<input type="submit" value="确认更改部门">
			<br><br>
			<a href="dept"><font size="4" color="blue">返回部门列表</font></a>
			</form>	
			</div>
		</div>
	</div>
</body>
</html>