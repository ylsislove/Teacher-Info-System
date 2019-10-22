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
                {field: 'date', title: '发表时间', width: 120, fixed: 'left', sort:true, filter: true},
                {field: 'title', title: '论文标题', width: 300, fixed: 'left', filter: true},
                {field: 'journalFullName', title: '期刊全称', width: 165, filter: true},
                {field: 'journalShortName', title: '期刊缩写', width: 100, filter: true},
                {field: 'reelNum', title: '卷号', width: 80},
                {field: 'issue', title: '期号', width: 80},
                {field: 'beginPageNum', title: '起始页码', width: 80},
                {field: 'endPageNum', title: '结束页码', width: 80},
                {field: 'doiNum', title: 'DOI号', width: 165},
                {field: 'authors', title: '作者详情', width: 165, filter: {split:'|'}},
                {field: 'workUnits', title: '完成单位', width: 165, filter: {split:';'}},
                {field: 'subarea', title: '论文分区', width: 120, filter: true},
                {field: 'citeNum', title: '引用次数', width: 120, sort:true, filter: true},
                {field: 'achievement', title: '论文成就', width: 120, filter: true},
                {field: 'updateTime', title: '最后更新时间', width: 200, fixed: 'right', sort:true, filter: {type: 'date[yyyy-MM-dd HH:mm:ss]'}},
            ]]
            ,done: function () {
                soulTable.render(this)
            }
        });

        search({type: ${param.type}, role: '${param.role}'});
        function search(data) {
            var loading = layer.load(2);
            $.ajax({
                url: '${pageContext.request.contextPath }/scientificPaperExport.action', //数据接口
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