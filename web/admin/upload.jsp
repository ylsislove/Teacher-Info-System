<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>上传文件测试</title>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
</head>
<body>

<form enctype="multipart/form-data" id="batchUpload" action="${pageContext.request.contextPath }/upload.action" method="post" class="form-horizontal">
    <button class="btn btn-success btn-xs" id="uploadEventBtn" type="button">选择文件</button>
    <input type="file" name="file" id="uploadEventFile" style="display: none">
    <input id="uploadEventPath" disabled="disabled" type="text" placeholder="请择excel表"/>
</form>
<button type="button" class="btn btn-success btn-sm" onclick="user.uploadBtn()">上传</button>
</body>

<script type="text/javascript">
    var User = function () {
        this.init = function () {
            //模拟上传excel
            $("#uploadEventBtn").unbind("click").bind("click", function () {
                $("#uploadEventFile").click();
            });
            $("#uploadEventFile").bind("change", function () {
                $("#uploadEventPath").attr("value", $("#uploadEventFile").val());
            });
        };
        //点击上传钮
        this.uploadBtn = function () {
            var uploadEventFile = $("#uploadEventFile").val();
            if (uploadEventFile == '') {
                alert("请择excel,再上传");
            } else if (uploadEventFile.lastIndexOf(".xls") < 0) {//可判断以.xls和.xlsx结尾的excel
                alert("只能上传Excel文件");
            } else {
                var url = "${pageContext.request.contextPath }/upload.action";
                var formData = new FormData($('form')[0]);
                user.sendAjaxRequest(url, "POST", formData);
            }
        };
        this.sendAjaxRequest = function (url, type, data) {
            $.ajax({
                url: url,
                type: type,
                data: data,
                dataType: "json",
                success: function (result) {
                    alert(result.message);
                },
                error: function (result) {
                    alert(result.message);
                },
                cache: false,
                contentType: false,
                processData: false
            });
        };
    };
    var user;
    $(function () {
        user = new User();
        user.init();
    });
</script>
</html>