<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>欢迎页面-X-admin2.0</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">

		<script>
			(function() {
				//定时器每秒调用一次fnDate()
				setInterval(function() {
					fnDate();
				}, 1000);
			}());
			//js 获取当前时间
			function fnDate() {
				var oDiv = document.getElementById("time");
				var date = new Date();
				var year = date.getFullYear(); //当前年份
				var month = date.getMonth(); //当前月份
				var data = date.getDate(); //天
				var hours = date.getHours(); //小时
				var minute = date.getMinutes(); //分
				var second = date.getSeconds(); //秒
				var time = year + "-" + fnW((month + 1)) + "-" + fnW(data) + " " + fnW(hours) + ":" + fnW(minute) + ":" + fnW(
					second);
				oDiv.innerHTML = time;
			}

			//补位 当某个字段不是两位数时补0
			function fnW(str) {
				var num;
				str >= 10 ? num = str : num = "0" + str;
				return num;
			}
		</script>

	</head>
	<body>
		<div class="x-body layui-anim layui-anim-up">
			<blockquote class="layui-elem-quote">欢迎管理员：
				<span class="x-red">${admin.username }</span>&nbsp;&nbsp;&nbsp;&nbsp;当前时间：<span id="time">

				</span></blockquote>

			<fieldset class="layui-elem-field">
				<legend>数据统计</legend>
				<div class="layui-field-box">
					<div class="layui-col-md12">
						<div class="layui-card">
							<div class="layui-card-body">
								<div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none"
								 style="width: 100%; height: 190px;">
									<div carousel-item="">
										<ul class="layui-row layui-col-space10 layui-this">
											<li class="layui-col-xs2">
												<a href="javascript:;" class="x-admin-backlog-body">
													<h3>教师数</h3>
													<p>
														<cite>${map.user}</cite></p>
												</a>
											</li>
											<li class="layui-col-xs2">
												<a href="javascript:;" class="x-admin-backlog-body">
													<h3>科研论文</h3>
													<p>
														<cite>${map.paper1}</cite></p>
												</a>
											</li>
											<li class="layui-col-xs2">
												<a href="javascript:;" class="x-admin-backlog-body">
													<h3>教学论文</h3>
													<p>
														<cite>${map.paper2}</cite></p>
												</a>
											</li>
											<li class="layui-col-xs2">
												<a href="javascript:;" class="x-admin-backlog-body">
													<h3>科研项目</h3>
													<p>
														<cite>${map.project1}</cite></p>
												</a>
											</li>
											<li class="layui-col-xs2">
												<a href="javascript:;" class="x-admin-backlog-body">
													<h3>教学项目</h3>
													<p>
														<cite>${map.project2}</cite></p>
												</a>
											</li>
											<li class="layui-col-xs2">
												<a href="javascript:;" class="x-admin-backlog-body">
													<h3>科研奖项</h3>
													<p>
														<cite>${map.award1}</cite></p>
												</a>
											</li>
											<li class="layui-col-xs2">
												<a href="javascript:;" class="x-admin-backlog-body">
													<h3>教学奖项</h3>
													<p>
														<cite>${map.award2}</cite></p>
												</a>
											</li>
											<li class="layui-col-xs2">
												<a href="javascript:;" class="x-admin-backlog-body">
													<h3>专利</h3>
													<p>
														<cite>${map.patent}</cite></p>
												</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</fieldset>

			<fieldset class="layui-elem-field">
				<legend>系统信息</legend>
				<div class="layui-field-box">
					<table class="layui-table">
						<tbody>
							<tr>
								<th>系统版本</th>
								<td>1.0</td>
							</tr>
							<tr>
								<th>服务器地址</th>
								<td>129.211.10.165</td>
							</tr>
							<tr>
								<th>操作系统</th>
								<td>Windows Server 2008 R2 企业版 SP1 64位</td>
							</tr>
							<tr>
								<th>运行环境</th>
								<td>Apache 8.5</td>
							</tr>
							<tr>
								<th>MYSQL版本</th>
								<td>5.7</td>
							</tr>
							<tr>
								<th>Java版本</th>
								<td>1.8</td>
							</tr>
							<tr>
								<th>剩余空间</th>
								<td>86015.2M</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>

			<fieldset class="layui-elem-field">
				<legend>开发团队</legend>
				<div class="layui-field-box">
					<table class="layui-table">
						<tbody>
							<tr>
								<th>版权所有</th>
								<td>中国地质大学（武汉）</td>
							</tr>
							<tr>
								<th>开发者</th>
								<td>王宇（916491013@qq.com） 尹港（1356931781@qq.com）</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</div>
	</body>
</html>
