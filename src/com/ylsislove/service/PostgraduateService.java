package com.ylsislove.service;

import com.ylsislove.dao.PostgraduateDao;
import com.ylsislove.model.Page;
import com.ylsislove.model.Postgraduate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Description 与研究生管理相关的API接口
 * @ClassName PostgraduateService
 * @Author Apple_Coco
 * @Date 2019/9/8 12:41
 * @Version V1.0
 */
public class PostgraduateService {

    private PostgraduateDao pDao = new PostgraduateDao();

    public Page getPostgraduatePage(int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = pDao.selectPostgraduateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List<Map<String, Object>> list = null;
        try {
            list = pDao.getPostgraduatePage(pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setMapList(list);
        return p;
    }

    public Page getPostgraduatePageByUserId(String userId, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = pDao.selectPostgraduateCountByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List<Map<String, Object>> list = null;
        try {
            list = pDao.getPostgraduatePageByUserId(userId, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setMapList(list);
        return p;
    }

    public void addPostgraduate(Postgraduate p) {
        try {
            pDao.addPostgraduate(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> selectPostgraduateById(int id) {
        Map<String, Object> map = null;
        try {
            map = pDao.selectPostgraduateById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void updatePostgraduate(Postgraduate p) {
        try {
            pDao.updatePostgraduate(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(int id) {
        try {
            pDao.delete(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List getPostgraduateByUserId(String userId) {
        List list = null;
        try {
            list = pDao.getPostgraduateByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
