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

    public void addScientificPaper(ScientificPaper paper) throws SQLException {
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

    public List getScientificPaperPage(int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from paper where type = ? limit ?, ?";
        return r.query(sql, new BeanListHandler<ScientificPaper>(ScientificPaper.class), type, (pageNo-1)*pageSize, pageSize);
    }

    public ScientificPaper selectScientificPaperPageById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from paper where id = ?";
        return r.query(sql, new BeanHandler<ScientificPaper>(ScientificPaper.class), id);
    }

    public int selectScientificPaperCount(int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from paper where type = ?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

}
