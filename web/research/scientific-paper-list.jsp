<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<title>${name}</title>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
	</head>

	<body>
		<div class="x-nav">
			<span class="layui-breadcrumb">
				<a href="">首页</a>
				<a href="">成果管理</a>
				<a>
					<cite>${name}</cite></a>
			</span>
			<a class="layui-btn layui-btn-small" style="float:right; margin: 2px 0 2px 0; height: 35px; line-height: 35px;"
			   href="javascript:location.replace(location.href);" title="刷新">
				<i class="layui-icon" style="margin-right: 0;">ဂ</i>
			</a>
		</div>
		<div class="x-body" style="padding-top: 10px">
			<div class="layui-row">
				<form class="layui-form layui-col-md12 x-so" style="margin-bottom: 10px">
					<input class="layui-input" placeholder="起始时间" name="start" id="start">
					<input class="layui-input" placeholder="截止时间" name="end" id="end">				
					<input type="text" name="keyword" placeholder="请输入关键字" autocomplete="off" class="layui-input">
					<button class="layui-btn" lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
				</form>
			</div>
			<xblock>
				<c:if test="${role == 'admin'}">
					<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
					<button class="layui-btn" onclick="x_admin_show('添加${name}信息','${pageContext.request.contextPath }/research/scientific-paper-add.jsp?type=${type}&name=${name}',800,500)"><i class="layui-icon"></i>添加</button>
					<button class="layui-btn" onclick="x_admin_show('批量添加','${pageContext.request.contextPath }/research/scientific-paper-upload.jsp?type=${type}',800,500)"><i class="layui-icon"></i>批量添加</button>
				</c:if>
				<c:if test="${role == 'user'}">
					<button class="layui-btn" onclick=""><i class="iconfont">&#xe6a2;</i>&nbsp;&nbsp;导出</button>
				</c:if>
				<span class="x-right" style="line-height:40px">共有数据：${page.totalCount } 条</span>
			</xblock>
			<table class="layui-table">
				<colgroup>
					<col width="2%">
					<col width="7%">
					<col >
					<col width="7%">
					<col width="5%">
					<col width="5%">
					<col width="7%">
					<col width="7%">
					<col width="18%">
					<col width="7%">
					<c:if test="${role == 'admin'}">
						<col width="6%">
					</c:if>
				</colgroup>
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
						</th>
						<th>发表时间</th>
						<th>论文标题</th>
						<th>期刊缩写</th>
						<th>卷号</th>
						<th>期号</th>
						<th>起始页码</th>
						<th>结束页码</th>
						<th>DOI号</th>
						<th>查看详情</th>
						<c:if test="${role == 'admin'}">
							<th>操作</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.list }" var="paper">
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${paper.id}'><i class="layui-icon">&#xe605;</i></div>
						</td>
						<td>${paper.date}年</td>
						<td>${paper.title}</td>
						<td>${paper.journalShortName}</td>
						<td>${paper.reelNum}卷</td>
						<td>${paper.issue}期</td>
						<td>${paper.beginPageNum}</td>
						<td>${paper.endPageNum}</td>
						<td>${paper.doiNum}</td>
						<td>
							<button type="button" onclick="x_admin_show('查看论文详情','${pageContext.request.contextPath }/scientificPaperDetail.action?id=${paper.id }',1000,550)" class="layui-btn layui-btn-xs layui-btn-normal"><i class="layui-icon">&#xe63c;</i> 详情</button>
						</td>
						<c:if test="${role == 'admin'}">
							<td class="td-manage">
								<a title="编辑" onclick="x_admin_show('编辑${name}信息','${pageContext.request.contextPath }/scientificPaperEditShow.action?id=${paper.id }',800,500)" href="javascript:;">
									<i class="layui-icon">&#xe642;</i>
								</a>
								<a title="删除" onclick="member_del(this,'${paper.id }')" href="javascript:;">
									<i class="layui-icon">&#xe640;</i>
								</a>
							</td>
						</c:if>
					</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="page">
				<div>
					<a class="first" <c:if test="${page.pageNo==1 }">aria-disabled="true" style="pointer-events: none"</c:if>
					   href="${pageContext.request.contextPath }/scientificPaperList.action?type=${type}&pageNo=1&role=${role}">首页</a>
					<a class="prev" <c:if test="${page.pageNo==1 }">aria-disabled="true" style="pointer-events: none"</c:if>
					   href="${pageContext.request.contextPath }/scientificPaperList.action?type=${type}&pageNo=${page.pageNo-1 }&role=${role}">上一页</a>
					<span class="current">${page.pageNo }</span>
					<a class="next" <c:if test="${page.totalPage==0 || page.pageNo==page.totalPage }">aria-disabled="true" style="pointer-events: none"</c:if>
					   href="${pageContext.request.contextPath }/scientificPaperList.action?type=${type}&pageNo=${page.pageNo+1 }&role=${role}">下一页</a>
					<a class="last" <c:if test="${page.totalPage==0 || page.pageNo==page.totalPage }">aria-disabled="true" style="pointer-events: none"</c:if>
					   href="${pageContext.request.contextPath }/scientificPaperList.action?type=${type}&pageNo=${page.totalPage }&role=${role}">尾页</a>
				</div>
			</div>
		</div>

		<script>
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//执行一个laydate实例
				laydate.render({
					elem: '#start' //指定元素
				});

				//执行一个laydate实例
				laydate.render({
					elem: '#end' //指定元素
				});
			});

			/*论文条目-删除*/
			function member_del(obj, id) {
				layer.confirm('确认要删除吗？', function(index) {
					//发异步删除数据
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/scientificPaperDelete.action",
						data: { id:id},
						success:function(data){
							if (data !== "") {
								layer.alert(id + data, {
									icon: 2
								});
							}
							else {
								layer.alert("已删除", {
									icon: 1
								}, function () {
									//刷新页面
									var totalCount = ${page.totalCount };
									var pageSize = ${page.pageSize };
									var curPageNo = ${page.pageNo };
									if ((totalCount - 1) % pageSize == 0) {
										curPageNo = curPageNo - 1;
									}
									location.replace("${pageContext.request.contextPath }/scientificPaperList.action?role=${role}&type=${type}&pageNo="+curPageNo)
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

				layer.confirm('确认要删除吗？', function(index) {
					//捉到所有被选中的，发异步进行删除
					$.ajax({
						type: "POST",
						traditional: true,	//传数组一定要加的
						url: "${pageContext.request.contextPath }/scientificPaperDeleteAll.action",
						data: { data:data },
						success:function(data){
							if (data !== "") {
								layer.alert(data, {
									icon: 2
								}, function () {
									//刷新页面
									location.replace("${pageContext.request.contextPath }/scientificPaperList.action?role=${role}&type=${type}&pageNo="+${page.pageNo})
								});
							}
							else {
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
									location.replace("${pageContext.request.contextPath }/scientificPaperList.action?role=${role}&type=${type}&pageNo="+curPageNo)
								});
								$(".layui-form-checked").not('.header').parents('tr').remove();
							}
						},
						error:function (data) {
							layer.alert("批量删除失败，" + data.responseText, {
								icon: 2
							}, function () {
								//刷新页面
								location.replace("${pageContext.request.contextPath }/scientificPaperList.action?role=${role}&type=${type}&pageNo="+${page.pageNo})
							});
						}
					});
				});
			}
		</script>

	</body>
</html>
