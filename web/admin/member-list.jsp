<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>教师列表</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
	</head>

	<body class="layui-anim layui-anim-up">
		<div class="x-nav">
			<span class="layui-breadcrumb">
				<a href="">首页</a>
				<a href="">教师信息</a>
				<a>
					<cite>教师列表</cite></a>
			</span>
			<a class="layui-btn layui-btn-small" style="float:right; margin: 2px 0 2px 0; height: 35px; line-height: 35px;"
			   href="${pageContext.request.contextPath }/memberList.action" title="刷新">
				<i class="layui-icon" style="margin-right: 0;">ဂ</i>
			</a>
		</div>
		<div class="x-body" style="padding-top: 10px">
			<div class="layui-row">
				<form action="${pageContext.request.contextPath }/memberList.action" method="get" class="layui-form layui-col-md12 x-so" style="margin-bottom: 10px">
					<input type="text" value="${keyword}" name="keyword" placeholder="请输入关键词" autocomplete="off" class="layui-input">
					<input type="text" name="mode" value="search" style="display: none">
					<button type="submit" class="layui-btn"><i class="layui-icon">&#xe615;</i></button>
				</form>
			</div>
			<xblock>
				<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
				<button class="layui-btn" onclick="x_admin_show('添加教师信息','${pageContext.request.contextPath }/admin/member-add.jsp',800,500)"><i class="layui-icon"></i>添加</button>
				<button class="layui-btn" onclick="x_admin_show('批量添加','${pageContext.request.contextPath }/admin/member-upload.jsp',800,500)"><i class="layui-icon"></i>批量添加</button>
				<button class="layui-btn layui-btn-normal" onclick="exportE()"><i class="iconfont">&#xe6a2;</i>&nbsp;&nbsp;导出</button>
				<span class="layui-form" style="margin-left: 8px">
					<input type="text" id="deleteMode" name="deleteMode" value="0" style="display: none">
					<input type="checkbox" class="delete_switch" name="open" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
				</span>
				<span class="x-right" style="line-height:40px">共有数据：${page.totalCount } 条</span>
			</xblock>
			<table id="myTable" class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
						</th>
						<th>工号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>所属系别</th>
						<th>出生年月</th>
						<th>参加工作时间</th>
						<th>所属党派</th>
						<th>职务</th>
						<th>职称</th>
						<th>评职时间</th>
						<th>岗位类别</th>
						<th>岗位等级</th>
						<th>操作</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${page.list }" var="u">
					<tr>
						<td>
							<c:if test="${u.isadmin == '0'}">
								<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${u.userId }'><i class="layui-icon">&#xe605;</i></div>
							</c:if>
							<c:if test="${u.isadmin == '1'}">
								admin
							</c:if>
						</td>
						<td>${u.userId }</td>
						<td>${u.username }</td>
						<td>${u.sex }</td>
						<td>${u.department }</td>
						<td>${u.birth }</td>
						<td>${u.worktime }</td>
						<td>${u.part }</td>
						<td>${u.position }</td>
						<td>${u.title }</td>
						<td>${u.titletime }</td>
						<td>${u.worktype }</td>
						<td>${u.worklevel }级</td>
						<td class="td-manage">
							<a title="编辑" onclick="x_admin_show('编辑教师信息','${pageContext.request.contextPath }/memberEditShow.action?userId=${u.userId }&role=admin',800,500)" href="javascript:;">
								<i class="layui-icon">&#xe642;</i>
							</a>
							<a title="查看教师详情" onclick="x_admin_show('查看教师详情','${pageContext.request.contextPath }/teacherIndex.action?userId=${u.userId }',1080,550)" href="javascript:;">
								<i class="layui-icon">&#xe63c;</i>
							</a>
							<c:if test="${u.isadmin == '0'}">
								<a title="删除" onclick="member_del(this,'${u.userId }')" href="javascript:;">
									<i class="layui-icon">&#xe640;</i>
								</a>
							</c:if>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="page">
				<div>
					<a class="first" <c:if test="${page.pageNo==1 }">aria-disabled="true" style="pointer-events: none"</c:if>
					   href="${pageContext.request.contextPath }/memberList.action?mode=${mode}&keyword=${keyword}&pageNo=1">首页</a>
					<a class="prev" <c:if test="${page.pageNo==1 }">aria-disabled="true" style="pointer-events: none"</c:if>
					   href="${pageContext.request.contextPath }/memberList.action?mode=${mode}&keyword=${keyword}&pageNo=${page.pageNo-1 }">上一页</a>
					<span class="current">${page.pageNo }</span>
					<a class="next" <c:if test="${page.totalPage==0 || page.pageNo==page.totalPage }">aria-disabled="true" style="pointer-events: none"</c:if>
					   href="${pageContext.request.contextPath }/memberList.action?mode=${mode}&keyword=${keyword}&pageNo=${page.pageNo+1 }">下一页</a>
					<a class="last" <c:if test="${page.totalPage==0 || page.pageNo==page.totalPage }">aria-disabled="true" style="pointer-events: none"</c:if>
					   href="${pageContext.request.contextPath }/memberList.action?mode=${mode}&keyword=${keyword}&pageNo=${page.totalPage }">尾页</a>
				</div>
			</div>
		</div>

		<script>
			function exportE() {
				window.open('${pageContext.request.contextPath }/admin/member-export.jsp?role=${role}');
			}
		</script>

		<script>
			layui.use(['form', 'laydate'], function() {
				var form = layui.form
						,layer = layui.layer
						,laydate = layui.laydate;

				//执行一个laydate实例
				laydate.render({
					elem: '#start' //指定元素
				});

				//执行一个laydate实例
				laydate.render({
					elem: '#end' //指定元素
				});

				//监听指定开关
				form.on('switch(switchTest)', function(data){
					$('#deleteMode').val(this.checked ? '1' : '0');
					layer.msg('级联删除：'+ (this.checked ? '开启' : '关闭'), {
						offset: '6px'
					});
					layer.tips('温馨提示：级联删除表示您可以直接删除与该教师关联的所有信息', data.othis)
				});
			});

			/*用户-删除*/
			function member_del(obj, id) {
				var str = $('#deleteMode').val() === '0' ? '' : '（级联删除）';
				layer.confirm('确认要删除'+str+'吗？', function(index) {
					//发异步删除数据
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/memberDelete.action",
						data: { userId:id, deleteMode:$('#deleteMode').val() },
						success:function(data){
							if (data !== "") {
								layer.alert(id + data, {
									icon: 2
								});
							}
							else{
								layer.alert(id + "已删除", {
									icon: 1
								}, function () {
									//刷新页面
									var totalCount = ${page.totalCount };
									var pageSize = ${page.pageSize };
									var curPageNo = ${page.pageNo };
									if ((totalCount - 1) % pageSize == 0) {
										curPageNo = curPageNo - 1;
									}
									location.replace("${pageContext.request.contextPath }/memberList.action?pageNo="+curPageNo)
								});
								$(obj).parents("tr").remove();
							}
						},
						error:function (data) {
							layer.alert(id + data.responseText, {
								icon: 2
							});
						}
					});
				});
			}

			function delAll(argument) {

				var data = tableCheck.getData();
				var num = data.length;
				if (num == 0) return;

				var str = $('#deleteMode').val() === '0' ? '' : '（级联删除）';
				layer.confirm('确认要删除'+str+'吗？' + data, function(index) {
					//捉到所有被选中的，发异步进行删除
					$.ajax({
						type: "POST",
						traditional: true,	//传数组一定要加的
						url: "${pageContext.request.contextPath }/memberDeleteAll.action",
						data: { uData:data, deleteMode:$('#deleteMode').val() },
						success:function(data){
							if (data !== "") {
								layer.alert(data, {
									icon: 2
								}, function () {
									//刷新页面
									location.replace("${pageContext.request.contextPath }/memberList.action?pageNo="+${page.pageNo})
								});
							}
							else{
								layer.alert("批量删除成功", {
									icon: 1
								}, function () {
									//刷新页面
									var totalCount = ${page.totalCount };
									var pageSize = ${page.pageSize };
									var curPageNo = ${page.pageNo };
									if ((totalCount - num) % pageSize == 0) {
										curPageNo = curPageNo - 1;
									}
									location.replace("${pageContext.request.contextPath }/memberList.action?pageNo="+curPageNo)
								});
								$(".layui-form-checked").not('.header').parents('tr').remove();
							}
						},
						error:function (data) {
							layer.alert("批量删除失败，" + data.responseText, {
								icon: 2
							}, function () {
								//刷新页面
								location.replace("${pageContext.request.contextPath }/memberList.action?pageNo="+${page.pageNo})
							});
						}
					});
				});
			}
		</script>
	</body>
</html>
