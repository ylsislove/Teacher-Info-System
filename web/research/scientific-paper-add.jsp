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
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js" charset="utf-8"></script>

	</head>

	<body>
		<div class="layui-anim layui-anim-up" style="width: 75%; margin: 30px auto">
			<form class="layui-form layui-form-pane">

				<!-- DOI号 -->
				<div class="layui-form-item">
					<div class="layui-inline" style="width: 85%;">
						<label class="layui-form-label"><span class="x-red">*</span>DOI号</label>
						<div class="layui-input-inline">
							<input id="doi" name="doi" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入DOI号"
							style="width: 200%;">
						</div>
					</div>
					<div class="layui-inline">
						<button class="layui-btn">查找</button>
					</div>
				</div>

				<!-- ---------------------------- 基本信息 ----------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: #01AAED;
					 margin-top: 25px; margin-bottom: 25px;">
					<legend>发表时间
						<div class="layui-input-inline">
							<input type="text" id="date" name="date" lay-verify="required" placeholder="必填" autocomplete="off" class="layui-input"
								   style="margin-left: 10px; margin-right: 5px;width: 120px; height: 35px; font-size: 15px">
						</div>
					</legend>
				</fieldset>

				<!-- 论文标题 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>论文标题</label>
					<div class="layui-input-block">
						<input id="paper_title" name="paper_title" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="请输入论文标题">
					</div>
				</div>

				<!-- 期刊全称/期刊缩写 -->
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 25%;"><span class="x-red">*</span>期刊全称 / 缩写</label>
					<div class="layui-input-inline" style="width: 48%;">
						<input id="journal_full_name" name="journal_full_name" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="期刊全称">
					</div>
					<div class="layui-input-inline" style="width: 150px; margin-right: 0">
						<input id="journal_short_name" name="journal_short_name" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="期刊缩写">
					</div>
				</div>

				<!-- 卷号/期号 -->
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 25%;"><span class="x-red">*</span>卷号 / 期号</label>
					<div class="layui-input-inline" style="width: 30%;">
						<input id="journal_volume" name="journal_volume" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="卷号">
					</div>
					<div class="layui-input-inline" style="width: 30%;">
						<input id="journal_issue" name="journal_issue" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="期号">
					</div>
				</div>

				<!-- 起始-结束页码 -->
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 25%;"><span class="x-red">*</span>起始 - 结束页码</label>
					<div class="layui-input-inline" style="width: 30%;">
						<input id="journal_start_number" name="journal_start_number" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="起始页码">
					</div>
					<div class="layui-input-inline" style="width: 30%;">
						<input id="journal_end_number" name="journal_end_number" lay-verify="required" autocomplete="off" class="layui-input"
							   placeholder="结束页码">
					</div>
				</div>

				<!-- --------------------------- 作者详情 --------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: mediumpurple;
					 margin-top: 30px; margin-bottom: 25px;">
					<legend>作者详情</legend>
				</fieldset>

				<input type="text" id="authorSum" name="authorSum" value="0" style="display: none;">
				<table id="AUTHORS_table" class="layui-table">
					<colgroup>
						<col>
						<col width="20%">
						<col width="25%">
						<col width="20%">
						<col width="2%">
					</colgroup>
					<thead>
					<tr>
						<th class="align-center"><span class="x-red">*</span>姓名</th>
						<th class="align-center"><span class="x-red">*</span>标记</th>
						<th class="align-center">是否为我校老师</th>
						<th class="align-center">教师工号</th>
						<th>
							<button type="button" class="layui-btn layui-btn-xs"
									onclick="author_add('AUTHORS_table', 'AUTHORS_tr')">
								<i class="layui-icon">&#xe608;</i>
							</button>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr id="AUTHORS_tr" style="display: none;">
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<input type="text" id="authorName00" name="authorName00" lay-verify="required" autocomplete="off" class="layui-input"
									   placeholder="必填" value="0">
							</div>
						</td>
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<input type="text" id="mask00" name="mask00" lay-verify="required" autocomplete="off" class="layui-input"
									   placeholder="必填" value="0">
							</div>
						</td>
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<select id="isOurTeacher" name="isOurTeacher">
									<option value="0">请选择</option>
									<option value="是">是</option>
									<option value="否">否</option>
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
									onclick="author_removerow('AUTHORS_table', this)">
								<i class="layui-icon">&#x1006;</i>
							</button>
						</td>
					</tr>
					</tbody>
				</table>

				<!-- ---------------------------- 完成单位 ----------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="border-color: mediumpurple;
					 margin-top: 30px; margin-bottom: 25px;">
					<legend>完成单位</legend>
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

		<%-- 作者信息的动态添加 --%>
		<script type="text/javascript">

			var add_author_index_js = 1;
			var author_sum = 0;

			function author_removerow(tableid, obj) {
				var rowIndex = obj.parentNode.parentNode.rowIndex;//获得行的索引
				document.getElementById(tableid).deleteRow(rowIndex);
				author_sum -= 1;
				$("#authorSum").val(author_sum);
			}

			function author_add(tableid, trid) {
				var newRow = '<tr>';
				newRow += $("#" + trid).html();
				newRow += '</tr>';
				newRow = newRow.replace(/00/g, add_author_index_js);
				newRow = newRow.replace(/value="0"/g, 'value=""');
				$("#" + tableid + " tr:last").after(newRow);
				add_author_index_js +=  1;
				author_sum += 1;
				$("#author_sum").val(author_sum);

				layui.use(['form'], function(){
					var form = layui.form;
					form.render(); //更新全部
				});
			}
		</script>

		<%-- 完成单位的动态添加 --%>
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
					elem: '#date'
					,type: 'year'
					,trigger: 'click' //自定义弹出框，采用click弹出
				});

				//监听提交
				form.on('submit(add)', function(data) {

					// 发异步，把数据提交给servlet
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/scientificPaperAdd.action",
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

