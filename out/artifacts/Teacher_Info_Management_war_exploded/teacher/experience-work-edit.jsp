<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑工作经历</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>

</head>
<body>

    <form class="layui-form">
        <input type="text" id="sum" name="sum" value="0" style="display: none;">
        <input type="text" id="type" name="type" value="3" style="display: none;">
        <table id="WORK_table" class="layui-table" style="width: 95%; margin: 30px auto">
            <colgroup>
                <col width="17%">
                <col width="17%">
                <col>
                <col width="25%">
                <col width="2%">
            </colgroup>
            <thead>
            <tr>
                <th class="align-center"><span class="x-red">*</span>入职时间</th>
                <th class="align-center"><span class="x-red">*</span>离职时间</th>
                <th class="align-center"><span class="x-red">*</span>工作单位</th>
                <th class="align-center">岗位/职位</th>
                <th>
                    <button type="button" class="layui-btn layui-btn-xs"
                            onclick="add('WORK_table', 'WORK_tr')">
                        <i class="layui-icon">&#xe608;</i>
                    </button>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr id="WORK_tr" style="display: none;">
                <td style="padding: 9px 5px">
                    <div class="layui-input-inline">
                        <input type="text" id="workDate00" name="workDate00" lay-verify="required" autocomplete="off" class="layui-input"
                               placeholder="yyyy-MM" value="0">
                    </div>
                </td>
                <td style="padding: 9px 5px">
                    <div class="layui-input-inline">
                        <input type="text" id="leaveDate00" name="leaveDate00" lay-verify="required" autocomplete="off" class="layui-input"
                               placeholder="yyyy-MM" value="0">
                    </div>
                </td>
                <td style="padding: 9px 5px">
                    <div class="layui-input-inline" style="width: 237px;">
                        <input type="text" id="departmentName00" name="departmentName00" lay-verify="required" autocomplete="off" class="layui-input"
                               placeholder="请填写工作单位" value="0">
                    </div>
                </td>
                <td style="padding: 9px 5px">
                    <div class="layui-input-inline">
                        <input type="text" id="workName00" name="workName00" autocomplete="off" class="layui-input"
                               placeholder="选填">
                    </div>
                </td>
                <td class="align-center">
                    <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"
                            onclick="removerow('WORK_table', this)">
                        <i class="layui-icon">&#x1006;</i>
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="layui-form-item" style="margin: 30px 210px">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

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
    }

    <c:forEach items="${workList }" var="work">
        add('WORK_table', 'WORK_tr');
        $("#workDate"+sum).val("${work.workDate}");
        $("#leaveDate"+sum).val("${work.leaveDate}");
        $("#departmentName"+sum).val("${work.departmentName}");
        $("#workName"+sum).val("${work.workName}");
    </c:forEach>

</script>

    <script>
        layui.use(['form', 'laydate'], function () {
            var form = layui.form;

            //监听提交
            form.on('submit(add)', function (data) {
                // 发异步，把数据提交给servlet
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath }/experienceEdit.action",
                    data: data.field,
                    success: function (data) {
                        if (data !== "") {
                            layer.alert("修改失败，" + data, {
                                icon: 2
                            });
                        }
                        else{
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
        });

    </script>

</body>
</html>