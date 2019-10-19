package com.ylsislove.service.research;

import com.ylsislove.dao.ScientificPaperDao;
import com.ylsislove.model.dto.Page;
import com.ylsislove.model.research.ScientificPaper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/9/28 21:53
 */
public class ScientificPaperService {

    private ScientificPaperDao sDao = new ScientificPaperDao();

    public Page getScientificPaperPage(int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = sDao.selectPaperCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = sDao.getPaperPage(type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Page getScientificPaperPageByUserId(String userId, int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = sDao.selectPaperCountByUserId(userId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = sDao.getPaperPageByUserId(userId, type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public ScientificPaper selectScientificPaperById(int id) {
        ScientificPaper scientificPaper = null;
        try {
            scientificPaper = sDao.selectPaperById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scientificPaper;
    }

    public void addScientificPaper(ScientificPaper paper) {
        try {
            sDao.addPaper(paper);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateScientificPaper(ScientificPaper paper) {
        try {
            sDao.updatePaper(paper);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(int id) {
        try {
            sDao.delete(id);
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
            totalCount = sDao.getSearchCount(keyword, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = sDao.selectSearchKeyword(keyword, type, pageNo, pageSize);
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
            totalCount = sDao.getSearchCountByUserId(keyword, type, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = sDao.selectSearchKeywordByUserId(keyword, type, userId, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    /**
     * layui自带的分页模型初体验
     */
    public int selectPaperCount(int type) {
        int count = 0;
        try {
            count = sDao.selectPaperCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<ScientificPaper> selectPaperList(int type, int page, int limit) {
        List<ScientificPaper> list = new ArrayList<>();
        try {
            list = sDao.getPaperPage(type, page, limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
