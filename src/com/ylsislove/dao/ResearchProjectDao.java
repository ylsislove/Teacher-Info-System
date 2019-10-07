package com.ylsislove.dao;

import com.ylsislove.model.research.ResearchProject;
import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 13:51
 */
public class ResearchProjectDao {

    public void addProject(ResearchProject project) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into project(startDate, endDate, projectId, title, " +
                "source, level, contractFunds, actualFunds, workUnits, members, type) " +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        r.update(sql, project.getStartDate(), project.getEndDate(), project.getProjectId(),
                project.getTitle(), project.getSource(), project.getLevel(), project.getContractFunds(),
                project.getActualFunds(), project.getWorkUnits(), project.getMembers(), project.getType());
    }

    public void updateProject(ResearchProject project) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update project set startDate = ?, endDate = ?, projectId = ?, " +
                "title = ?, source = ?, level = ?, contractFunds = ?, actualFunds = ?, " +
                "workUnits = ?, members = ?, type = ? where id = ?";
        r.update(sql, project.getStartDate(), project.getEndDate(), project.getProjectId(),
                project.getTitle(), project.getSource(), project.getLevel(), project.getContractFunds(),
                project.getActualFunds(), project.getWorkUnits(), project.getMembers(), project.getType(),
                project.getId());
    }

    public List getProjectPage(int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from project where type = ? limit ?, ?";
        return r.query(sql, new BeanListHandler<ResearchProject>(ResearchProject.class), type, (pageNo-1)*pageSize, pageSize);
    }

    public ResearchProject selectProjectById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from project where id = ?";
        return r.query(sql, new BeanHandler<ResearchProject>(ResearchProject.class), id);
    }

    public int selectProjectCount(int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from project where type = ?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from project where id = ?";
        r.update(sql, id);
    }

    public List getProjectPageByUserId(String userId, int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from project where members like ? and type = ? limit ?, ?";
        return r.query(sql, new BeanListHandler<ResearchProject>(ResearchProject.class), "%"+userId+"%", type, (pageNo-1)*pageSize, pageSize);
    }

    public int selectProjectCountByUserId(String userId, int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from project where members like ? and type = ?";
        return r.query(sql, new ScalarHandler<Long>(), "%"+userId+"%", type).intValue();
    }

    /**
     * 管理员搜索模式
     */
    public int getSearchCount(String keyword, int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from project where type = ? and " +
                "(projectId like ? or title like ? or source like ? or " +
                "level like ? or workUnits like ? or members like ?)";
        return r.query(sql, new ScalarHandler<Long>(), type,
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%").intValue();
    }

    public List selectSearchKeyword(String keyword, int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from project where type = ? and " +
                "(projectId like ? or title like ? or source like ? or " +
                "level like ? or workUnits like ? or members like ?) " +
                "limit ?, ?";
        return r.query(sql, new BeanListHandler<ResearchProject>(ResearchProject.class), type,
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                (pageNo-1)*pageSize, pageSize);
    }

    /**
     * 普通用户搜索模式
     */
    public int getSearchCountByUserId(String keyword, int type, String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from project where type = ? and members like ? and " +
                "(projectId like ? or title like ? or source like ? or " +
                "level like ? or workUnits like ? or members like ?)";
        return r.query(sql, new ScalarHandler<Long>(), type, "%"+userId+"%",
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%").intValue();
    }

    public List selectSearchKeywordByUserId(String keyword, int type, String userId, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from project where type = ? and members like ? and " +
                "(projectId like ? or title like ? or source like ? or " +
                "level like ? or workUnits like ? or members like ?) " +
                "limit ?, ?";
        return r.query(sql, new BeanListHandler<ResearchProject>(ResearchProject.class), type, "%"+userId+"%",
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                (pageNo-1)*pageSize, pageSize);
    }

}
