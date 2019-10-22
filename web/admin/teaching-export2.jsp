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
                {field: 'username', title: '姓名', width: 120, fixed: 'left', filter: true},
                {field: 'userId', title: '工号', width: 120, fixed: 'left', filter: true},
                {field: 'courseTime', title: '授课时间', width: 120, sort:true, filter: {type: 'date[yyyy-MM-dd HH:mm:ss]'}},
                {field: 'courseName', title: '课程名称', width: 165, filter: true},
                {field: 'courseAttr', title: '性质', width: 120, filter: true},
                {field: 'courseTotalHours', title: '总学时', width: 120, sort:true, filter: true},
                {field: 'courseRealHours', title: '实际授课学时', width: 120, sort:true, filter: true},
                {field: 'classrooms', title: '教学班级', width: 165, filter: {split:','}},
                {field: 'classNum', title: '班级数', width: 120, sort:true, filter: true},
                {field: 'stuNum', title: '学生人数', width: 120, sort:true, filter: true}
                <c:if test="${param.type == 1 || param.type == 3}">
                    ,{field: 'isEnglish', title: '英文授课', width: 120, filter: true}
                </c:if>
                <c:if test="${param.type == 2 || param.type == 4}">
                    ,{field: 'groupNum', title: '分组数目', width: 120, sort:true, filter: true}
                </c:if>
            ]]
            ,done: function () {
                soulTable.render(this)
            }
        });

        search({type: ${param.type}, role: '${param.role}'});
        function search(data) {
            var loading = layer.load(2);
            $.ajax({
                url: '${pageContext.request.contextPath }/teachingExport.action', //数据接口
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