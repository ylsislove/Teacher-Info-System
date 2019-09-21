<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>基本信息</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>

		<style type="text/css">
			body{
				background-color: #EDEFF0;
			}
			.main{
				background-color: #fff;
				box-shadow: 0 4px 8px 0 rgba(0, 0, 0, .1);
				width: 800px;
				height: 2500px;
				margin: 20px auto;
				overflow: hidden
			}
			.contentBox{
				width: 680px;
				margin: auto;
				border-top: 1px solid #b7bbbf;
				position: relative;
				top: 45px;
				padding-top: 30px
			}
		</style>


	</head>

	<body>
		<div class="main">
			<div class="contentBox">
				
				<fieldset class="layui-elem-field">
					<legend>基本信息&nbsp;&nbsp;&nbsp;
						<button type="button" class="layui-btn layui-btn-primary layui-btn-xs"
								onclick="x_admin_show('编辑基本信息','${pageContext.request.contextPath }/memberEditShow.action?userId=${user.userId }&role=user',800,500)">
							<i class="layui-icon">&#xe642;</i> 编辑
						</button>
						<button type="button" class="layui-btn layui-btn-primary layui-btn-xs">
							<i class="layui-icon">&#xe601;</i> 导出
						</button>
					</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup><col width="40%"></colgroup>
							<tbody>
								<tr>
									<th>工号</th>
									<td>${user.userId }</td>
								</tr>
								<tr>
									<th>单位</th>
									<td>${user.department }</td>
								</tr>
								<tr>
									<th>姓名</th>
									<td>${user.username }</td>
								</tr>
								<tr>
									<th>英文名</th>
									<td>${user.enname }</td>
								</tr>
								<tr>
									<th>性别</th>
									<td>${user.sex }</td>
								</tr>
								<tr>
									<th>出生年月</th>
									<td>${user.birth }</td>
								</tr>
								<tr>
									<th>参加工作时间</th>
									<td>${user.worktime }</td>
								</tr>
								<tr>
									<th>入党时间</th>
									<td>${user.parttime }</td>
								</tr>
								<tr>
									<th>职务</th>
									<td>${user.position }</td>
								</tr>
								<tr>
									<th>职称</th>
									<td>${user.title }</td>
								</tr>
								<tr>
									<th>评职时间</th>
									<td>${user.titletime }</td>
								</tr>
								<tr>
									<th>岗位类别</th>
									<td>${user.worktype }</td>
								</tr>
								<tr>
									<th>岗位等级</th>
									<td>${user.worklevel }</td>
								</tr>
								<tr>
									<th>个人荣誉称号</th>
									<td>${user.honorarytitle }</td>
								</tr>
								<tr>
									<th>社会与学术兼职</th>
									<td>${user.parttimejob }</td>
								</tr>
								<tr>
									<th>常用邮箱</th>
									<td>${user.email }</td>
								</tr>
								<tr>
									<th>密码</th>
									<td>${user.password }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</fieldset>

				<fieldset class="layui-elem-field" style="margin-top: 40px;">
					<legend>教育经历&nbsp;&nbsp;&nbsp;
						<button type="button" class="layui-btn layui-btn-primary layui-btn-xs"
								onclick="x_admin_show('编辑教育经历','${pageContext.request.contextPath }/experienceEditShow.action?type=1',800,400)">
							<i class="layui-icon">&#xe642;</i> 编辑
						</button>
						<button type="button" class="layui-btn layui-btn-primary layui-btn-xs">
							<i class="layui-icon">&#xe601;</i> 导出
						</button>
					</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="17%">
								<col width="17%">
								<col>
								<col width="17%">
								<col width="17%">
							</colgroup>
							<thead>
							<tr>
								<th>入学时间</th>
								<th>毕业时间</th>
								<th>学校名称</th>
								<th>专业名称</th>
								<th>导师</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${eduList }" var="edu">
								<tr>
									<td>${edu.academicDate}</td>
									<td>${edu.graduationDate}</td>
									<td>${edu.schoolName}</td>
									<td>${edu.majorName}</td>
									<td>${edu.tutorName}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</fieldset>

				<fieldset class="layui-elem-field" style="margin-top: 40px;">
					<legend>出国经历&nbsp;&nbsp;&nbsp;
						<button type="button" class="layui-btn layui-btn-primary layui-btn-xs"
								onclick="x_admin_show('编辑出国经历','${pageContext.request.contextPath }/experienceEditShow.action?type=2',800,400)">
							<i class="layui-icon">&#xe642;</i> 编辑
						</button>
						<button type="button" class="layui-btn layui-btn-primary layui-btn-xs">
							<i class="layui-icon">&#xe601;</i> 导出
						</button>
					</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="17%">
								<col width="17%">
								<col>
								<col width="17%">
								<col width="17%">
							</colgroup>
							<thead>
							<tr>
								<th>出国时间</th>
								<th>回国时间</th>
								<th>访问单位</th>
								<th>专业名称</th>
								<th>合作导师</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${abroadList }" var="abroad">
								<tr>
									<td>${abroad.abroadDate}</td>
									<td>${abroad.backDate}</td>
									<td>${abroad.departmentName}</td>
									<td>${abroad.majorName}</td>
									<td>${abroad.tutorName}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</fieldset>

				<fieldset class="layui-elem-field" style="margin-top: 40px;">
					<legend>工作经历&nbsp;&nbsp;&nbsp;
						<button type="button" class="layui-btn layui-btn-primary layui-btn-xs"
								onclick="x_admin_show('编辑工作经历','${pageContext.request.contextPath }/experienceEditShow.action?type=3',800,400)">
							<i class="layui-icon">&#xe642;</i> 编辑
						</button>
						<button type="button" class="layui-btn layui-btn-primary layui-btn-xs">
							<i class="layui-icon">&#xe601;</i> 导出
						</button>
					</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="18%">
								<col width="18%">
								<col>
								<col width="25%">
							</colgroup>
							<thead>
							<tr>
								<th>入职时间</th>
								<th>离职时间</th>
								<th>工作单位</th>
								<th>岗位/职位</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${workList }" var="work">
								<tr>
									<td>${work.workDate}</td>
									<td>${work.leaveDate}</td>
									<td>${work.departmentName}</td>
									<td>${work.workName}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</fieldset>
				
			</div>
		</div>
	</body>

</html>
