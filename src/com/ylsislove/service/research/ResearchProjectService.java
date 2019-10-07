package com.ylsislove.service.research;

import com.ylsislove.dao.ResearchProjectDao;
import com.ylsislove.model.dto.Page;
import com.ylsislove.model.research.ResearchProject;

import java.sql.SQLException;
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

}
