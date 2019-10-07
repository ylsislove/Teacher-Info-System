package com.ylsislove.dao;

import com.ylsislove.model.research.ScientificPaper;
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
 * @version V1.0 2019/9/28 21:53
 */
public class ScientificPaperDao {

    public void addPaper(ScientificPaper paper) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into paper(date, title, journalFullName, journalShortName, " +
                "reelNum, issue, beginPageNum, endPageNum, doiNum, workUnits, authors, " +
                "subarea, citeNum, achievement, type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        r.update(sql, paper.getDate(), paper.getTitle(), paper.getJournalFullName(),
                paper.getJournalShortName(), paper.getReelNum(), paper.getIssue(),
                paper.getBeginPageNum(), paper.getEndPageNum(), paper.getDoiNum(), paper.getWorkUnits(),
                paper.getAuthors(), paper.getSubarea(), paper.getCiteNum(), paper.getAchievement(),
                paper.getType());
    }

    public void updatePaper(ScientificPaper paper) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update paper set date = ?, title = ?, journalFullName = ?, journalShortName = ?, " +
                "reelNum = ?, issue = ?, beginPageNum = ?, endPageNum = ?, doiNum = ?, workUnits = ?, " +
                "authors = ?, subarea = ?, citeNum = ?, achievement = ?, type = ? " +
                "where id = ?";
        r.update(sql, paper.getDate(), paper.getTitle(), paper.getJournalFullName(),
                paper.getJournalShortName(), paper.getReelNum(), paper.getIssue(),
                paper.getBeginPageNum(), paper.getEndPageNum(), paper.getDoiNum(), paper.getWorkUnits(),
                paper.getAuthors(), paper.getSubarea(), paper.getCiteNum(), paper.getAchievement(),
                paper.getType(), paper.getId());
    }

    public List getPaperPage(int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from paper where type = ? limit ?, ?";
        return r.query(sql, new BeanListHandler<ScientificPaper>(ScientificPaper.class), type, (pageNo-1)*pageSize, pageSize);
    }

    public ScientificPaper selectPaperById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from paper where id = ?";
        return r.query(sql, new BeanHandler<ScientificPaper>(ScientificPaper.class), id);
    }

    public int selectPaperCount(int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from paper where type = ?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from paper where id = ?";
        r.update(sql, id);
    }

    public List getPaperPageByUserId(String userId, int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from paper where authors like ? and type = ? limit ?, ?";
        return r.query(sql, new BeanListHandler<ScientificPaper>(ScientificPaper.class), "%"+userId+"%", type, (pageNo-1)*pageSize, pageSize);
    }

    public int selectPaperCountByUserId(String userId, int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from paper where authors like ? and type = ?";
        return r.query(sql, new ScalarHandler<Long>(), "%"+userId+"%", type).intValue();
    }

}
