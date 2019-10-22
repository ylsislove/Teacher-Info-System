<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>导出${param.name}信息</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/lib/layui/ext/soulTable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/lib/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/lib/layui/layui.js"></script>
    <script>
        layui.config({
            base: '${pageContext.request.contextPath }/lib/layui/ext/',   // 模块所在目录
            version: 'v1.4.2' // 插件版本号
        }).extend({
            soulTable: 'soulTable'  // 模块别名
        });
    </script>

</head>
<body style="margin: 10px">

<table id="myTable3" ></table>
<script>
    layui.use(['form', 'table','soulTable'], function () {
        var table = layui.table,
            soulTable = layui.soulTable,
            $ = layui.$;

        table.render({
            elem: '#myTable3'
            ,height: 700
            ,limit: 15
            ,page: true
            ,limits: [15,30,40,50,60,70,80,90,100]
            ,cols: [[
                {type: 'numbers', title: '序号', fixed: 'left'},
                {field: 'title', title: '项目名称', width: 300, fixed: 'left', filter: true},
                {field: 'projectId', title: '项目编号', width: 165, filter: true},
                {field: 'startDate', title: '起始时间', width: 120, sort:true, filter: {type: 'date[yyyy-MM-dd HH:mm:ss]'}},
                {field: 'endDate', title: '截止时间', width: 120, sort:true, filter: {type: 'date[yyyy-MM-dd HH:mm:ss]'}},
                {field: 'source', title: '项目来源', width: 165, filter: true},
                {field: 'levelType', title: '项目类型', width: 120, filter: true},
                {field: 'level', title: '项目级别', width: 120, filter: true},
                {field: 'contractFunds', title: '项目合同经费', width: 165, sort:true, filter: true},
                {field: 'actualFunds', title: '实际到账经费', width: 165, sort:true, filter: true},
                {field: 'members', title: '项目成员', width: 165, filter: {split:'|'}},
                {field: 'workUnits', title: '参与单位', width: 165, filter: {split:';'}},
            ]]
            ,done: function () {
                soulTable.render(this)
            }
        });

        search({type: ${param.type}, role: '${param.role}'});
        function search(data) {
            var loading = layer.load(2);
            $.ajax({
                url: '${pageContext.request.contextPath }/researchProjectExport.action', //数据接口
                data: data,
                dataType: 'json',
                success: function (res) {
                    table.reload('myTable3', {
                        data: res.data
                    })
                },
                complete: function () {
                    layer.close(loading)
                }
            })
        }
    })
</script>

</body>
</html>