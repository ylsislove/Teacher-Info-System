<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>批量添加${param.name}</title>
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
    <script type="text/javascript">
        layui.config({
            base: '${pageContext.request.contextPath }/lib/layui_exts/'
        }).extend({
            excel: 'excel'
        });
    </script>
<%--    <script src="${pageContext.request.contextPath }/js/index.js"></script>--%>
</head>

<body>

    <div style="padding: 30px; margin: 40px; ;background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">

            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header"><b>批量导入一批${param.name}</b></div>
                    <div class="layui-card-body">
                        注意事项：
                        <ul>
                            <li>请按照模板里的格式填写${param.name}信息，否则可能会导入信息失败哦；</li>
                            <li>请选择Excel格式的文件进行上传；</li>
                        </ul>
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn layui-btn-normal" id="test10">选择文件</button>
                            <button type="button" class="layui-btn" onclick="exportDataTest()">导出模板</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <script>
        layui.use(['jquery', 'layer', 'upload', 'excel', 'laytpl', 'element', 'code'], function() {
            var $ = layui.jquery;
            var layer = layui.layer;
            var upload = layui.upload;
            var excel = layui.excel;
            var laytpl = layui.laytpl;
            var element = layui.element;


            /**
             * 上传excel的处理函数，传入文件对象数组
             * @param  {[type]} files [description]
             * @return {[type]}       [description]
             */

            function uploadExcel2(files) {
                try {
                    excel.importExcel(files, {
                        // 读取数据的同时梳理数据
                        fields: {
                            'username': 'A',
                            'userId': 'B',
                            'sex': 'C',
                            'department': 'D',
                            'birth': 'E',
                            'worktime': 'F',
                            'parttime': 'G',
                            'position': 'H',
                            'title': 'I',
                            'titletime': 'J',
                            'worktype': 'K',
                            'worklevel': 'L',
                            'email': 'M',
                            'honorarytitle': 'N',
                            'parttimejob': 'O',
                            'enname': 'P'
                        }
                    }, function(data) {
                        // 如果不需要展示直接上传，可以再次 $.ajax() 将JSON数据通过 JSON.stringify() 处理后传递到后端即可
                        layer.open({
                            title: '文件转换结果',
                            area: ['600px', '400px'],
                            tipsMore: true,
                            content: laytpl($('#LAY-excel-export-ans').html()).render({
                                data: data,
                                files: files
                            })
                            ,btn: ['确认上传', '取消上传']
                            ,yes: function(index, layero){
                                $.ajax({
                                    type: "POST",
                                    url: "${pageContext.request.contextPath }/scientificPaperUpload.action",
                                    data: "data="+JSON.stringify(data)+"&type=2",
                                    dataType: "json",
                                    success: function (data) {
                                        console.log("上传成功");
                                    },
                                    error: function (data) {
                                        // 不知道为什么，不管后端成功与否，这里返回的都是失败
                                        if (data.responseText !== "") {
                                            layer.alert("上传失败，请重新尝试或联系管理员\n" + data.responseText, {
                                                icon: 2
                                            }, function () {
                                                // 刷新父页面
                                                location.reload();
                                            });
                                        }
                                        else{
                                            layer.alert("上传成功", {
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
                                    }
                                });
                            }
                            ,btn2: function(index, layero){
                                // 刷新父页面
                                location.reload();
                                //return false 开启该代码可禁止点击该按钮关闭
                            }
                            ,cancel: function(){
                                // 刷新父页面
                                location.reload();
                                //return false 开启该代码可禁止点击该按钮关闭
                            },
                            success: function() {
                                element.render('tab');
                                layui.code({});
                            }
                        });
                    });
                } catch (e) {
                    layer.alert(e.message);
                }
            }

            // 批量导入一批项目数据
            upload.render({
                elem: '#test10'      //绑定元素
                ,url: '/upload/'     //上传接口（PS:这里不用传递整个 excel）
                ,auto: false         //选择文件后不自动上传
                ,accept: 'file'
                ,acceptMime: '.xlsx'
                ,choose: function(obj) { // 选择文件回调
                    var files = obj.pushFile();
                    files = Object.values(files); // 注意这里的数据需要是数组，所以需要转换一下
                    uploadExcel2(files);
                }
                ,done: function(res, index, upload){
                    console.log(res.code)
                }
                ,error: function (index, upload) {
                    layer.alert("上传失败，请重新尝试或联系管理员", {
                        icon: 2
                    }, function () {
                        // 刷新父页面
                        location.reload();
                    });
                }
            });

        });
    </script>

    <script type="text/html" id="LAY-excel-export-ans">
        {{# layui.each(d.data, function(index, item){ }}
        <blockquote class="layui-elem-quote">{{d.files[index].name}}</blockquote>
        <div class="layui-tab">
            <ul class="layui-tab-title">
                {{# layui.each(item, function(sheetname, content) { }}
                <li>{{sheetname}}</li>
                {{# }); }}
            </ul>
            <div class="layui-tab-content">
                {{# layui.each(item, function(sheetname, content) { }}
                <div class="layui-tab-item">
<%--                    <table class="layui-table">--%>
<%--                        {{# layui.each(content, function(index, value) { }}--%>
<%--                        <tr>--%>
<%--                            {{# layui.each(value, function(key, val) { }}--%>
<%--                            <td>{{val}}</td>--%>
<%--                            {{# });}}--%>
<%--                        </tr>--%>
<%--                        {{# });}}--%>
<%--                    </table>--%>
                    <pre class="layui-code">{{JSON.stringify(content, null, 2)}}</pre>
                </div>
                {{# }); }}
            </div>
        </div>
        {{# }) }}
    </script>

</body>
</html>