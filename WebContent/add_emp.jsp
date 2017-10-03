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
<title>增加员工</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
			<h1>新增${dept.name}的员工</h1>
			<div style="color:red;fontsize:12px" >${hint}</div>
			<hr>
				<form action="addEmp" method="post" enctype="multipart/form-data">
					<fieldset>	
						<input type="number"  name="no" required placeholder="请输入员工编号">
						<br><br>
						<input type="text" name="name" placeholder="请输入员工名字">	
						<br><br>
						<input type="radio" name="sex" value="1" checked>男
						<input type="radio" name="sex" value="0">女
						<br><br>
						<input type="text" name="job" placeholder="请输入员工职位 "  value="23">	
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
						<input type="hidden" name="dno" value="${dept.no}">
						<input type="submit" value="确定">
						<br><br>
						<a href="toEmp?dno=${dept.no}">
							<font size="4" color="blue">返回${dept.name}的员工列表</font>
						</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script>
		/*
		//正则表达式定义字符的匹配模式
		var uid="jackfrued";
		//regular exp    new RegExp();    [a-zA-Z0-9_]    \w    字母数字下划线          \D   不是数字
		var regex=/^\w{6,20}$/;		//用户名
		var regex=/^1[34578]\d{9}$/;//电话号码
		var regex=/^[1-9]\d{4,}$/;	//QQ
		//var uid="shit123";  alert(regex.test(uid));  
		*/
		$(function(){
			$('#photo').on('change',function(){
				if(window.FileReader){
					var file=this.files[0];
					//MIME类型  Multipurpose Internet Mail Extension
					//image/jpeg  image/png  image/gif  text/xml   application/pdf  audio/xxx  video/xxx
					if(/image\/\w+/.test(file.type)){
						var fr=new FileReader();
					
					fr.onloadend=function(evt){
						$('#photoPreview').attr('src',evt.target.result);
					};
					fr.readAsDataURL(file);
					}else{
						$(this).val('');
						$('#photoPreview').attr('src','');
						alert("请选着图片文件！");
					}
			}else{
					alert("浏览器部不支持文件预览！");
				}
			});	
		});
	</script>
</body>
</html>