<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<title>员工信息</title>
</head>
<body>
<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h1>${dept.name}员工信息</h1>
				<div style="color:red;fontsize:12px" >${hint}</div>
				<hr>
				<input type="hidden" name="dno" value="${dept.no}">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>职位</th>
							<th>状态</th>
							<th>电话</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="empInfo">
					</tbody>
				</table>
				<div align="center">
					<a id="first">首页</a>&nbsp;&nbsp;
					<a id="prev">上一页</a>&nbsp;&nbsp;
					<a id="next">下一页</a>&nbsp;&nbsp;
					<a id="last">末页</a>
				</div>

				<a href="dept"><font size="4" color="blue">返回部门列表</font></a>&nbsp;
				<a href="add_emp.jsp?dno=${dept.no}"><font size="4" color="blue">新增员工</font></a>
			</div>
		</div>
	</div>
	<!--jQuery(性能好)/Zepto.js(体积小)-->
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script>
		function deleteEmp(eno){
			if(confirm("确定删除该员工?")){
				$.ajax({
					url:'delEmp?eno='+eno,
							success:function(data){
								if(data.indexOf('success')>=0){
									loadDataModel(1)
								}
							}
				});
			}
		}
		//data即为json对象
		$(function() {
			loadDataModel(1);			
		});
		function loadDataModel(page){
			$.getJSON("emp",{"page":page},function(json){
				var empList=json.dataModel;
				var prevPage=json.currentPage-1;
				var nextPage=json.currentPage+1;
				var lastPage=json.totalPage;
				if(json.currentPage>1){
					$("#first").attr("href","javascript:loadDataModel(1)");
					$("#prev").attr("href","javascript:loadDataModel("+prevPage+")");
				}else{
					$("#first").removeAttr("href");
					$("#prev").removeAttr("href");
				}
				if(json.currentPage<json.totalPage){
					$("#next").attr("href","javascript:loadDataModel("+nextPage+")");
					$("#last").attr("href","javascript:loadDataModel("+lastPage+")");
				}else{
					$("#next").removeAttr("href");
					$("#last").removeAttr("href");
				}
				$("#empInfo tr").remove();
				//$("#empInfo tr:gt(0)").remove();
				for(var i=0;i<empList.length;++i){
					var emp=empList[i];
					var tr=$("<tr>")
					.append($("<td>").text(emp.no))
					.append($("<td>").text(emp.name))
					.append($("<td>").text(emp.sex?"男":"女"))
					.append($("<td>").text(emp.job))
					.append($("<td>").text(emp.status?"在职":"离职"))
					.append($("<td>").text(emp.tel))
					.append($("<td>")
								.append($("<a>").text("详情").attr("href","empDetail?eno="+emp.no))
								.append("&nbsp;&nbsp;")
								.append($("<a>").text("编辑").attr("href", "edit_emp.jsp?eno="+emp.no))
								.append("&nbsp;&nbsp;")
								.append($("<a>").text("删除")
										.attr("href", "javascript:deleteEmp("+emp.no+")"))
						);
					$("#empInfo").append(tr);	
				}
			});
		}
		//https://10.7.189.200/svn/HelloRepo/  helloKitty 123123
		/*<!--<button id="firstBtn" class="btn btn-info" type="button" disabled>首页</button>				
		<button id="prevBtn" class="btn btn-info" type="button" disabled>上一页</button>
		<button id="nextBtn" class="btn btn-info" type="button" disabled>下一页</button>
		<button id="lastBtn" class="btn btn-info" type="button" disabled>末页</button> -->
		/*$(function() {
			if (${currentPage > 1}) {
				$('#firstBtn').removeAttr('disabled');
				$('#prevBtn').removeAttr('disabled');
			}	
			if (${currentPage < totalPage}) {
				$('#nextBtn').removeAttr('disabled');
				$('#lastBtn').removeAttr('disabled');
			}
			//访问部门编号的第几页
			var baseUrl = 'emp?dno=' + ${dept.no} + '&page=';
			$('#firstBtn').on('click', function() {
				$(this).attr('disabled', 'disabled');
				$('#prevBtn').attr('disabled', 'disabled');
				location.href = baseUrl + '1';
			});
			//gt>    ge>=   eq=   lt<  
			$('#prevBtn').on('click', function() { 
				if (${currentPage - 1 eq 1}) {
					$('#firstBtn').attr('disabled', 'disabled');
					$(this).attr('disabled', 'disabled');
				}
				location.href = baseUrl + ${currentPage - 1};
			});
			$('#nextBtn').on('click', function() { 
				if (${currentPage + 1 eq totalPage}) {
					$('#nextBtn').attr('disabled', 'disabled');
					$('#lastBtn').attr('disabled', 'disabled');
				}				
				location.href = baseUrl + ${currentPage + 1};
			});
			$('#lastBtn').on('click', function() {
				$('#nextBtn').attr('disabled', 'disabled');
				$('#lastBtn').attr('disabled', 'disabled');
				location.href = baseUrl + ${totalPage};
			});
		}); */
	</script>
</body>
</html>