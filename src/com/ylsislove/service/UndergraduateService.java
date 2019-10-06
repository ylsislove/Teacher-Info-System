package com.ylsislove.service;

import com.ylsislove.dao.UndergraduateDao;
import com.ylsislove.model.dto.Page;
import com.ylsislove.model.Undergraduate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Description 与本科生管理相关的API接口
 * @ClassName UndergraduateService
 * @Author Apple_Coco
 * @Date 2019/9/8 4:06
 * @Version V1.0
 */
public class UndergraduateService {

    private UndergraduateDao unDao = new UndergraduateDao();

    public Page getUndergraduatePage(int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = unDao.selectUndergraduateCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List<Map<String, Object>> list = null;
        try {
            list = unDao.getUndergraduatePage(type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setMapList(list);
        return p;
    }

    public Page getUndergraduatePageByUserId(String userId, int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = unDao.selectUndergraduateCountByUserId(userId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List<Map<String, Object>> list = null;
        try {
            list = unDao.getUndergraduatePageByUserId(userId, type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setMapList(list);
        return p;
    }

    public Map<String, Object> selectUndergraduateById(int id) {
        Map<String, Object> map = null;
        try {
            map = unDao.selectUndergraduateById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void updateUndergraduate(Undergraduate p) {
        try {
            unDao.updateUndergraduate(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUndergraduate(Undergraduate u) {
        try {
            unDao.addUndergraduate(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(int id) {
        try {
            unDao.delete(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List getUndergraduateByUserId(String userId) {
        List list = null;
        try {
            list = unDao.getUndergraduateByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
