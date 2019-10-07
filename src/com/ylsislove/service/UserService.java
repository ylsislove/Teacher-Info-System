package com.ylsislove.service;

import com.ylsislove.dao.UserDao;
import com.ylsislove.model.dto.Page;
import com.ylsislove.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description 与教师信息相关的API接口
 * @ClassName UserService
 * @Author Apple_Coco
 * @Date 2019/9/5 19:48
 * @Version V1.0
 */
public class UserService {

    private UserDao uDao = new UserDao();

    public User login(String userId, String password) {
        User user = null;
        try {
            user = uDao.selectByIdPassword(userId, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Page getUserPage(int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = uDao.selectUserCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = uDao.selectUserList(pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public User selectById(String userId) {
        User u = null;
        try {
            u = uDao.selectById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean addUser(User user) {
        try {
            if (uDao.isUserIdExist(user.getUserId())) {
                return false;
            }
            uDao.addUser(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateUser(User user) {
        try {
            uDao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(String userId) {
        try {
            uDao.delete(userId);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Page getSearchUserPage(String keyword, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 8;
        int totalCount = 0;
        try {
            totalCount = uDao.getSearchCount(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);

        List list = null;
        try {
            list = uDao.selectSearchUser(keyword, pageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    /**
     * 教育经历
     */
    public String selectEduExperienceByUserId(String userId) {
        String eduexperience = null;
        try {
            eduexperience = uDao.selectEduExperienceByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eduexperience;
    }

    public void updateEduExperience(String edu, String userId) {
        try {
            uDao.updateEduExperience(edu, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 留学经历
     */
    public String selectAbroadExperienceByUserId(String userId) {
        String abroadexperience = null;
        try {
            abroadexperience = uDao.selectAbroadExperienceByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abroadexperience;
    }

    public void updateAbroadExperience(String abroad, String userId) {
        try {
            uDao.updateAbroadExperience(abroad, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 工作经历
     */
    public String selectWorkExperienceByUserId(String userId) {
        String workexperience = null;
        try {
            workexperience = uDao.selectWorkExperienceByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workexperience;
    }

    public void updateWorkExperience(String work, String userId) {
        try {
            uDao.updateWorkExperience(work, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过英文名查询教师工号
     */
    public User searchUserIdByEnglishName(String engName) {
        User user = null;
        try {
            user = uDao.searchUserIdByEnglishName(engName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 通过中文名查询教师工号
     */
    public User searchUserIdByName(String name) {
        User user = null;
        try {
            user = uDao.searchUserIdByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
