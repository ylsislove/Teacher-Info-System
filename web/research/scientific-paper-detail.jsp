<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>论文详情</title>
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
									<th>发表时间</th>
									<td>${paper.date}年</td>
								</tr>
								<tr>
									<th>论文标题</th>
									<td>${paper.title}</td>
								</tr>
								<tr>
									<th>期刊全称</th>
									<td>${paper.journalFullName}</td>
								</tr>
								<tr>
									<th>期刊缩写</th>
									<td>${paper.journalShortName}</td>
								</tr>
								<tr>
									<th>卷号</th>
									<td>${paper.reelNum}卷</td>
								</tr>
								<tr>
									<th>期号</th>
									<td>${paper.issue}期</td>
								</tr>
								<tr>
									<th>起始页码</th>
									<td>${paper.beginPageNum}</td>
								</tr>
								<tr>
									<th>结束页码</th>
									<td>${paper.endPageNum}</td>
								</tr>
								<tr>
									<th>DOI号</th>
									<td>${paper.doiNum}</td>
								</tr>
								<tr>
									<th>论文分区</th>
									<td>${paper.subarea}</td>
								</tr>
								<tr>
									<th>引用次数</th>
									<td>${paper.citeNum}</td>
								</tr>
								<tr>
									<th>论文成就</th>
									<td>${paper.achievement}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</fieldset>

				<fieldset class="layui-elem-field" style="margin-top: 40px;">
					<legend>作者详情</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="25%">
								<col width="25%">
								<col>
								<col width="25%">
							</colgroup>
							<thead>
							<tr>
								<th>姓名</th>
								<th>标记</th>
								<th>是否为我校教师</th>
								<th>查看详情</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${authors }" var="author">
								<tr>
									<td>王宇</td>
									<td>#</td>
									<td>是</td>
									<td>操作</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</fieldset>

				<fieldset class="layui-elem-field">
					<legend>完成单位</legend>
					<div class="layui-field-box">
						<table class="layui-table">
							<colgroup>
								<col width="40%">
							</colgroup>
							<tbody>
							<tr>
								<th>完成单位1</th>
								<td>${paper.workUnits}</td>
							</tr>
							</tbody>
						</table>
					</div>
				</fieldset>

			</div>
		</div>
	</body>

</html>
