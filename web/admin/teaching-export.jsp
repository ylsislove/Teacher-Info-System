<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>导出${param.name}信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/lib/layui/css/layui.css" media="all">
    <style>
        body {
            margin: 10px;
        }

        /* 修改头部工具右侧筛选、导出、打印样式 */
        .yutons-header-tool {
            margin-top: -2px;
            width: 30px !important;
            height: 30px !important;
            background-color: #ffffff;
        }

        /* div 右侧10px */
        .yutons-btn-margin-right {
            margin-right: 10px;
            line-height: 40px;
        }
    </style>
</head>
<body>
<table class="layui-hide" id="demo" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
    <div class="layui-row">
        <div style="text-align: right;">
            <div class="layui-input-inline yutons-btn-margin-right" style="margin-right: 0px;">
				<span class="layui-inline yutons-header-tool" title="筛选列" lay-event="LAYTABLE_COLS">
							<i class="layui-icon layui-icon-cols"></i></span>
                <span class="layui-inline yutons-header-tool" title="导出" lay-event="table_export">
				                    <i class="layui-icon layui-icon-export"></i></span>
                <span class="layui-inline yutons-header-tool" title="打印" lay-event="LAYTABLE_PRINT">
							<i class="layui-icon layui-icon-print"></i>
				</span>
            </div>
        </div>
    </div>
</script>
<script src="${pageContext.request.contextPath }/lib/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath }/lib/layui_exts/'
    }).use(['table', 'excel'], function () {
        var table = layui.table //表格
            ,$ = layui.$
            ,excel = layui.excel;


        //执行一个 table 实例
        table.render({
            elem: '#demo',
            // height: 420,
            url: '${pageContext.request.contextPath }/teachingExport.action', //数据接口
            where: {type: ${param.type}, role: '${param.role}'},
            title: '教学管理表',
            page: true, //开启分页
            toolbar: '#toolbarDemo', //操作1:启用自定义模板表格头部工具栏
            defaultToolbar: [],      //操作2:隐藏头部工具栏右侧的图标
            limit: 15,
            limits: [15,30,40,50,60,70,80,90,100],
            cols: [
                [ //表头
                {
                    type: 'checkbox',
                    fixed: 'left'
                }, {
                    field: 'userId',
                    title: '工号',
                    sort: true
                }, {
                    field: 'username',
                    title: '教师',
                    sort: true
                }, {
                    field: 'courseTime',
                    title: '授课时间',
                    sort: true
                }, {
                    field: 'courseName',
                    title: '课程名称',
                    sort: true
                }, {
                    field: 'courseAttr',
                    title: '性质',
                    sort: true
                }, {
                    field: 'courseTotalHours',
                    title: '总学时',
                    sort: true
                }, {
                    field: 'courseRealHours',
                    title: '实际授课学时',
                    sort: true
                }, {
                    field: 'classrooms',
                    title: '教学班级',
                    sort: true
                }, {
                    field: 'classNum',
                    title: '班级数',
                    sort: true
                }, {
                    field: 'stuNum',
                    title: '学生人数',
                    sort: true
                }
                <c:if test="${param.type == 1 || param.type == 3}">
                    , {
                    field: 'isEnglish',
                    title: '英文授课',
                    sort: true
                }
                </c:if>
                <c:if test="${param.type == 2 || param.type == 4}">
                    , {
                    field: 'groupNum',
                    title: '分组数目',
                    sort: true
                }
                </c:if>
                ]
            ]
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id),
                data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'table_export':
                    exportFile('demo');
                    break;
            }
        });

        /**
         * by yutons
         * Array.from() 非常方便的将一个类数组的集合 ==》 数组，直接使用数组身上的方法。例如：常用的map，foreach…
         * 但是，问题来了，IE不识别Array.from这个方法。所以写了它兼容IE的写法。
         */
        if (!Array.from) {
            Array.from = function (el) {
                return Array.apply(this, el);
            }
        }

        //表格导出
        function exportFile(id) {

            var selectArr = [];
            layui.use('table', function(){
                var checkStatus = table.checkStatus(id); //idTest 即为基础参数 id 对应的值
                console.log(checkStatus.data) //获取选中行的数据
            });

            //根据传入tableID获取表头
            var headers = $("div[lay-id=" + id + "] .layui-table-box table").get(0);
            var htrs = Array.from(headers.querySelectorAll('tr'));
            var titles = {};
            for (var j = 0; j < htrs.length; j++) {
                var hths = Array.from(htrs[j].querySelectorAll("th"));
                for (var i = 0; i < hths.length; i++) {
                    var clazz = hths[i].getAttributeNode('class').value;
                    if (clazz != ' layui-table-col-special' && clazz != 'layui-hide') {
                        //排除居左、具有、隐藏字段
                        //修改:默认字段data-field+i,兼容部分数据表格中不存在data-field值的问题
                        titles['data-field' + i] = hths[i].innerText;
                    }
                }
            }
            //根据传入tableID获取table内容
            var bodys = $("div[lay-id=" + id + "] .layui-table-box table").get(1);
            var btrs = Array.from(bodys.querySelectorAll("tr"));
            console.log(btrs);
            var bodysArr = new Array();
            for (var j = 0; j < btrs.length; j++) {
                var contents = {};
                var btds = Array.from(btrs[j].querySelectorAll("td"));
                console.log(btds);
                for (var i = 0; i < btds.length; i++) {
                    for (var key in titles) {
                        //修改:默认字段data-field+i,兼容部分数据表格中不存在data-field值的问题
                        var field = 'data-field' + i;
                        if (field === key) {
                            //根据表头字段获取table内容字段
                            contents[field] = btds[i].innerText;
                        }
                    }
                }
                bodysArr.push(contents)
            }
            //将标题行置顶添加到数组
            bodysArr.unshift(titles);
            //导出excel
            excel.exportExcel({
                sheet1: bodysArr
            }, '${param.name}表' + new Date().toLocaleString() + '.xlsx', 'xlsx');
        }
    });
</script>
</body>
</html>
