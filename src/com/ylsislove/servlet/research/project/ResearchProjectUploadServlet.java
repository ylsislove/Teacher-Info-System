package com.ylsislove.servlet.research.project;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.research.ResearchProject;
import com.ylsislove.service.research.ResearchProjectService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * 项目批量导入
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/9 16:22
 */
@WebServlet(value = "/researchProjectUpload.action")
public class ResearchProjectUploadServlet extends HttpServlet {

    private ResearchProjectService rService = new ResearchProjectService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获取项目类型
        int type = Integer.parseInt(request.getParameter("type"));
        // 取得数据
        String json = request.getParameter("data");

        Map map = (Map)JSON.parseObject(json, Map.class).get("0");
        for (Object o : map.keySet()) {
            List list = (List)(map.get(o));
            int i = 0;
            for (Object o1 : list) {
                // 跳过第一轮的Excel表头
                if (++i == 1) {
                    continue;
                }
                ResearchProject project = new ResearchProject();
                try {
                    BeanUtils.copyProperties(project, o1);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                project.setType(type);
                System.out.println("批量上传项目条目：" + project);
                rService.addResearchProject(project);
            }
        }

    }
}
