<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>编辑${name}信息</title>
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
			.layui-form-label {
				width: 100px;
			}
		</style>
	</head>

	<body>
		<div class="info-edit layui-anim layui-anim-up ">
			<form class="layui-form layui-form-pane">

				<!-- 教师工号 教师姓名 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label for="userId" class="layui-form-label"><span class="x-red">*</span>教师工号</label>
						<div class="layui-input-inline">
							<input type="text" id="userId" name="userId" lay-verify="required" autocomplete="off" class="layui-input"
								   placeholder="请输入教师工号" value="${map.userId}" disabled>
						</div>
					</div>
					<div class="layui-inline">
						<label for="username" class="layui-form-label">授课教师</label>
						<div class="layui-input-inline">
							<input type="text" id="username" name="username" autocomplete="off" class="layui-input"
								   placeholder="请输入教师姓名" value="${map.username}" disabled>
						</div>
					</div>
				</div>

				<!-- 时间 实习周数 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label"><span class="x-red">*</span>时间</label>
						<div class="layui-input-inline">
							<select name="time" lay-verify="required" lay-search="">
								<option value="">请选择</option>
								<option value="2018年" <c:if test="${map.time == '2018年'}">selected</c:if>>2018年</option>
								<option value="2019年" <c:if test="${map.time == '2019年'}">selected</c:if>>2019年</option>
							</select>
						</div>
					</div>

					<c:if test="${type==1}">
						<div class="layui-inline">
							<label for="weekNum" class="layui-form-label">
								<span class="x-red">*</span>实习周数
							</label>
							<div class="layui-input-inline">
								<input type="text" id="weekNum" name="weekNum" lay-verify="required" autocomplete="off" class="layui-input"
									   placeholder="请输入实习周数" value="${map.weekNum}">
							</div>
						</div>
					</c:if>
				</div>
				
				<!-- 学生姓名 -->
				<div class="layui-form-item layui-form-text" style="width: 92%; margin: 10px 0 30px 0">
					<label class="layui-form-label">
						<span class="x-red">*</span>学生姓名
					</label>
					<div class="layui-input-block">
						<textarea placeholder="请输入学生姓名，使用逗号或分号分隔" class="layui-textarea"
								  name="stuName" lay-verify="required">${map.stuName}</textarea>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>

			</form>
		</div>

		<script>
			layui.use(['form', 'laydate'], function(){
				var form = layui.form
						,layer = layui.layer
						,laydate = layui.laydate;

				//日期
				laydate.render({
					elem: '#date',
					trigger: 'click' //自定义弹出框，采用click弹出
				});

				//自定义验证规则
				form.verify({
				});

				//监听提交
				form.on('submit(add)', function(data) {
					// 发异步，把数据提交给servlet
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/undergraduateEdit.action",
						data: "undergraduateData="+JSON.stringify(data.field)+"&type=${type}&id=${map.id}",
						dataType: "json",
						success: function (data) {
							console.log("修改成功");
						},
						error: function (data) {
							// 不知道为什么，不管后端成功与否，这里返回的都是error，所以索性我们就在这里进行逻辑判断
							if (data.responseText !== "") {
								layer.alert("修改失败，" + data.responseText, {
									icon: 2
								});
							}
							else{
								layer.alert("修改成功", {
									icon: 6
								}, function () {
									// 获得frame索引
									var index = parent.layer.getFrameIndex(window.name);
									// 刷新父页面
									parent.location.reload();
									// 关闭当前frame
									parent.layer.close(index);
								});
							}
						}
					});
					return false;
				});
			});
		</script>

	</body>
</html>
