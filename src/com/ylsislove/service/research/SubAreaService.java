package com.ylsislove.service.research;

import com.ylsislove.dao.SubAreaDao;
import com.ylsislove.model.research.SubArea;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/15 18:14
 */
public class SubAreaService {

    private SubAreaDao sDao = new SubAreaDao();

    public void addSubArea(SubArea subArea) {
        try {
            if (sDao.isSubAreaExist(subArea.getName())) {
                sDao.updateSubArea(subArea);
            } else {
                sDao.addSubArea(subArea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SubArea selectSubArea(String name) {
        SubArea subArea = null;
        try {
            subArea = sDao.selectSubArea(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subArea;
    }

    public boolean deleteAll() {
        try {
            sDao.deleteAll();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
