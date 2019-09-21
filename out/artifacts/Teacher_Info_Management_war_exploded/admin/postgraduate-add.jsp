<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加研究生指导信息</title>
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
		<div class="layui-anim layui-anim-up" style="width: 95%; margin: 30px auto">
			<form class="layui-form layui-form-pane">

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label"><span class="x-red">*</span>教师工号</label>
						<div class="layui-input-inline">
							<input type="text" name="userId" lay-verify="required" placeholder="请填写工号" autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-inline">
						<label class="layui-form-label">教师姓名</label>
						<div class="layui-input-inline">
							<input type="text" name="username" placeholder="选填" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
 
				<!-- --------------------------- 研究生详情 --------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="width: 620px; border-color: mediumpurple;
					 margin-top: 30px; margin-bottom: 30px;">
					<legend>
						研究生详情
						<div class="layui-input-inline">
							<input type="text" id="academicDate" name="academicDate" lay-verify="required" placeholder="必填，入学时间" autocomplete="off" class="layui-input"
								   style="margin-left: 30px; width: 120px; height: 30px; font-size: 14px">
						</div>
					</legend>
				</fieldset>

				<input type="text" id="sum" name="sum" value="0" style="display: none;">
				<table id="POSTGRADUATE_table" class="layui-table">
					<colgroup>
						<col width="17%">
						<col width="17%">
						<col width="20%">
						<col width="15%">
						<col >
						<col width="2%">
					</colgroup>
					<thead>
					<tr>
						<th class="align-center"><span class="x-red">*</span>毕业时间</th>
						<th class="align-center"><span class="x-red">*</span>姓名</th>
						<th class="align-center"><span class="x-red">*</span>学号</th>
						<th class="align-center"><span class="x-red">*</span>类型</th>
						<th class="align-center"><span class="x-red">*</span>是否第一指导老师</th>
						<th>
							<button type="button" class="layui-btn layui-btn-xs"
									onclick="add('POSTGRADUATE_table', 'POSTGRADUATE_tr')">
								<i class="layui-icon">&#xe608;</i>
							</button>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr id="POSTGRADUATE_tr" style="display: none;">
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<input type="text" id="graduationDate00" name="graduationDate00" lay-verify="required" autocomplete="off" class="layui-input"
									   placeholder="yyyy" value="0">
							</div>
						</td>
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<input type="text" id="stuName00" name="stuName00" lay-verify="required" autocomplete="off" class="layui-input"
									   placeholder="必填" value="0">
							</div>
						</td>
						<td style="padding: 9px 5px">
							<div class="layui-input-inline" style="width: 138px;">
								<input type="text" id="stuId00" name="stuId00" lay-verify="required" autocomplete="off" class="layui-input"
									   placeholder="必填" value="0">
							</div>
						</td>
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<select id="stuType00" name="stuType00" lay-verify="required" lay-search="">
									<option value="0">请选择</option>
									<option value="学硕">学硕</option>
									<option value="专硕">专硕</option>
									<option value="在职">在职</option>
									<option value="博士">博士</option>
								</select>
							</div>
						</td>
						<td style="padding: 9px 5px">
							<div class="layui-input-inline">
								<input type="radio" name="isFirstTutor00" value="是" title="是" checked="">
								<input type="radio" name="isFirstTutor00" value="否" title="否">
							</div>
						</td>
						<td class="align-center">
							<button type="button" class="layui-btn layui-btn-danger layui-btn-xs"
									onclick="removerow('POSTGRADUATE_table', this)">
								<i class="layui-icon">&#x1006;</i>
							</button>
						</td>
					</tr>
					</tbody>
				</table>

				<div class="layui-form-item" style="margin: 30px 205px">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>

		<script type="text/javascript">

			var add_index_js = 1;
			var sum = 0;

			function removerow(tableid, obj) {
				var rowIndex = obj.parentNode.parentNode.rowIndex;//获得行的索引
				document.getElementById(tableid).deleteRow(rowIndex);
				sum -= 1;
				$("#sum").val(sum);
			}

			function add(tableid, trid) {
				var newRow = '<tr>';
				newRow += $("#" + trid).html();
				newRow += '</tr>';
				newRow = newRow.replace(/00/g, add_index_js);
				newRow = newRow.replace(/value="0"/g, 'value=""');
				$("#" + tableid + " tr:last").after(newRow);
				add_index_js +=  1;
				sum += 1;
				$("#sum").val(sum);

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
					elem: '#academicDate'
					,type: 'year'
					,trigger: 'click' //自定义弹出框，采用click弹出
				});

				//监听提交
				form.on('submit(add)', function(data) {

					// 发异步，把数据提交给servlet
					$.ajax({
						type: "POST",
						url: "${pageContext.request.contextPath }/postgraduateAdd.action",
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

