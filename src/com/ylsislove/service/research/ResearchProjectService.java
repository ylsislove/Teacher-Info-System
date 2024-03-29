package com.ylsislove.service.research;

import com.ylsislove.dao.ResearchProjectDao;
import com.ylsislove.model.dto.Page;
import com.ylsislove.model.research.ResearchProject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 13:58
 */
public class ResearchProjectService {

    private ResearchProjectDao rDao = new ResearchProjectDao();

    public Page getProjectPage(int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = rDao.selectProjectCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = rDao.getProjectPage(type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Page getProjectPageByUserId(String userId, int type, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = rDao.selectProjectCountByUserId(userId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = rDao.getProjectPageByUserId(userId, type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public ResearchProject selectResearchProjectById(int id) {
        ResearchProject project = null;
        try {
            project = rDao.selectProjectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    public void addResearchProject(ResearchProject project) {
        try {
            rDao.addProject(project);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateResearchProject(ResearchProject project) {
        try {
            rDao.updateProject(project);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(int id) {
        try {
            rDao.delete(id);
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
            totalCount = rDao.getSearchCount(keyword, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = rDao.selectSearchKeyword(keyword, type, pageNo, pageSize);
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
            totalCount = rDao.getSearchCountByUserId(keyword, type, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = rDao.selectSearchKeywordByUserId(keyword, type, userId, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    /**
     * layui自带的分页模型初体验
     */
    public int selectProjectCount(int type) {
        int count = 0;
        try {
            count = rDao.selectProjectCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<ResearchProject> selectProjectList(int type, int page, int limit) {
        List<ResearchProject> list = new ArrayList<>();
        try {
            list = rDao.getProjectPage(type, page, limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int selectProjectCountByUserId(String userId, int type) {
        int count = 0;
        try {
            count = rDao.selectProjectCountByUserId(userId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<ResearchProject> selectProjectListByUserId(String userId, int type, int page, int limit) {
        List<ResearchProject> list = new ArrayList<>();
        try {
            list = rDao.getProjectPageByUserId(userId, type, page, limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * soul table 筛选分页模型初体验
     */
    public List<ResearchProject> selectProjectList(int type) {
        List<ResearchProject> list = new ArrayList<>();
        try {
            list = rDao.getProjectPage(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ResearchProject> selectProjectListByUserId(String userId, int type) {
        List<ResearchProject> list = new ArrayList<>();
        try {
            list = rDao.getProjectPageByUserId(userId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
