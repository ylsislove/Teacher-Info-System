<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>添加${param.name}信息</title>
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
			<form class="layui-form" style="margin-left: 110px">

				<!-- 教师工号 -->
				<div class="layui-form-item">
					<label for="userId" class="layui-form-label"><span class="x-red">*</span>教师工号</label>
					<div class="layui-input-inline">
						<input type="text" id="userId" name="userId" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="请输入教师工号">
					</div>
				</div>

				<!-- 教师姓名 -->
				<div class="layui-form-item">
					<label for="username" class="layui-form-label">授课教师</label>
					<div class="layui-input-inline">
						<input type="text" id="username" name="username" autocomplete="off" class="layui-input"
						 placeholder="选填，请输入教师姓名">
					</div>
				</div>
				
				<!-- 授课时间 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label"><span class="x-red">*</span>授课时间</label>
						<div class="layui-input-inline">
							<input type="text" id="courseTime" name="courseTime" autocomplete="off" class="layui-input"
								   placeholder="如，2019年秋季">
						</div>
					</div>
				</div>
				
				<!-- 课程名称 -->
				<div class="layui-form-item">
					<label for="courseName" class="layui-form-label"><span class="x-red">*</span>课程名称</label>
					<div class="layui-input-inline">
						<input type="text" id="courseName" name="courseName" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="请输入课程名称">
					</div>
				</div>

				<!-- 课程性质 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>课程性质</label>
					<div class="layui-input-block">
						<input type="radio" name="courseAttr" value="必修" title="必修" checked="">
						<input type="radio" name="courseAttr" value="选修" title="选修">
					</div>
				</div>

				<!-- 是否英文授课 -->
				<c:if test="${param.type == 1 || param.type == 3}">
					<div class="layui-form-item">
						<label class="layui-form-label"><span class="x-red">*</span>是否英文授课</label>
						<div class="layui-input-block">
							<input type="radio" name="isEnglish" value="是" title="是" checked="">
							<input type="radio" name="isEnglish" value="否" title="否">
						</div>
					</div>
				</c:if>

				<!-- 课程总学时 -->
				<div class="layui-form-item">
					<label for="courseTotalHours" class="layui-form-label"><span class="x-red">*</span>课程总学时</label>
					<div class="layui-input-inline">
						<input type="text" id="courseTotalHours" name="courseTotalHours" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="请输入课程总学时">
					</div>
				</div>

				<!-- 课程实际授课学时 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label for="courseRealHours" class="layui-form-label"><span class="x-red">*</span>实际授课学时</label>
						<div class="layui-input-inline">
							<input type="tel" id="courseRealHours" name="courseRealHours" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="请输入实际授课学时">
						</div>
					</div>
				</div>

				<!-- 教学班级 -->
				<div class="layui-form-item">
					<label for="classrooms" class="layui-form-label"><span class="x-red">*</span>教学班级</label>
					<div class="layui-input-inline">
						<input type="text" id="classrooms" name="classrooms" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="请用英文逗号分隔">
					</div>
				</div>

				<!-- 学生人数 -->
				<div class="layui-form-item">
					<label for="stuNum" class="layui-form-label">
						<span class="x-red">*</span>学生人数
					</label>
					<div class="layui-input-inline">
						<input type="text" id="stuNum" name="stuNum" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="请输入实际上课人数">
					</div>
				</div>

				<!-- 分组数目 -->
				<c:if test="${param.type == 2 || param.type == 4}">
					<div class="layui-form-item">
						<label for="groupNum" class="layui-form-label">
							<span class="x-red">*</span>分组数目
						</label>
						<div class="layui-input-inline">
							<input type="text" id="groupNum" name="groupNum" lay-verify="required" autocomplete="off" class="layui-input"
								   placeholder="请输入分组数目">
						</div>
					</div>
				</c:if>

				<div class="layui-form-item">
					<label class="layui-form-label"></label>
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

				//监听提交
				form.on('submit(add)', function(data) {
					// 发异步，把数据提交给servlet
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/teachingAdd.action",
						data: "teachingData="+JSON.stringify(data.field)+"&type="+${param.type},
						dataType: "json",
						success: function (data) {
							console.log("添加成功");
						},
						error: function (data) {
							// 不知道为什么，不管后端成功与否，这里返回的都是error，所以索性我们就在这里进行逻辑判断
							if (data.responseText !== "") {
								layer.alert("添加失败，" + data.responseText, {
									icon: 2
								});
							}
							else{
								layer.alert("添加成功", {
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
