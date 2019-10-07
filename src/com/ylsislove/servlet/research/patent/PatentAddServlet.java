package com.ylsislove.servlet.research.patent;

import com.ylsislove.model.User;
import com.ylsislove.model.research.Patent;
import com.ylsislove.service.UserService;
import com.ylsislove.service.research.PatentService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 19:25
 */
@WebServlet(value = "/patentAdd.action")
public class PatentAddServlet extends HttpServlet {

    private PatentService pService = new PatentService();
    private UserService uService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 填充基本信息
        Patent patent = new Patent();
        try {
            BeanUtils.copyProperties(patent, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 获取到发明人信息
        int inventorSum = Integer.parseInt(request.getParameter("inventorSum"));
        int index = 1;
        StringBuilder inventorDetail = new StringBuilder();

        while (inventorSum > 0 && index < 100) {
            if (request.getParameter("inventorName" + index) == null) {
                index ++;
                continue;
            }
            inventorDetail.append(request.getParameter("inventorName" + index) + "&");
            inventorDetail.append("".equals(request.getParameter("inventorUnit" + index)) ? "blank&" : request.getParameter("inventorUnit" + index) + "&");
            inventorDetail.append(request.getParameter("isOurTeacher" + index) + "&");
            // 如果是我院教师的话，且管理员没有指定工号的话，查询其中文名，自动关联其教师工号
            if ("是".equals(request.getParameter("isOurTeacher" + index)) &&
                    "".equals(request.getParameter("userId" + index))) {
                User user = uService.searchUserIdByName(request.getParameter("inventorName" + index));
                if (user == null) {
                    inventorDetail.append("blank");
                } else {
                    inventorDetail.append(user.getUserId());
                }
            } else {
                inventorDetail.append("".equals(request.getParameter("userId" + index)) ? "blank" : request.getParameter("userId" + index));
            }
            inventorDetail.append(";");
            index ++;
        }
        patent.setInventors(inventorDetail.toString());

        // 将数据保存到数据库中
        pService.addPatent(patent);
//        System.out.println(patent);

    }
}
