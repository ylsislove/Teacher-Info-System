<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加教师信息</title>
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
<div class="info-edit layui-anim layui-anim-up ">

    <form class="layui-form layui-form-pane">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>工号</label>
                <div class="layui-input-inline">
                    <input type="text" name="userId" lay-verify="required" placeholder="请填写工号" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>单位</label>
                <div class="layui-input-inline">
                    <input type="text" name="department" lay-verify="required" placeholder="请填写单位" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item" >
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" lay-verify="required" placeholder="请填写姓名" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label" style="margin-right: 20px"><span class="x-red">*</span>性别</label>
                <div class="layui-input-inline" style="width: 170px;">
                    <input type="radio" name="sex" value="男" title="男" checked="">
                    <input type="radio" name="sex" value="女" title="女">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">英文名</label>
            <div class="layui-input-block" style="width: 512px;">
                <input type="text" name="enname" autocomplete="off" placeholder="请用英文分号分隔" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>出生年月</label>
                <div class="layui-input-inline">
                    <input type="text" name="birth" id="birth" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="yyyy-MM-dd">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label" style="width: 130px;"><span class="x-red">*</span>参加工作时间</label>
                <div class="layui-input-inline" style="width: 170px;">
                    <input type="text" name="worktime" id="worktime" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="yyyy-MM-dd">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>入党时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="parttime" id="parttime" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="yyyy-MM-dd">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>评职时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="titletime" id="titletime" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="yyyy-MM">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>职务</label>
                <div class="layui-input-inline">
                    <input type="text" id="position" name="position" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="请填写职务">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>职称</label>
                <div class="layui-input-inline">
                    <select name="title" lay-verify="required" lay-search="">
                        <option value="">请选择职称</option>
                        <option value="助教">助教</option>
                        <option value="讲师">讲师</option>
                        <option value="副教授">副教授</option>
                        <option value="教授">教授</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>岗位类别</label>
                <div class="layui-input-inline">
                    <select name="worktype" lay-verify="required" lay-search="">
                        <option value="">请选择类别</option>
                        <option value="教学型">教学型</option>
                        <option value="科研型">科研型</option>
                        <option value="教学科研型">教学科研型</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>岗位等级</label>
                <div class="layui-input-inline">
                    <select name="worklevel" lay-verify="required" lay-search="">
                        <option value="">请选择等级</option>
                        <option value="1">1级</option>
                        <option value="2">2级</option>
                        <option value="3">3级</option>
                        <option value="4">4级</option>
                        <option value="5">5级</option>
                        <option value="6">6级</option>
                        <option value="7">7级</option>
                        <option value="8">8级</option>
                        <option value="9">9级</option>
                        <option value="10">10级</option>
                        <option value="11">11级</option>
                        <option value="12">12级</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 150px;">个人荣誉称号</label>
            <div class="layui-input-inline" style="width: 472px;">
                <input type="text" name="honorarytitle" autocomplete="off" placeholder="请用英文分号分隔" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 150px;">社会与学术兼职</label>
            <div class="layui-input-inline" style="width: 472px;">
                <input type="text" name="parttimejob" autocomplete="off" placeholder="请用英文分号分隔" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">常用邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" placeholder="请填写邮箱" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" style="margin-left: 20px">默认密码与工号一致</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">其他信息</label>
            <div class="layui-input-inline" style="width: 512px;">
                <input type="text" autocomplete="off" class="layui-input" disabled
                       placeholder="教育经历，工作经历，出国经历请在教师详情界面填写" >
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">管理员？</label>
                <div class="layui-input-inline">
                    <select name="isadmin" lay-verify="required">
                        <option value="">请选择类别</option>
                        <option value="0" selected>否</option>
                        <option value="1">是</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block" style="margin-left: 250px">
                <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>
</div>

<script>
    layui.use(['form', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#birth',
            trigger: 'click' //自定义弹出框，采用click弹出
        });
        laydate.render({
            elem: '#worktime',
            trigger: 'click' //自定义弹出框，采用click弹出
        });
        laydate.render({
            elem: '#parttime',
            trigger: 'click' //自定义弹出框，采用click弹出
        });
        laydate.render({
            elem: '#titletime',
            type: 'month',
            trigger: 'click' //自定义弹出框，采用click弹出
        });

        //监听提交
        form.on('submit(add)', function (data) {
            // 发异步，把数据提交给servlet
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath }/memberAdd.action",
                data: "userData="+JSON.stringify(data.field),
                dataType: "json",
                success: function (data) {
                    console.log("添加成功");
                },
                error: function (data) {
                    // 不知道为什么，不管后端成功与否，这里返回的都是失败
                    if (data.responseText !== "") {
                        layer.alert("添加失败，" + data.responseText, {
                            icon: 2
                        });
                    }
                    else{
                        layer.alert("添加成功", {
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
            return false;
        });
    });
    
</script>

</body>
</html>
