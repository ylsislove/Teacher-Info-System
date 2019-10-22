<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>导出教师信息</title>
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
                {field: 'username', title: '姓名', width: 120, fixed: 'left', filter: true},
                {field: 'userId', title: '工号', width: 120, fixed: 'left', filter: true},
                {field: 'sex', title: '性别', width: 80, filter: true},
                {field: 'birth', title: '出生年月', width: 120, sort:true, filter: {type: 'date[yyyy-MM-dd HH:mm:ss]'}},
                {field: 'department', title: '所属系别', width: 120, filter: true},
                {field: 'worktime', title: '参加工作时间', width: 120, sort:true, filter: {type: 'date[yyyy-MM-dd HH:mm:ss]'}},
                {field: 'part', title: '所属党派', width: 120, filter: true},
                {field: 'parttime', title: '入党时间', width: 120, sort:true, filter: {type: 'date[yyyy-MM-dd HH:mm:ss]'}},
                {field: 'position', title: '职务', width: 120, filter: true},
                {field: 'title', title: '职称', width: 120, filter: true},
                {field: 'titletime', title: '评职时间', width: 120, sort:true, filter: {type: 'date[yyyy-MM-dd HH:mm:ss]'}},
                {field: 'worktype', title: '岗位类别', width: 120, filter: true},
                {field: 'worklevel', title: '岗位等级', width: 120, sort:true, filter: true},
                {field: 'email', title: '常用邮箱', width: 165, filter: true},
                {field: 'tel', title: '手机号', width: 165, filter: true},
                {field: 'honorarytitle', title: '个人荣誉称号', width: 165, filter: {split:';'}},
                {field: 'parttimejob', title: '社会与学术兼职', width: 165, filter: {split:';'}},
                {field: 'enname', title: '英文名', width: 165, filter: {split:';'}},
            ]]
            ,done: function () {
                soulTable.render(this)
            }
        });

        search({role: '${param.role}'});
        function search(data) {
            var loading = layer.load(2);
            $.ajax({
                url: '${pageContext.request.contextPath }/memberExport.action', //数据接口
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