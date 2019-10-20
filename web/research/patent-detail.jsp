<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>专利详情</title>
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
									<th>申请时间</th>
									<td>${patent.applicationDate}</td>
								</tr>
								<tr>
									<th>授权时间</th>
									<td>${patent.authorizationDate}</td>
								</tr>
								<tr>
									<th>专利号</th>
									<td>${patent.patentId}</td>
								</tr>
								<tr>
									<th>专利类型</th>
									<td>${patent.patentType}</td>
								</tr>
								<tr>
									<th>专利级别</th>
									<td>${patent.level}</td>
								</tr>
								<tr>
									<th>专利名称</th>
									<td>${patent.title}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</fieldset>

				<fieldset class="layui-elem-field" style="margin-top: 40px;">
					<legend>发明人详情</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="30%">
								<col width="30%">
								<col width="25%">
								<col>
							</colgroup>
							<thead>
							<tr>
								<th>姓名</th>
								<th>发明人单位</th>
								<th>是否为我校教师</th>
								<th>教师工号</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${inventorList }" var="inventor">
								<tr>
									<td>${inventor.inventorName}</td>
									<td>${inventor.inventorUnit}</td>
									<td>${inventor.isOurTeacher}</td>
									<td>${inventor.userId}</td>
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
