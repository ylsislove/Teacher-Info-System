package com.ylsislove.servlet.research.paper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ylsislove.model.User;
import com.ylsislove.model.research.ScientificPaper;
import com.ylsislove.model.research.SubArea;
import com.ylsislove.service.research.SubAreaService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/8 2:37
 */
@WebServlet(value = "/scientificPaperUpload.action")
public class ScientificPaperUploadServlet extends HttpServlet {

    private SubAreaService sService = new SubAreaService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获取导入类型
        int mode = Integer.parseInt(request.getParameter("mode"));
        // 获取论文类型
        int type = Integer.parseInt(request.getParameter("type"));
        // 取得数据
        String json = request.getParameter("data");

        if (mode == 1) {
            // 获取邮箱
            String email = request.getParameter("email");

            // 把邮箱地址写进json
            Map map = (Map)JSON.parseObject(json, Map.class).get("0");
            map.put("email", email);

            // 文件完整路径
            String fullPath = "C:/Users/Apple_Coco/Desktop/doi.json";

            // 生成json格式文件
            try {
                // 保证创建一个新文件
                File file = new File(fullPath);
                // 如果父目录不存在，创建父目录
                if (!file.getParentFile().exists()) {
                    boolean mkdirs = file.getParentFile().mkdirs();
                }
                // 如果已存在,删除旧文件
                if (file.exists()) {
                    boolean res = file.delete();
                }
                boolean newFile = file.createNewFile();

                // 将格式化后的字符串写入文件
                Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
                write.write(map.toString());
                write.flush();
                write.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (mode == 2) {
            Map map = (Map)JSON.parseObject(json, Map.class).get("0");
            for (Object o : map.keySet()) {
                List list = (List)(map.get(o));
                int i = 0;
                for (Object o1 : list) {
                    // 跳过第一轮的Excel表头
                    if (++i == 1) {
                        continue;
                    }
                    ScientificPaper paper = new ScientificPaper();
                    try {
                        BeanUtils.copyProperties(paper, o1);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    paper.setType(type);
                    // TODO 根据地大分区表查找分区


                    System.out.println(paper);
                }
            }

        } else {
            List list = (List) ((Map)JSON.parseObject(json, Map.class).get("0")).get("Sheet1");
            int i = 0;
            for (Object o1 : list) {
                // 跳过第一轮的Excel表头
                if (++i == 1) {
                    continue;
                }
                SubArea subArea = new SubArea();
                try {
                    BeanUtils.copyProperties(subArea, o1);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                subArea.setName(subArea.getName().replace("000", "&"));
                sService.addSubArea(subArea);
            }
        }
    }
}
