<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh">
	<head>
		<meta charset="UTF-8">
		<title>教师详情</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />

		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
<%--		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/user.css">--%>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js" charset="utf-8"></script>

		<style type="text/css">
			.page-content .layui-tab-title .layui-this{
				background: #EDEFF0 url() 0 0 no-repeat;
			}
			.layui-tab-title .layui-this:after{
				border-bottom-color: #EDEFF0;
			}
			.left-nav #nav li{
				border-bottom-width: 0;
			}
		</style>

	</head>
	<body>

		<!-- 顶部开始 -->
		<ul class="layui-nav" style="float: right; width: 100%;">
			<li class="layui-nav-item" style="float: left;">
				<a href="${pageContext.request.contextPath }/teacherIndex.action?userId=${user.userId}" style="font-size: 20px">化学系教师管理系统</a>
			</li>
			<li class="layui-nav-item" lay-unselect="" style="float: right;">
				<a href="javascript:"><img src="${pageContext.request.contextPath }/images/head.png" class="layui-nav-img">${user.username }&nbsp;</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:">修改信息</a></dd>
					<dd><a href="javascript:">安全管理</a></dd>
					<dd><a href="${pageContext.request.contextPath }/logout.action">退了</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item" style="float: right;">
				<a href="${pageContext.request.contextPath }/teacher/index.jsp">个人中心</a>
			</li>
			<li class="layui-nav-item" style="float: right;">
				<a href="javascript:">导出&nbsp;</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:">全部导出</a></dd>
					<dd><a href="javascript:">自定义导出</a></dd>
				</dl>
			</li>
		</ul>
		<!-- 顶部结束 -->

		<!-- 中部开始 -->
		<!-- 左侧菜单开始 -->
		<div class="left-nav" style="top: 60px; bottom: 0;">
			<div id="side-nav">
				<ul id="nav">

					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe723;</i>
							<cite>教学管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/teachingList.action?type=1&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>本科课堂教学</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/teachingList.action?type=2&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>本科实验教学</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/teachingList.action?type=3&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>研究生课堂教学</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/teachingList.action?type=4&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>研究生实验教学</cite>
								</a>
							</li>
						</ul>
					</li>
					
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe723;</i>
							<cite>本科生管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/undergraduateList.action?type=1&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>本科生产实习</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/undergraduateList.action?type=2&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>本科毕业论文</cite>
								</a>
							</li>
						</ul>
					</li>
					
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe723;</i>
							<cite>研究生管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/postgraduateList.action?role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>研究生指导</cite>
								</a>
							</li>
						</ul>
					</li>

					
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe723;</i>
							<cite>成果管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="${pageContext.request.contextPath }/scientificPaperList.action?type=1&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>科研论文</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/scientificPaperList.action?type=2&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>教学论文</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/researchProjectList.action?type=1&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>科研项目</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/researchProjectList.action?type=2&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>教学项目</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/awardList.action?type=1&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>科研奖项</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/awardList.action?type=2&role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>教学奖项</cite>
								</a>
							</li>
							<li>
								<a _href="${pageContext.request.contextPath }/patentList.action?role=user">
									<i class="iconfont">&#xe6a7;</i>
									<cite>专利</cite>
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
		<div class="page-content" style="top: 60px; bottom: 0;">
			<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
				<ul class="layui-tab-title">
					<li class="home"><i class="iconfont">&#xe6a2;</i>&nbsp;个人中心</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe src='${pageContext.request.contextPath }/teacherBaseInfo.action' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
					</div>
				</div>
			</div>
		</div>

	</body>
</html>
