package com.ylsislove.servlet.undergraduate;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.Undergraduate;
import com.ylsislove.model.User;
import com.ylsislove.service.UndergraduateService;
import com.ylsislove.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 本科生管理条目批量导入
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/9 16:30
 */
@WebServlet(value = "/undergraduateUpload.action")
public class UndergraduateUploadServlet extends HttpServlet {

    private UserService uService = new UserService();
    private UndergraduateService unService = new UndergraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获取教学管理类型
        int type = Integer.parseInt(request.getParameter("type"));

        // 获取前端数据
        String json = request.getParameter("data");
        StringBuilder msg = new StringBuilder();

        // 解析并导入
        Map map = (Map) JSON.parseObject(json, Map.class).get("0");
        for (Object o : map.keySet()) {
            List list = (List)(map.get(o));
            int i = 0;
            for (Object o1 : list) {
                // 跳过第一轮的Excel表头
                if (++i == 1) {
                    continue;
                }
                Undergraduate undergraduate = new Undergraduate();
                try {
                    BeanUtils.copyProperties(undergraduate, o1);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

                // 查询教师信息是否存在
                User user = uService.selectById(undergraduate.getUserId());
                if (user == null) {
                    msg.append(undergraduate.getUserId() + ", ");
                    continue;
                }

                // 计算学生人数
                String stuName = undergraduate.getStuName();
                stuName = stuName.replaceAll(";|；|，", ",");
                int stuNum = stuName.split(",").length;
                stuName = stuName.replaceAll(",", ", ");
                undergraduate.setStuName(stuName);
                undergraduate.setStuNum(stuNum);

                // 填充类型
                undergraduate.setType(type);

                // 保存教学管理条目到数据库
                unService.addUndergraduate(undergraduate);
                System.out.println("添加本科生管理条目：" + undergraduate);
            }
        }
        if (!"".equals(msg.toString())) {
            response.getWriter().print("导入失败, 工号" + msg.toString() + "教师信息不存在");
        }

    }
}
