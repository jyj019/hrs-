<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<title>增加部门</title>


</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12" >
				<h1>新增部门</h1>
				<div style="color:red;fontsize:12px" >${hint}</div>
				<hr>	
				<form action="addDept" method="post">
				<input type="number" max="99" name="dno" required placeholder="新增部门编号">
				<br><br>
				<input type="text" name="name" required placeholder="新增部门名字">
				<br><br>
				<input type="text" name="location" required placeholder="新增部门地址">
				<br><br>
				<input type="submit" value="新增部门">
				</form>
				<a href="dept"><font size="4" color="blue">返回部门列表</font></a>
			</div>
		</div>
	</div>
</body>
</html>