<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
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
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js" charset="utf-8"></script>

	</head>

	<body>
		<div class="layui-anim layui-anim-up" style="width: 75%; margin: 30px auto">
			<form class="layui-form layui-form-pane">

				<!-- ---------------------------- 基本信息 ----------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: #01AAED;
					 margin-top: 25px; margin-bottom: 25px;">
					<legend>基本信息</legend>
				</fieldset>

				<!-- 起始时间 结束时间 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>起始时间</label>
					<div class="layui-input-inline" style="width: 179px;">
						<input type="text" name="startDate" id="startDate" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="yyyy-MM-dd">
					</div>
					<label class="layui-form-label"><span class="x-red">*</span>结束时间</label>
					<div class="layui-input-inline" style="width: 179px; margin-right: 0">
						<input type="text" name="endDate" id="endDate" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="yyyy-MM-dd">
					</div>
				</div>

				<!-- 项目编号 项目级别 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>项目编号</label>
					<div class="layui-input-inline" style="width: 230px;">
						<input id="projectId" name="projectId" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="请输入项目编号">
					</div>
					<label class="layui-form-label"><span class="x-red">*</span>项目级别</label>
					<div class="layui-input-inline" style="width: 128px; margin-right: 0">
						<select name="level" lay-verify="required">
							<option value="">请选择</option>
							<option value="国家级">国家级</option>
							<option value="省部级">省部级</option>
							<option value="市级">市级</option>
							<option value="校级">校级</option>
							<option value="企业横向">企业横向</option>
						</select>
					</div>
				</div>

				<!-- 项目名称 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>项目名称</label>
					<div class="layui-input-block">
						<input id="title" name="title" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="请输入项目名称">
					</div>
				</div>

				<!-- 项目来源 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>项目来源</label>
					<div class="layui-input-block">
						<input id="source" name="source" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="请输入项目来源">
					</div>
				</div>


				<!-- 项目合同经费 实际到账经费 -->
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 130px;"><span class="x-red">*</span>项目合同经费</label>
					<div class="layui-input-inline" style="width: 159px;">
						<input type="text" name="contractFunds" placeholder="￥" autocomplete="off"
							   class="layui-input">
					</div>
					<label class="layui-form-label" style="width: 130px;"><span class="x-red">*</span>实际到账经费</label>
					<div class="layui-input-inline" style="width: 159px; margin-right: 0">
						<input type="text" name="actualFunds" placeholder="￥" autocomplete="off"
							   class="layui-input">
					</div>
				</div>

				<input type="text" id="type" name="type" value="${param.type}" style="display: none;">

				<!-- --------------------------- 项目成员 --------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: mediumpurple;
					 margin-top: 30px; margin-bottom: 25px;">
					<legend>项目成员</legend>
				</fieldset>

				<input type="text" id="memberSum" name="memberSum" value="0" style="display: none;">
				<table id="MEMBERS_table" class="layui-table">
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
									onclick="member_add('MEMBERS_table', 'MEMBERS_tr')">
								<i class="layui-icon">&#xe608;</i>
							</button>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr id="MEMBERS_tr" style="display: none;">
						<td style="padding: 9px 5px">
							<input type="text" id="memberName00" name="memberName00" lay-verify="required" autocomplete="off" class="layui-input"
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
								<input type="text" id="userId00" name="userId00"  autocomplete="off" class="layui-input">
							</div>
						</td>
						<td class="align-center">
							<button type="button" class="layui-btn layui-btn-danger layui-btn-xs"
									onclick="member_removerow('MEMBERS_table', this)">
								<i class="layui-icon">&#x1006;</i>
							</button>
						</td>
					</tr>
					</tbody>
				</table>

				<!-- ---------------------------- 参与单位 ----------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: mediumpurple;
					 margin-top: 30px; margin-bottom: 25px;">
					<legend>参与单位</legend>
				</fieldset>

				<input type="text" id="workUnitSum" name="workUnitSum" value="0" style="display: none;">
				<table id="WORKUNITS_table" class="layui-table">
					<colgroup>
						<col>
						<col width="2%">
					</colgroup>
					<thead>
					<tr>
						<th class="align-center" style="text-align: center"><span class="x-red">*</span>完成单位</th>
						<th>
							<button type="button" class="layui-btn layui-btn-xs"
									onclick="unit_add('WORKUNITS_table', 'WORKUNITS_tr')">
								<i class="layui-icon">&#xe608;</i>
							</button>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr id="WORKUNITS_tr" style="display: none;">
						<td style="padding: 9px 5px">
							<input type="text" id="workUnit00" name="workUnit00" lay-verify="required" autocomplete="off" class="layui-input"
								   placeholder="请输入完成单位" value="0">
						</td>
						<td class="align-center">
							<button type="button" class="layui-btn layui-btn-danger layui-btn-xs"
									onclick="unit_removerow('WORKUNITS_table', this)">
								<i class="layui-icon">&#x1006;</i>
							</button>
						</td>
					</tr>
					</tbody>
				</table>

				<div class="layui-form-item" style="margin: 30px 130px">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>

		<%-- 项目成员信息的动态添加 --%>
		<script type="text/javascript">

			var add_member_index_js = 1;
			var member_sum = 0;

			function member_removerow(tableid, obj) {
				var rowIndex = obj.parentNode.parentNode.rowIndex;//获得行的索引
				document.getElementById(tableid).deleteRow(rowIndex);
				member_sum -= 1;
				$("#memberSum").val(member_sum);
			}

			function member_add(tableid, trid) {
				var newRow = '<tr>';
				newRow += $("#" + trid).html();
				newRow += '</tr>';
				newRow = newRow.replace(/00/g, add_member_index_js);
				newRow = newRow.replace(/value="0"/g, 'value=""');
				$("#" + tableid + " tr:last").after(newRow);
				add_member_index_js +=  1;
				member_sum += 1;
				$("#memberSum").val(member_sum);

				layui.use(['form'], function(){
					var form = layui.form;
					form.render(); //更新全部
				});
			}
		</script>

		<%-- 参与单位的动态添加 --%>
		<script type="text/javascript">

			var add_unit_index_js = 1;
			var unit_sum = 0;

			function unit_removerow(tableid, obj) {
				var rowIndex = obj.parentNode.parentNode.rowIndex;//获得行的索引
				document.getElementById(tableid).deleteRow(rowIndex);
				unit_sum -= 1;
				$("#workUnitSum").val(unit_sum);
			}

			function unit_add(tableid, trid) {
				var newRow = '<tr>';
				newRow += $("#" + trid).html();
				newRow += '</tr>';
				newRow = newRow.replace(/00/g, add_unit_index_js);
				newRow = newRow.replace(/value="0"/g, 'value=""');
				$("#" + tableid + " tr:last").after(newRow);
				add_unit_index_js +=  1;
				unit_sum += 1;
				$("#workUnitSum").val(unit_sum);

				layui.use(['form'], function(){
					var form = layui.form;
					form.render(); //更新全部
				});
			}
		</script>

		<script>
			layui.use(['form', 'laydate'], function(){
				var form = layui.form
						, layer = layui.layer
						, laydate = layui.laydate;

				//日期
				laydate.render({
					elem: '#startDate'
					,trigger: 'click' //自定义弹出框，采用click弹出
				});
				//日期
				laydate.render({
					elem: '#endDate'
					,trigger: 'click' //自定义弹出框，采用click弹出
				});

				//监听提交
				form.on('submit(add)', function(data) {

					// 发异步，把数据提交给servlet
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/researchProjectAdd.action",
						data: data.field,
						success: function (data) {
							if (data !== "") {
								layer.alert("添加失败，" + data, {
									icon: 2
								});
							} else {
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
						},
						error: function (data) {
							layer.alert("添加失败，" + data.responseText, {
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

