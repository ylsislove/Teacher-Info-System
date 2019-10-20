package com.ylsislove.dao;

import com.ylsislove.model.User;
import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description 和教师信息相关的数据库操作
 * @ClassName UserDao
 * @Author Apple_Coco
 * @Date 2019/9/5 19:47
 * @Version V1.0
 */
public class UserDao {

	public void addUser(User user) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql = "insert into user(userId, department, username, enname, sex, " +
                "birth, worktime, part, parttime, position, title, titletime, worktype, " +
                "worklevel, honorarytitle, parttimejob, email, password, tel, isadmin) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		r.update(sql, user.getUserId(), user.getDepartment(), user.getUsername(), user.getEnname(),
                user.getSex(), user.getBirth(), user.getWorktime(), user.getPart(), user.getParttime(), user.getPosition(),
                user.getTitle(), user.getTitletime(), user.getWorktype(), user.getWorklevel(),
                user.getHonorarytitle(), user.getParttimejob(), user.getEmail(),
                user.getPassword(), user.getTel(), user.getIsadmin());
	}

    public boolean isUserIdExist(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from user where userId = ?";
        User u = r.query(sql, new BeanHandler<User>(User.class), userId);
        return u != null;
    }

    public User selectByIdPassword(String userId, String password) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from user where userId = ? and password = ?";
        return r.query(sql, new BeanHandler<User>(User.class), userId, password);
    }

    public User selectById(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from user where userId = ?";
        return r.query(sql, new BeanHandler<User>(User.class), userId);
    }

    public int selectUserCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from user";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }

    public List<User> selectUserList(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from user limit ?, ?";
        return r.query(sql, new BeanListHandler<User>(User.class), (pageNo-1)*pageSize, pageSize);
    }

    public void updateUser(User user) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update user set department = ?, username = ?, enname = ?, sex = ?, " +
                "birth = ?, worktime = ?, part = ?, parttime = ?, position = ?, title = ?, titletime = ?, " +
                "worktype = ?, worklevel = ?, honorarytitle = ?, parttimejob = ?, email = ?, " +
                "password = ?, tel = ?, isadmin = ? where userId = ?";
        r.update(sql, user.getDepartment(), user.getUsername(), user.getEnname(),
                user.getSex(), user.getBirth(), user.getWorktime(), user.getPart(), user.getParttime(), user.getPosition(),
                user.getTitle(), user.getTitletime(), user.getWorktype(), user.getWorklevel(),
                user.getHonorarytitle(), user.getParttimejob(), user.getEmail(),
                user.getPassword(), user.getTel(), user.getIsadmin(), user.getUserId());
    }

    public void delete(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from user where userId = ?";
        r.update(sql, userId);
    }

    public int getSearchCount(String keyword) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from user where userId like ? or username like ?";
        return r.query(sql, new ScalarHandler<Long>(), "%"+keyword+"%", "%"+keyword+"%").intValue();
    }

    public List selectSearchUser(String keyword, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from user where userId like ? or username like ? limit ? , ?";
        return r.query(sql, new BeanListHandler<User>(User.class), "%"+keyword+"%", "%"+keyword+"%", (pageNo-1)*pageSize, pageSize);
    }

    public String selectEduExperienceByUserId(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select eduexperience from user where userId = ?";
        return r.query(sql, new ScalarHandler<String>(), userId);
    }

    public void updateEduExperience(String edu, String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update user set eduexperience = ? where userId = ?";
        r.update(sql, edu, userId);
    }

    public String selectAbroadExperienceByUserId(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select abroadexperience from user where userId = ?";
        return r.query(sql, new ScalarHandler<String>(), userId);
    }

    public void updateAbroadExperience(String abroad, String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update user set abroadexperience = ? where userId = ?";
        r.update(sql, abroad, userId);
    }

    public String selectWorkExperienceByUserId(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select workexperience from user where userId = ?";
        return r.query(sql, new ScalarHandler<String>(), userId);
    }

    public void updateWorkExperience(String work, String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update user set workexperience = ? where userId = ?";
        r.update(sql, work, userId);
    }

    public User searchUserIdByEnglishName(String engName) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from user where enname like ?";
        return r.query(sql, new BeanHandler<User>(User.class), "%"+engName+"%");
    }

    public User searchUserIdByName(String name) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from user where username like ?";
        return r.query(sql, new BeanHandler<User>(User.class), "%"+name+"%");
    }
}
