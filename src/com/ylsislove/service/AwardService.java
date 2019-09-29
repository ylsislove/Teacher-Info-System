package com.ylsislove.service;

import com.ylsislove.dao.AwardDao;
import com.ylsislove.model.Award;
import com.ylsislove.model.Page;

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

    public Award selectAwardById(int id) {
        Award award = null;
        try {
            award = aDao.selectAwardPageById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return award;
    }

}
