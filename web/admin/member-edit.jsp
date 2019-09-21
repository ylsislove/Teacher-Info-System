<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>编辑教师信息</title>
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

    <style type="text/css">
        .layui-form-label {
            width: 100px;
        }
    </style>
</head>

<body>
<div class="info-edit layui-anim layui-anim-up ">

    <form class="layui-form layui-form-pane">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>工号</label>
                <div class="layui-input-inline">
                    <input type="text" name="userId" autocomplete="off" class="layui-input"
                           value="${user.userId}" disabled>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>单位</label>
                <div class="layui-input-inline">
                    <input type="text" name="department" lay-verify="required" placeholder="请填写单位" autocomplete="off" class="layui-input"
                           value="${user.department}">
                </div>
            </div>
        </div>

        <div class="layui-form-item" >
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" lay-verify="required" placeholder="请填写姓名" autocomplete="off" class="layui-input"
                           value="${user.username}">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label" style="margin-right: 20px"><span class="x-red">*</span>性别</label>
                <div class="layui-input-inline" style="width: 170px;">
                    <input type="radio" name="sex" value="男" title="男" <c:if test="${user.sex == '男'}">checked=""</c:if>>
                    <input type="radio" name="sex" value="女" title="女" <c:if test="${user.sex == '女'}">checked=""</c:if>>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">英文名</label>
            <div class="layui-input-block" style="width: 512px;">
                <input type="text" name="enname" autocomplete="off" placeholder="请用英文分号分隔" class="layui-input"
                       value="${user.enname}">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>出生年月</label>
                <div class="layui-input-inline">
                    <input type="text" name="birth" id="birth" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="yyyy-MM-dd" value="${user.birth}">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label" style="width: 130px;"><span class="x-red">*</span>参加工作时间</label>
                <div class="layui-input-inline" style="width: 170px;">
                    <input type="text" name="worktime" id="worktime" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="yyyy-MM-dd" value="${user.worktime}">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>入党时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="parttime" id="parttime" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="yyyy-MM-dd" value="${user.parttime}">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>评职时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="titletime" id="titletime" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="yyyy-MM" value="${user.titletime}">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>职务</label>
                <div class="layui-input-inline">
                    <input type="text" id="position" name="position" lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="请填写职务" value="${user.position}">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>职称</label>
                <div class="layui-input-inline">
                    <select name="title" lay-verify="required" lay-search="">
                        <option value="">请选择职称</option>
                        <option value="助教" <c:if test="${user.title == '助教'}">selected</c:if>>助教</option>
                        <option value="讲师" <c:if test="${user.title == '讲师'}">selected</c:if>>讲师</option>
                        <option value="副教授" <c:if test="${user.title == '副教授'}">selected</c:if>>副教授</option>
                        <option value="教授" <c:if test="${user.title == '教授'}">selected</c:if>>教授</option>
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
                        <option value="教学型" <c:if test="${user.worktype == '教学型'}">selected</c:if>>教学型</option>
                        <option value="科研型" <c:if test="${user.worktype == '科研型'}">selected</c:if>>科研型</option>
                        <option value="教学科研型" <c:if test="${user.worktype == '教学科研型'}">selected</c:if>>教学科研型</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label"><span class="x-red">*</span>岗位等级</label>
                <div class="layui-input-inline">
                    <select name="worklevel" lay-verify="required" lay-search="">
                        <option value="">请选择等级</option>
                        <option value="1" <c:if test="${user.worklevel == '1'}">selected</c:if>>1级</option>
                        <option value="2" <c:if test="${user.worklevel == '2'}">selected</c:if>>2级</option>
                        <option value="3" <c:if test="${user.worklevel == '3'}">selected</c:if>>3级</option>
                        <option value="4" <c:if test="${user.worklevel == '4'}">selected</c:if>>4级</option>
                        <option value="5" <c:if test="${user.worklevel == '5'}">selected</c:if>>5级</option>
                        <option value="6" <c:if test="${user.worklevel == '6'}">selected</c:if>>6级</option>
                        <option value="7" <c:if test="${user.worklevel == '7'}">selected</c:if>>7级</option>
                        <option value="8" <c:if test="${user.worklevel == '8'}">selected</c:if>>8级</option>
                        <option value="9" <c:if test="${user.worklevel == '9'}">selected</c:if>>9级</option>
                        <option value="10" <c:if test="${user.worklevel == '10'}">selected</c:if>>10级</option>
                        <option value="11" <c:if test="${user.worklevel == '11'}">selected</c:if>>11级</option>
                        <option value="12" <c:if test="${user.worklevel == '12'}">selected</c:if>>12级</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 150px;">个人荣誉称号</label>
            <div class="layui-input-inline" style="width: 472px;">
                <input type="text" name="honorarytitle" autocomplete="off" placeholder="请用英文分号分隔" class="layui-input"
                       value="${user.honorarytitle}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 150px;">社会与学术兼职</label>
            <div class="layui-input-inline" style="width: 472px;">
                <input type="text" name="parttimejob" autocomplete="off" placeholder="请用英文分号分隔" class="layui-input"
                       value="${user.parttimejob}">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">常用邮箱</label>
                <div class="layui-input-inline">
                    <input type="text" name="email" placeholder="请填写邮箱" autocomplete="off" class="layui-input"
                           value="${user.email}">
                </div>
            </div>

            <div class="layui-inline">
                <label for="password" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="password" name="password" autocomplete="off" class="layui-input"
                           placeholder="请填写密码" value="${user.password}">
                </div>
            </div>
        </div>

        <c:if test="${param.role == 'admin'}">
            <div class="layui-form-item">
                <label class="layui-form-label">其他信息</label>
                <div class="layui-input-inline" style="width: 512px;">
                    <input type="text" autocomplete="off" class="layui-input" disabled
                           placeholder="教育经历，工作经历，出国经历请在教师详情界面修改" >
                </div>
            </div>
        </c:if>

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
                url: "${pageContext.request.contextPath }/memberEdit.action",
                data: "userData="+JSON.stringify(data.field),
                dataType: "json",
                success: function (data) {
                    console.log("修改成功");
                },
                error: function (data) {
                    // 不知道为什么，不管后端成功与否，这里返回的都是失败
                    if (data.responseText !== "") {
                        layer.alert("修改失败，" + data.responseText, {
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
                }
            });
            return false;
        });
    });
    
</script>

</body>
</html>
