package com.ylsislove.service.research;

import com.ylsislove.dao.PatentDao;
import com.ylsislove.model.Page;
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

    public Patent selectPatentById(int id) {
        Patent patent = null;
        try {
            patent = pDao.selectPatentPageById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patent;
    }

}
