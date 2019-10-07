<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加专利信息</title>
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

				<!-- 申请时间 授权时间 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>申请时间</label>
					<div class="layui-input-inline" style="width: 179px;">
						<input type="text" name="applicationDate" id="applicationDate" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="yyyy-MM-dd">
					</div>
					<label class="layui-form-label"><span class="x-red">*</span>授权时间</label>
					<div class="layui-input-inline" style="width: 179px; margin-right: 0">
						<input type="text" name="authorizationDate" id="authorizationDate" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="yyyy-MM-dd">
					</div>
				</div>

				<!-- 专利号 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>专利号</label>
					<div class="layui-input-block">
						<input id="patentId" name="patentId" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="请输入专利号">
					</div>
				</div>

				<!-- 专利名称 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>专利名称</label>
					<div class="layui-input-block">
						<input id="title" name="title" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="请输入专利名称">
					</div>
				</div>

				<!-- 专利类型 专利级别 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>专利类型</label>
					<div class="layui-input-inline" style="width: 179px;">
						<select name="patentType" lay-verify="required">
							<option value="">请选择</option>
							<option value="发明">发明</option>
							<option value="实用新型">实用新型</option>
							<option value="外观设计">外观设计</option>
						</select>
					</div>
					<label class="layui-form-label"><span class="x-red">*</span>专利级别</label>
					<div class="layui-input-inline" style="width: 179px; margin-right: 0">
						<select name="level" lay-verify="required">
							<option value="">请选择</option>
							<option value="中国专利">中国专利</option>
							<option value="国际专利">国际专利</option>
						</select>
					</div>
				</div>


				<!-- --------------------------- 发明人详情 --------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: mediumpurple;
					 margin-top: 30px; margin-bottom: 25px;">
					<legend>发明人详情</legend>
				</fieldset>

				<input type="text" id="inventorSum" name="inventorSum" value="0" style="display: none;">
				<table id="INVENTORS_table" class="layui-table">
					<colgroup>
						<col width="20%">
						<col>
						<col width="25%">
						<col width="20%">
						<col width="2%">
					</colgroup>
					<thead>
					<tr>
						<th class="align-center"><span class="x-red">*</span>姓名</th>
						<th class="align-center">发明人单位</th>
						<th class="align-center">是否为我校老师</th>
						<th class="align-center">教师工号</th>
						<th>
							<button type="button" class="layui-btn layui-btn-xs"
									onclick="inventor_add('INVENTORS_table', 'INVENTORS_tr')">
								<i class="layui-icon">&#xe608;</i>
							</button>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr id="INVENTORS_tr" style="display: none;">
						<td style="padding: 9px 5px">
							<input type="text" id="inventorName00" name="inventorName00" lay-verify="required" autocomplete="off" class="layui-input"
								   placeholder="必填" value="0">
						</td>
						<td style="padding: 9px 5px">
							<input type="text" id="inventorUnit00" name="inventorUnit00" autocomplete="off" class="layui-input"
								   placeholder="选填">
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
									onclick="inventor_removerow('INVENTORS_table', this)">
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

		<%-- 发明人信息的动态添加 --%>
		<script type="text/javascript">

			var add_inventor_index_js = 1;
			var inventor_sum = 0;

			function inventor_removerow(tableid, obj) {
				var rowIndex = obj.parentNode.parentNode.rowIndex;//获得行的索引
				document.getElementById(tableid).deleteRow(rowIndex);
				inventor_sum -= 1;
				$("#inventorSum").val(inventor_sum);
			}

			function inventor_add(tableid, trid) {
				var newRow = '<tr>';
				newRow += $("#" + trid).html();
				newRow += '</tr>';
				newRow = newRow.replace(/00/g, add_inventor_index_js);
				newRow = newRow.replace(/value="0"/g, 'value=""');
				$("#" + tableid + " tr:last").after(newRow);
				add_inventor_index_js +=  1;
				inventor_sum += 1;
				$("#inventorSum").val(inventor_sum);

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
					elem: '#applicationDate'
					,trigger: 'click' //自定义弹出框，采用click弹出
				});
				//日期
				laydate.render({
					elem: '#authorizationDate'
					,trigger: 'click' //自定义弹出框，采用click弹出
				});

				//监听提交
				form.on('submit(add)', function(data) {

					// 发异步，把数据提交给servlet
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/patentAdd.action",
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

