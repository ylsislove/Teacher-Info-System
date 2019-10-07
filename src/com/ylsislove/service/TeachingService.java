package com.ylsislove.service;

import com.ylsislove.dao.TeachingDao;
import com.ylsislove.model.dto.Page;
import com.ylsislove.model.Teaching;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Description 与教学管理相关的API接口
 * @ClassName TeachingService
 * @Author Apple_Coco
 * @Date 2019/9/7 14:53
 * @Version V1.0
 */
public class TeachingService {

    private TeachingDao tDao = new TeachingDao();

    public Page getTeachingPage(int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = tDao.selectTeachingCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List<Map<String, Object>> list = null;
        try {
            list = tDao.getTeachingPage(type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setMapList(list);
        return p;
    }

    public Page getTeachingPageByUserId(String userId, int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = tDao.selectTeachingCountByUserId(userId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List<Map<String, Object>> list = null;
        try {
            list = tDao.getTeachingPageByUserId(userId, type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setMapList(list);
        return p;
    }

    public Map<String, Object> selectTeachingById(int id) {
        Map<String, Object> map = null;
        try {
            map = tDao.selectTeachingById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void updateTeaching(Teaching p) {
        try {
            tDao.updateTeaching(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeaching(Teaching t) {
        try {
            tDao.addTeaching(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCourseCount(String courseId) {
        int count = 0;
        try {
            count = tDao.selectCourseCount(courseId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean delete(int teachingId) {
        try {
            tDao.delete(teachingId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List getTeachingByUserId(String userId) {
        List list = null;
        try {
            list = tDao.getTeachingByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
