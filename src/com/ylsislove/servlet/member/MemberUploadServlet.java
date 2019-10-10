package com.ylsislove.servlet.member;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.User;
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
 * 教师信息批量导入
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/8 3:30
 */
@WebServlet(value = "/memberUpload.action")
public class MemberUploadServlet extends HttpServlet {

    private UserService uService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
                User user = new User();
                try {
                    BeanUtils.copyProperties(user, o1);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                user.setPassword(user.getUserId());
                if (!uService.addUser(user)) {
                    msg.append(user.getUserId() + ", ");
                }
            }
        }
        if (!"".equals(msg.toString())) {
            response.getWriter().print("导入失败, " + msg.toString() + "工号重复");
        }
    }
}
