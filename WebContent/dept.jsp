<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<title>部门列表</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-12 column">
				<h1 class="text-center">部门信息</h1>
				<div style="color:red;fontsize:12px" >${hint}</div>
				<hr>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>部门编号</th>
							<th>部门名称</th>
							<th>部门地址</th>
							<th>进行操作</th>
						</tr>
					</thead>		
					<!-- jstl(jsp标准标签库) -->
					<tbody>
						<c:forEach items="${deptList}" var="dept">
							<tr id="tr${dept.no}" class="info">
								<td>${dept.no}</td>
								<td>
									<a href="toEmp?dno=${dept.no}">${dept.name}</a>
								</td>
								<td>${dept.location}</td>
								<td><a href="edit_dept.jsp?dno=${dept.no}">修改</a>&nbsp;
								<a href="javascript:deleteDept(${dept.no})">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="login.jsp"><font size="4" color="darkblue">返回登录</font></a>&nbsp;
				<a href="add_dept.jsp"><font size="4" color="darkblue">新增部门</font></a>
				
			</div>
		</div>
	</div>
	<!--jQuery(性能好)/Zepto.js(体积小)-->
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script>
	function deleteDept(dno){
			if(confirm("确定删除该部门?")){
				$.ajax({
					url:'delDept?dno='+dno,
							success:function(data){
								if(data.indexOf('success')>=0){
									$('#tr'+dno).remove();
								}
							}
				});
			}
	}
		/*
		var xhr=new XMLHttpRequest();
					if(!xhr){
						xhr=new ActiveXObject('MSHTTP.XML')
					}
					if(xhr){
					xhr.open('get','delDept?no='+no,true);
					xhr.onreadystatechange=function(){
						//状态码为200（成功）
						if(xhr.readyState==4&&xhr.status==200){
							if(xhr.responseText.indexOf("sucess")>=0){
								var tr=document.getElementById('tr'+no);								tr.parentNode.removeChild(tr);
							}							
							}
						};
						xhr.send();
					}else{
						alert("你可能使用了垃圾浏览器");
					}*/
	</script>
</body>
</html>