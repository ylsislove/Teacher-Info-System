package com.ylsislove.service.research;

import com.ylsislove.dao.PatentDao;
import com.ylsislove.model.dto.Page;
import com.ylsislove.model.research.Patent;

import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 14:00
 */
public class PatentService {

    private PatentDao pDao = new PatentDao();

    public Page getPatentPage(int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = pDao.selectPatentCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = pDao.getPatentPage(pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Page getPatentPageByUserId(String userId, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = pDao.selectPatentCountByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = pDao.getPatentPageByUserId(userId, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Patent selectPatentById(int id) {
        Patent patent = null;
        try {
            patent = pDao.selectPatentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patent;
    }

    public void addPatent(Patent patent) {
        try {
            pDao.addPatent(patent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePatent(Patent patent) {
        try {
            pDao.updatePatent(patent);
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

}
