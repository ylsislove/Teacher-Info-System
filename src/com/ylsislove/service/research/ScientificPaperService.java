package com.ylsislove.service.research;

import com.ylsislove.dao.ScientificPaperDao;
import com.ylsislove.model.Page;
import com.ylsislove.model.research.ScientificPaper;

import java.sql.SQLException;
import java.util.List;

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
            totalCount = sDao.selectScientificPaperCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = sDao.getScientificPaperPage(type, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public ScientificPaper selectScientificPaperById(int id) {
        ScientificPaper scientificPaper = null;
        try {
            scientificPaper = sDao.selectScientificPaperPageById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scientificPaper;
    }

}
