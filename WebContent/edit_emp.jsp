<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>
	#photoprivew{
		border:1px dashed #ccc;
		dispaly:block;
	}
</style>
<title>修改员工</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h1>修改${dept.name}编号为${param.eno}的员工</h1>
				<div style="color:red;fontsize:12px" >${hint}</div>
				<hr>
				<form action="editEmp" method="post" enctype="multipart/form-data">
					<fieldset>	
						<input type="text" name="name" placeholder="请输入员工名字">	
						<br><br>
						<input type="radio" name="sex" value="1" checked>男
						<input type="radio" name="sex" value="0">女
						<br><br>
						<input type="text" name="job" placeholder="请输入员工职位 "  value="23">	
						<br><br>
						<input type="radio" name="status" value="1" checked>在职
						<input type="radio" name="status" value="0">离职
						<br><br>
						<input type="number" name="salary" placeholder="请输入员工月薪" value="500">	
						<br><br>
						<input type="date" name="hiredate" >&nbsp;必选
						<br><br>
						<input id="photo" type="file" name="photo">	
						<img id="photoPreview" src="" alt="" width="300">
						<br><br>
						<input type="tel" name="tel" placeholder="请输入员工电话">
						<br><br>
						<input type="text" name="dno" placeholder="请输入部门编号" value="${dept.no}">
						<input type="hidden"  name="eno"  value="${param.eno}">
						<br><br>
						<input type="submit" value="确定">
						<br><br>					
						<a href="toEmp?dno=${dept.no}">
							<font size="4" color="blue">
							返回${dept.name}的员工列表
							</font>
						</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>