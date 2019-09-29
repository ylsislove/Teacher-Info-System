<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>批量添加</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
</head>

<body>

    <div style="padding: 30px; margin: 40px; ;background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">

            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header"><b>批量导入一批doi号</b></div>
                    <div class="layui-card-body">
                        注意事项：
                        <ul>
                            <li>邮箱用于接收这批doi号的查询结果；</li>
                            <li>请选择Excel格式的文件进行上传；</li>
                            <li>Excel文件内按行填写doi号，请勿填写其他内容。</li>
                        </ul>
                    </div>
                    <div class="layui-card-body">
                        <span class="x-red">*</span>邮箱&nbsp;&nbsp;&nbsp;&nbsp;
                        <div class="layui-input-inline">
                            <input id="paper_title" name="paper_title" lay-verify="required" autocomplete="off" class="layui-input"
                                   placeholder="请输入邮箱地址">
                        </div>
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
                            <button type="button" class="layui-btn" id="test9">开始上传</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header"><b>批量导入一批论文</b></div>
                    <div class="layui-card-body">
                        注意事项：
                        <ul>
                            <li>一定要保持列名和表格的列名一致，否则该列信息会被读取为空；</li>
                            <li>列的顺序和列的数目可自定义；</li>
                            <li>请选择Excel格式的文件进行上传；</li>
                        </ul>
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn layui-btn-normal" id="test10">选择文件</button>
                            <button type="button" class="layui-btn" id="test11">开始上传</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <script>
        layui.use('upload', function(){
            var $ = layui.jquery
                ,upload = layui.upload;

            //选完文件后不自动上传
            upload.render({
                elem: '#test8'
                ,url: '/upload/'
                ,auto: false
                ,accept: 'file'
                ,acceptMime: '.xlsx'
                ,bindAction: '#test9'
                ,done: function(res){
                    console.log(res)
                }
            });

            //选完文件后不自动上传
            upload.render({
                elem: '#test10'
                ,url: '/upload/'
                ,auto: false
                ,accept: 'file'
                ,acceptMime: '.xlsx'
                ,bindAction: '#test11'
                ,done: function(res){
                    console.log(res)
                }
            });

        });
    </script>

</body>
</html>