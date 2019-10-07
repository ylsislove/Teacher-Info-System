package com.ylsislove.service.research;

import com.ylsislove.dao.AwardDao;
import com.ylsislove.model.research.Award;
import com.ylsislove.model.dto.Page;

import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/9/30 0:00
 */
public class AwardService {

    private AwardDao aDao = new AwardDao();

    public Page getAwardPage(int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = aDao.selectAwardCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = aDao.getAwardPage(type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Page getAwardPageByUserId(String userId, int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = aDao.selectAwardCountByUserId(userId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = aDao.getAwardPageByUserId(userId, type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Award selectAwardById(int id) {
        Award award = null;
        try {
            award = aDao.selectAwardById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return award;
    }

    public void addAward(Award award) {
        try {
            aDao.addAward(award);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAward(Award award) {
        try {
            aDao.updateAward(award);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(int id) {
        try {
            aDao.delete(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 管理员搜索模式
     */
    public Page getSearchKeyword(String keyword, int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = aDao.getSearchCount(keyword, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = aDao.selectSearchKeyword(keyword, type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    /**
     * 普通用户搜索模式
     */
    public Page getSearchKeywordByUserId(String keyword, int type, String userId, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = aDao.getSearchCountByUserId(keyword, type, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = aDao.selectSearchKeywordByUserId(keyword, type, userId, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

}
