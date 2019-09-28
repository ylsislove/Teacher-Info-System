<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh">
	<head>
		<meta charset="UTF-8">
		<title>化学系教师管理系统</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8">

		<link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>

	</head>
	<body>

		<!-- 顶部开始 -->
		<div class="container">
			<div class="logo"><a href="${pageContext.request.contextPath }/admin/index.jsp">化学系教师管理系统</a></div>
			<div class="left_open">
				<i title="展开左侧栏" class="iconfont">&#xe699;</i>
			</div>

			<ul class="layui-nav right">
				<li class="layui-nav-item">
					<a href="javascript:">${admin.username }&nbsp;</a>
					<dl class="layui-nav-child">
						<!-- 二级菜单 -->
						<dd><a href="${pageContext.request.contextPath }/admin/index.jsp">个人信息</a></dd>
						<dd><a href="${pageContext.request.contextPath }/login.jsp">切换帐号</a></dd>
						<dd><a href="${pageContext.request.contextPath }/logout.action">退出</a></dd>
					</dl>
				</li>
			</ul>
		</div>
		<!-- 顶部结束 -->

		<!-- 中部开始 -->
		<!-- 左侧菜单开始 -->
		<div class="left-nav">
			<div id="side-nav">
				<ul id="nav">
					<li>
						<a href="javascript:">
							<i class="iconfont">&#xe6b8;</i>
							<cite>教师信息</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/memberList.action">
									<i class="iconfont">&#xe6a7;</i>
									<cite>教师列表</cite>
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="javascript:">
							<i class="iconfont">&#xe723;</i>
							<cite>教学管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/teachingList.action?type=1&role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>本科课堂教学</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/teachingList.action?type=2&role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>本科实验教学</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/teachingList.action?type=3&role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>研究生课堂教学</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/teachingList.action?type=4&role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>研究生实验教学</cite>
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="javascript:">
							<i class="iconfont">&#xe723;</i>
							<cite>本科生管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/undergraduateList.action?type=1&role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>本科生产实习</cite>
								</a>
							</li>
						</ul>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/undergraduateList.action?type=2&role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>本科毕业论文</cite>
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="javascript:">
							<i class="iconfont">&#xe723;</i>
							<cite>研究生管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/postgraduateList.action?role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>研究生指导</cite>
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="javascript:">
							<i class="iconfont">&#xe723;</i>
							<cite>成果管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/scientificPaperList.action?type=1&role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>科研论文</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/scientificPaperList.action?type=2&role=admin">
									<i class="iconfont">&#xe6a7;</i>
									<cite>教学论文</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/research/research-project-list.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>科研项目</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/research/research-project-list.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>教学项目</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/research/awards-list.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>科研奖项</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/research/awards-list.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>教学奖项</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/research/patents-list.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>专利</cite>
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe6ce;</i>
							<cite>数据统计</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/admin/echarts1.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>拆线图</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/admin/echarts2.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>柱状图</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/admin/echarts5.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>雷达图</cite>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:">
							<i class="iconfont">&#xe6b4;</i>
							<cite>图标字体</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/unicode.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>图标对应字体</cite>
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<!-- <div class="x-slide_left"></div> -->
		<!-- 左侧菜单结束 -->
		<!-- 右侧主体开始 -->
		<div class="page-content" style="top: 46px;">
			<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
				<ul class="layui-tab-title">
					<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe src='${pageContext.request.contextPath }/admin/welcome.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
					</div>
				</div>
			</div>
		</div>
		<div class="page-content-bg"></div>
		<!-- 右侧主体结束 -->
		<!-- 中部结束 -->
		<!-- 底部开始 -->
		<div class="footer">
			<div class="copyright">Copyright © 中国地质大学(武汉) All Rights Reserved</div>
		</div>
		<!-- 底部结束 -->

	</body>
</html>
