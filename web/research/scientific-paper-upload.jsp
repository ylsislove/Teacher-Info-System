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

<%--            <div class="layui-col-md6">--%>
<%--                <div class="layui-card">--%>
<%--                    <div class="layui-card-header"><b>批量导入一批doi号</b></div>--%>
<%--                    <div class="layui-card-body">--%>
<%--                        注意事项：--%>
<%--                        <ul>--%>
<%--                            <li>邮箱用于接收这批doi号的查询结果；</li>--%>
<%--                            <li>请选择Excel格式的文件进行上传；</li>--%>
<%--                            <li>Excel文件内按行填写doi号，请勿填写其他内容。</li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                    <input id="email" name="email" autocomplete="off" class="layui-input"--%>
<%--                           placeholder="请输入邮箱地址" style="display: none;">--%>
<%--                    <div class="layui-card-body">--%>
<%--                        <div class="layui-upload">--%>
<%--                            <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>--%>
<%--                            <button type="button" class="layui-btn" onclick="exportDataDoi()">导出模板</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

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

            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header"><b>导入地大分区表</b></div>
                    <div class="layui-card-body">
                        注意事项：
                        <ul>
                            <li>第一列期刊名，第二列级别，请勿添加其他信息；</li>
                            <li>请选择Excel格式的文件进行上传；</li>
                        </ul>
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn" id="test12">导入地大分区表</button>
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
            function uploadExcel1(files) {
                try {
                    excel.importExcel(files, {
                        // 读取数据的同时梳理数据
                        fields: {
                            'doi': 'A'
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
                                // 检查是否输入邮箱
                                var email = $('#email').val();
                                if (email === '') {
                                    layer.prompt({
                                        formType: 0,       // 普通文本
                                        title: '请输入邮箱'
                                    }, function(value, index, elem){
                                        alert(value); //得到value
                                        $('#email').val(value);
                                        layer.close(index);
                                    });
                                } else {
                                    $.ajax({
                                        type: "POST",
                                        url: "${pageContext.request.contextPath }/scientificPaperUpload.action",
                                        data: "data="+JSON.stringify(data)+"&mode=1&type=${param.type}&email="+email,
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

            function uploadExcel2(files) {
                try {
                    excel.importExcel(files, {
                        // 读取数据的同时梳理数据
                        fields: {
                            'date': 'A',
                            'title': 'B',
                            'journalFullName': 'C',
                            'journalShortName': 'D',
                            'reelNum': 'E',
                            'issue': 'F',
                            'beginPageNum': 'G',
                            'endPageNum': 'H',
                            'doiNum': 'I',
                            'authors': 'J',
                            'workUnits': 'K',
                            'subarea': 'L',
                            'citeNum': 'M',
                            'achievement': 'N'
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
                                    data: "data="+JSON.stringify(data)+"&mode=2&type=${param.type}",
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

            function uploadExcel3(files) {
                try {
                    excel.importExcel(files, {
                        // 读取数据的同时梳理数据
                        fields: {
                            'name': 'A',
                            'level': 'B'
                        }
                    }, function(data) {
                        console.log(data);
                        console.log(data[0].Sheet1);
                        // 如果不需要展示直接上传，可以再次 $.ajax() 将JSON数据通过 JSON.stringify() 处理后传递到后端即可
                        layer.open({
                            title: '文件转换结果',
                            area: ['600px', '400px'],
                            tipsMore: true,
                            content: laytpl($('#LAY-excel-export-ans').html()).render({
                                data: {0:{"Sheet1":[data[0].Sheet1[0], data[0].Sheet1[1], data[0].Sheet1[2], "......"]}},
                                files: files
                            })
                            ,btn: ['确认上传', '取消上传']
                            ,yes: function(index, layero){
                                $.ajax({
                                    type: "POST",
                                    url: "${pageContext.request.contextPath }/scientificPaperUpload.action",
                                    data: "data="+JSON.stringify(data).replace(/&/g, '000')+"&mode=3&type=${param.type}",
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

            // 批量导入一批DOI号
            upload.render({
                elem: '#test8'      //绑定元素
                ,url: '/upload/'    //上传接口（PS:这里不用传递整个 excel）
                ,auto: false        //选择文件后不自动上传
                ,accept: 'file'
                ,acceptMime: '.xlsx'
                ,choose: function(obj) { // 选择文件回调
                    var files = obj.pushFile();
                    files = Object.values(files); // 注意这里的数据需要是数组，所以需要转换一下
                    uploadExcel1(files);
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

            // 批量导入一批论文数据
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

            // 导入地大分区表
            upload.render({
                elem: '#test12'      //绑定元素
                ,url: '/upload/'     //上传接口（PS:这里不用传递整个 excel）
                ,auto: false         //选择文件后不自动上传
                ,accept: 'file'
                ,acceptMime: '.xlsx'
                ,choose: function(obj) { // 选择文件回调
                    var files = obj.pushFile();
                    files = Object.values(files); // 注意这里的数据需要是数组，所以需要转换一下
                    uploadExcel3(files);
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

    <script>
        // 导出模板
        function exportDataDoi() {
            layui.use(['excel'], function() {
                var excel = layui.excel;
                // 如果数据量特别大，最好直接传入 AOA 数组，减少内存/CPU消耗
                var data = [
                    ["doi"],
                    ["10.1101/679324"]
                ];
                excel.exportExcel({
                    sheet1: data
                }, '批量添加DOI-模板.xlsx', 'xlsx');
            });
        }
    </script>


    <script>
        // 导出模板
        function exportDataTest() {
            layui.use(['excel'], function() {
                var excel = layui.excel;
                // 如果数据量特别大，最好直接传入 AOA 数组，减少内存/CPU消耗
                var data = [
                    ["发表时间", '论文标题', '期刊全称', '期刊缩写', '卷号', '期号',
                        '起始页码', '结束页码', 'DOI号', '作者详情', '完成单位', '论文分区',
                        '引用次数', '论文成就'
                    ],
                    ["2013", "High precision coding in mouse visual cortex",
                        'Journal of Catalysis', 'J. Catal', '46', '3', '53', '56',
                        '10.1101/679324', 'Zhang',
                        '中国地质大学（武汉）;华中科技大学;', 'T2', '3012', '热点'
                    ]
                ];
                excel.exportExcel({
                    sheet1: data
                }, '批量添加${param.name}-模板.xlsx', 'xlsx');
            });
        }
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
                    <pre class="layui-code">{{JSON.stringify(content, null, 2)}}</pre>
                </div>
                {{# }); }}
            </div>
        </div>
        {{# }) }}
    </script>

</body>
</html>