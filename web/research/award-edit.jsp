<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>编辑${param.name}信息</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js" charset="utf-8"></script>

	</head>

	<body>
		<div class="layui-anim layui-anim-up" style="width: 75%; margin: 30px auto">
			<form class="layui-form layui-form-pane">

				<!-- ---------------------------- 基本信息 ----------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: #01AAED;
					 margin-top: 30px; margin-bottom: 25px;">
					<legend>基本信息</legend>
				</fieldset>

				<!-- 获奖时间 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>获奖时间</label>
					<div class="layui-input-inline" style="width: 22%;">
						<input type="text" name="date" id="date" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="yyyy-MM-dd" value="${award.date}">
					</div>
					<label class="layui-form-label"><span class="x-red">*</span>授奖单位</label>
					<div class="layui-input-inline" style="width: 230px; margin-right: 0">
						<input id="unit" name="unit" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="授奖单位" value="${award.unit}">
					</div>
				</div>

				<!-- 获奖名称 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>获奖名称</label>
					<div class="layui-input-block">
						<input id="title" name="title" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="请输入获奖名称" value="${award.title}">
					</div>
				</div>

				<!-- 获奖等级 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>等级</label>
					<div class="layui-input-inline" style="width: 179px;">
						<select name="grade" lay-verify="required">
							<option value="">请选择</option>
							<option value="一等奖" <c:if test="${award.grade == '一等奖'}">selected</c:if>>一等奖</option>
							<option value="二等奖" <c:if test="${award.grade == '二等奖'}">selected</c:if>>二等奖</option>
							<option value="三等奖" <c:if test="${award.grade == '三等奖'}">selected</c:if>>三等奖</option>
						</select>
					</div>
					<label class="layui-form-label"><span class="x-red">*</span>获奖级别</label>
					<div class="layui-input-inline" style="width: 179px; margin-right: 0">
						<select name="level" lay-verify="required">
							<option value="">请选择</option>
							<option value="校级" <c:if test="${award.level == '校级'}">selected</c:if>>校级</option>
							<option value="市级" <c:if test="${award.level == '市级'}">selected</c:if>>市级</option>
							<option value="省部级" <c:if test="${award.level == '省部级'}">selected</c:if>>省部级</option>
							<option value="国家级" <c:if test="${award.level == '国家级'}">selected</c:if>>国家级</option>
							<option value="行业" <c:if test="${award.level == '行业'}">selected</c:if>>行业</option>
						</select>
					</div>
				</div>

				<input type="text" id="id" name="id" value="${award.id}" style="display: none;">
				<input type="text" id="type" name="type" value="${award.type}" style="display: none;">

				<!-- --------------------------- 获奖人详情 --------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: mediumpurple;
					 margin-top: 30px; margin-bottom: 25px;">
					<legend>获奖人详情</legend>
				</fieldset>

				<input type="text" id="winnerSum" name="winnerSum" value="0" style="display: none;">
				<table id="WINNERS_table" class="layui-table">
					<colgroup>
						<col width="40%">
						<col width="30%">
						<col width="30%">
						<col width="2%">
					</colgroup>
					<thead>
					<tr>
						<th class="align-center"><span class="x-red">*</span>姓名</th>
						<th class="align-center">是否为我校老师</th>
						<th class="align-center">教师工号</th>
						<th>
							<button type="button" class="layui-btn layui-btn-xs"
									onclick="winner_add('WINNERS_table', 'WINNERS_tr')">
								<i class="layui-icon">&#xe608;</i>
							</button>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr id="WINNERS_tr" style="display: none;">
						<td style="padding: 9px 5px">
							<input type="text" id="winnerName00" name="winnerName00" lay-verify="required" autocomplete="off" class="layui-input"
								   placeholder="必填" value="0">
						</td>
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<select id="isOurTeacher00" name="isOurTeacher00">
									<option value="">请选择</option>
									<option value="是">是</option>
									<option value="否" selected>否</option>
								</select>
							</div>
						</td>
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<input type="text" id="userId00" name="userId00"  autocomplete="off" class="layui-input"
									   placeholder="自动关联">
							</div>
						</td>
						<td class="align-center">
							<button type="button" class="layui-btn layui-btn-danger layui-btn-xs"
									onclick="winner_removerow('WINNERS_table', this)">
								<i class="layui-icon">&#x1006;</i>
							</button>
						</td>
					</tr>
					</tbody>
				</table>

				
				<!-- ---------------------------- 提交表单 ----------------------------- -->

				<div class="layui-form-item" style="margin: 30px 130px">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>

			</form>

		</div>

		<%-- 获奖人信息的动态添加 --%>
		<script type="text/javascript">

			var add_winner_index_js = 1;
			var winner_sum = 0;

			function winner_removerow(tableid, obj) {
				var rowIndex = obj.parentNode.parentNode.rowIndex;//获得行的索引
				document.getElementById(tableid).deleteRow(rowIndex);
				winner_sum -= 1;
				$("#winnerSum").val(winner_sum);
			}

			function winner_add(tableid, trid) {
				var newRow = '<tr>';
				newRow += $("#" + trid).html();
				newRow += '</tr>';
				newRow = newRow.replace(/00/g, add_winner_index_js);
				newRow = newRow.replace(/value="0"/g, 'value=""');
				$("#" + tableid + " tr:last").after(newRow);
				add_winner_index_js +=  1;
				winner_sum += 1;
				$("#winnerSum").val(winner_sum);

				layui.use(['form'], function(){
					var form = layui.form;
					form.render(); //更新全部
				});
			}

			<c:forEach items="${winnerList }" var="winner">
				winner_add('WINNERS_table', 'WINNERS_tr');
				$("#winnerName"+winner_sum).val("${winner.winnerName}");
				$("#isOurTeacher"+winner_sum).val("${winner.isOurTeacher}");
				$("#userId"+winner_sum).val("${winner.userId}");
			</c:forEach>
		</script>

		<script>
			layui.use(['form', 'laydate'], function(){
				var form = layui.form
						, layer = layui.layer
						, laydate = layui.laydate;

				//日期
				laydate.render({
					elem: '#date'
					,trigger: 'click' //自定义弹出框，采用click弹出
				});

				//监听提交
				form.on('submit(add)', function(data) {

					// 发异步，把数据提交给servlet
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/awardEdit.action",
						data: data.field,
						success: function (data) {
							if (data !== "") {
								layer.alert("修改失败，" + data, {
									icon: 2
								});
							} else {
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
						},
						error: function (data) {
							layer.alert("修改失败，" + data.responseText, {
								icon: 2
							});
						}
					});
					return false;
				});
				form.render()
			});
		</script>

	</body>
</html>
