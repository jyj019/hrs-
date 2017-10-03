<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<title>员工详细信息</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-12 column">				
				<h1 class="text-center">第${emp.no}号员工详细信息</h1>>
				<hr>
					编号：${emp.no}
					<br><br>
					姓名：${emp.name}
					<br><br>
					性别：${emp.sex?"男":"女"}
					<br><br>
					职位：${emp.job}
					<br><br>
					主管：${emp.mgr.equals(null)?"无":emp.mgr.name}
					<br><br>
					工资：${emp.salary}
					<br><br>
					状态：${emp.status?"在职":"离职"}
					<br><br>
					联系方式：${emp.tel}
					<br><br>
					部门编号：${emp.dept.no}
					<br><br>
					部门名称：${emp.dept.name}
					<br><br>
					部门地址：${emp.dept.location}
					<br><br>
					照片:${emp.photo}
					<div class="col-md-12 column">
						<img src="images/${emp.photo}">
					</div>
					<br><br>
				<a href="dept"><font size="4" color="blue">返回部门列表</font></a>&nbsp;
			</div>
		</div>
	</div>
	<!--jQuery(性能好)/Zepto.js(体积小)-->
</body>
</html>