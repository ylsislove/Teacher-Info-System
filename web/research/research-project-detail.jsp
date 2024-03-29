<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>项目详情</title>
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
			body {
				background-color: #EDEFF0;
			}

			.layui-elem-field {
				margin-top: 30px;
			}

			.main {
				background-color: #fff;
				box-shadow: 0 4px 8px 0 rgba(0, 0, 0, .1);
				width: 800px;
				height: 1200px;
				margin: 20px auto;
				overflow: hidden
			}

			.contentBox {
				width: 680px;
				margin: auto;
				border-top: 1px solid #b7bbbf;
				position: relative;
				top: 45px;
				padding-top: 10px;
			}
		</style>

	</head>

	<body>
		<div class="main">
			<div class="contentBox">

				<fieldset class="layui-elem-field">
					<legend>基本信息</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="45%">
							</colgroup>
							<tbody>
								<tr>
									<th>起始时间</th>
									<td>${project.startDate}</td>
								</tr>
								<tr>
									<th>截止时间</th>
									<td>${project.endDate}</td>
								</tr>
								<tr>
									<th>项目编号</th>
									<td>${project.projectId}</td>
								</tr>
								<tr>
									<th>项目名称</th>
									<td>${project.title}</td>
								</tr>
								<tr>
									<th>项目来源</th>
									<td>${project.source}</td>
								</tr>
								<tr>
									<th>项目类型</th>
									<td>${project.levelType}</td>
								</tr>
								<tr>
									<th>项目级别</th>
									<td>${project.level}</td>
								</tr>
								<tr>
									<th>项目合同经费</th>
									<td>${project.contractFunds}</td>
								</tr>
								<tr>
									<th>实际到账经费</th>
									<td>${project.actualFunds}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</fieldset>

				<fieldset class="layui-elem-field" style="margin-top: 40px;">
					<legend>项目成员</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="33%">
								<col width="33%">
								<col>
							</colgroup>
							<thead>
							<tr>
								<th>姓名</th>
								<th>是否为我校教师</th>
								<th>教师工号</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${memberList }" var="member">
								<tr>
									<td>${member.memberName}</td>
									<td>${member.isOurTeacher}</td>
									<td>${member.userId}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</fieldset>

				<fieldset class="layui-elem-field">
					<legend>参与单位</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="40%">
							</colgroup>
							<tbody>
							<c:forEach items="${unitList }" var="unit">
								<tr>
									<th>完成单位</th>
									<td>${unit.workUnit}</td>
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
