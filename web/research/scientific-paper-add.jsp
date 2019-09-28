<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加论文</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js" charset="utf-8"></script>

		<style type="text/css">
			.layui-form-label {
				width: 120px;
			}
		</style>

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
					console.log(data);
					//发异步，把数据提交给php
					layer.alert("增加成功", {
						icon: 6
					}, function() {
						// 获得frame索引
						var index = parent.layer.getFrameIndex(window.name);
						//关闭当前frame
						parent.layer.close(index);
					});
					return false;	
				});
				form.render()
			});
			
			define([], function(){
			    var complete_unit_list = avalon.define({
			        $id: 'complete_unit_list',
			        //表单数组
			        form: [],
			        //添加表单
			        add_complete_unit: function(){
			            var con = {};
			            complete_unit_list.form.push(con);
			        },
			    });
				var author_list = avalon.define({
				    $id: 'author_list',
				    //表单数组
				    form: [],
				    //添加表单
				    add_author: function(){
				        var con = {};
				        author_list.form.push(con);
				    },
				});
			});
		</script>

	</head>

	<body>
		<div class="layui-anim layui-anim-up" style="padding-left: 125px; padding-top: 35px;">

			<form class="layui-form">

				<!-- ---------------------------- 基本信息 ----------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="width: 520px; border-color: #01AAED">
					<legend>基本信息</legend>
				</fieldset>

				<!-- 发表时间 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label for="birthday" class="layui-form-label"><span class="x-red">*</span>发表时间</label>
						<div class="layui-input-inline">
							<input type="text" name="publish_time" id="date" lay-verify="date" autocomplete="off" class="layui-input"
							 placeholder="yyyy-MM-dd">
						</div>
					</div>
				</div>

				<!-- 论文标题 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label"><span class="x-red">*</span>论文标题</label>
						<div class="layui-input-inline">
							<input id="paper_title" name="paper_title" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="请输入论文标题" style="width: 330px;">
						</div>
					</div>
				</div>

				<!-- 期刊全称/期刊缩写 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>期刊全称 / 缩写</label>
					<div class="layui-input-inline" style="width: 200px;">
						<input id="journal_full_name" name="journal_full_name" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="期刊全称">
					</div>
					<div class="layui-input-inline" style="width: 120px;">
						<input id="journal_short_name" name="journal_short_name" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="期刊缩写">
					</div>
				</div>

				<!-- 卷号/期号 -->
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>卷号 / 期号</label>
					<div class="layui-input-inline" style="width: 200px;">
						<input id="journal_volume" name="journal_volume" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="卷号">
					</div>
					<div class="layui-input-inline" style="width: 120px;">
						<input id="journal_issue" name="journal_issue" lay-verify="required" autocomplete="off" class="layui-input"
						 placeholder="期号">
					</div>
				</div>

				<!-- 起始-结束页码 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label"><span class="x-red">*</span>起始-结束页码</label>
						<div class="layui-input-inline" style="width: 100px;">
							<input id="journal_start_number" name="journal_start_number" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="起始页码">
						</div>
						<div class="layui-form-mid">-</div>
						<div class="layui-input-inline" style="width: 100px;">
							<input id="journal_end_number" name="journal_end_number" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="结束页码">
						</div>
					</div>
				</div>

				<!-- DOI号 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label"><span class="x-red">*</span>DOI号</label>
						<div class="layui-input-inline">
							<input id="doi" name="doi" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入DOI号"
							 style="width: 225px;">
						</div>
					</div>
				</div>

				<!-- ---------------------------- 完成单位 ----------------------------- -->

				<div ms-controller="complete_unit_list">

					<fieldset class="layui-elem-field layui-field-title" style="width: 520px; border-color: #FFB800">
						<legend>完成单位</legend>
					</fieldset>

					<!-- 完成单位 -->
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label"><span class="x-red">*</span>完成单位</label>
							<div class="layui-input-inline">
								<input id="complete_unit" name="complete_unit" lay-verify="required" autocomplete="off" class="layui-input" placeholder="完成单位"
								 style="width: 225px;">
							</div>
						</div>
						<button type="button" class="layui-btn" ms-click="add_complete_unit()" style="margin-left: 35px; margin-bottom: 3px; padding-left: 12px; padding-right: 9px;">
							<i class="layui-icon"></i>
						</button>
					</div>

					<!-- 重复 完成单位 -->
					<div style="overflow: hidden" ms-repeat="form">
						<div class="layui-form-item">
							<div class="layui-inline">
								<label class="layui-form-label"><span class="x-red">*</span>完成单位</label>
								<div class="layui-input-inline">
									<input id="complete_unit" name="complete_unit" lay-verify="required" autocomplete="off" class="layui-input" placeholder="完成单位"
									 style="width: 225px;">
								</div>
							</div>
							<button type="button" class="layui-btn" ms-click="add_complete_unit()" style="margin-left: 35px; margin-bottom: 3px; padding-left: 12px; padding-right: 9px;"><i
								 class="layui-icon"></i></button>
							<button type="button" class="layui-btn  layui-btn-danger" ms-click="$remove" style="margin-bottom: 3px; padding-left: 11px; padding-right: 9px;"><i
								 class="layui-icon"></i></button>
						</div>
					</div>

				</div>
				
				<!-- ---------------------------- 作者详情 ----------------------------- -->
				
				<div ms-controller="author_list">
				
					<fieldset class="layui-elem-field layui-field-title" style="width: 520px; border-color: mediumpurple">
						<legend>作者详情</legend>
					</fieldset>
				
					<!-- 作者详情 -->
					<div class="layui-form-item">
						<label class="layui-form-label"><span class="x-red">*</span>作者 / 标记</label>
						<div class="layui-input-inline" style="width: 150px;">
							<input id="author_name" name="author_name" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="作者姓名">
						</div>
						<div class="layui-input-inline" style="width: 65px;">
							<input id="author_flag" name="author_flag" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="标记">
						</div>
						<button type="button" class="layui-btn" ms-click="add_author()" style="margin-left: 14px; margin-bottom: 3px; padding-left: 12px; padding-right: 9px;">
							<i class="layui-icon"></i>
						</button>
					</div>
				
					<!-- 重复 作者详情 -->
					<div style="overflow: hidden" ms-repeat="form">
						<div class="layui-form-item">
							<label class="layui-form-label"><span class="x-red">*</span>作者 / 标记</label>
							<div class="layui-input-inline" style="width: 150px;">
								<input id="journal_volume" name="journal_volume" lay-verify="required" autocomplete="off" class="layui-input"
								 placeholder="作者姓名">
							</div>
							<div class="layui-input-inline" style="width: 65px;">
								<input id="journal_issue" name="journal_issue" lay-verify="required" autocomplete="off" class="layui-input"
								 placeholder="标记">
							</div>
							<button type="button" class="layui-btn" ms-click="add_author()" style="margin-left: 14px; margin-bottom: 3px; padding-left: 12px; padding-right: 9px;"><i
								 class="layui-icon"></i></button>
							<button type="button" class="layui-btn  layui-btn-danger" ms-click="$remove" style="margin-bottom: 3px; padding-left: 11px; padding-right: 9px;"><i
								 class="layui-icon"></i></button>
						</div>
					</div>
				
				</div>

				<!-- ---------------------------- 其他信息 ----------------------------- -->

				<fieldset class="layui-elem-field layui-field-title" style="width: 520px; border-color: burlywood">
					<legend>其他</legend>
				</fieldset>

				<!-- 论文分区 选填 自动分区 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">论文分区</label>
						<div class="layui-input-inline">
							<input id="paper_partition" name="paper_partition" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="选填，自动分区" style="width: 225px;">
						</div>
					</div>
				</div>

				<!-- 引用次数 选填 自动更新 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">引用次数</label>
						<div class="layui-input-inline">
							<input id="paper_quote_num" name="paper_quote_num" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="选填，自动更新" style="width: 225px;">
						</div>
					</div>
				</div>

				<!-- 论文成就 选填 自动填写 -->
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">论文成就</label>
						<div class="layui-input-inline">
							<input id="paper_achievement" name="paper_achievement" lay-verify="required" autocomplete="off" class="layui-input"
							 placeholder="选填，自动填写" style="width: 225px;">
						</div>
					</div>
				</div>

				<div class="layui-form-item" style="padding-left: 50px;">
					<label class="layui-form-label"></label>
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="add" style="margin-right: 30px;">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>

			</form>

		</div>
	</body>

</html>

<script>
	require(['index'], function(model) {
		avalon.scan();
	});
</script>
