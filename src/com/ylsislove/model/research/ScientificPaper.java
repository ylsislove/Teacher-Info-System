package com.ylsislove.model.research;

/**
 * 论文模块
 *
 * @author Apple_Coco
 * @version V1.0 2019/9/28 21:44
 */
public class ScientificPaper {

    private int id;
    private String date;
    private String title;
    private String journalFullName;
    private String journalShortName;
    private int reelNum;
    private int issue;
    private int beginPageNum;
    private int endPageNum;
    private String doiNum;
    private String workUnits;
    private String authors;
    private String subarea;
    private int citeNum;
    private String achievement;
    private String updateTime;
    private int type;

    public ScientificPaper() {
    }

    public ScientificPaper(int id, String date, String title, String journalFullName, String journalShortName, int reelNum, int issue, int beginPageNum, int endPageNum, String doiNum, String workUnits, String authors, String subarea, int citeNum, String achievement, int type) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.journalFullName = journalFullName;
        this.journalShortName = journalShortName;
        this.reelNum = reelNum;
        this.issue = issue;
        this.beginPageNum = beginPageNum;
        this.endPageNum = endPageNum;
        this.doiNum = doiNum;
        this.workUnits = workUnits;
        this.authors = authors;
        this.subarea = subarea;
        this.citeNum = citeNum;
        this.achievement = achievement;
        this.type = type;
    }

    public ScientificPaper(String date, String title, String journalFullName, String journalShortName, int reelNum, int issue, int beginPageNum, int endPageNum, String doiNum, String workUnits, String authors, String subarea, int citeNum, String achievement, int type) {
        this.date = date;
        this.title = title;
        this.journalFullName = journalFullName;
        this.journalShortName = journalShortName;
        this.reelNum = reelNum;
        this.issue = issue;
        this.beginPageNum = beginPageNum;
        this.endPageNum = endPageNum;
        this.doiNum = doiNum;
        this.workUnits = workUnits;
        this.authors = authors;
        this.subarea = subarea;
        this.citeNum = citeNum;
        this.achievement = achievement;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournalFullName() {
        return journalFullName;
    }

    public void setJournalFullName(String journalFullName) {
        this.journalFullName = journalFullName;
    }

    public String getJournalShortName() {
        return journalShortName;
    }

    public void setJournalShortName(String journalShortName) {
        this.journalShortName = journalShortName;
    }

    public int getReelNum() {
        return reelNum;
    }

    public void setReelNum(int reelNum) {
        this.reelNum = reelNum;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getBeginPageNum() {
        return beginPageNum;
    }

    public void setBeginPageNum(int beginPageNum) {
        this.beginPageNum = beginPageNum;
    }

    public int getEndPageNum() {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum) {
        this.endPageNum = endPageNum;
    }

    public String getDoiNum() {
        return doiNum;
    }

    public void setDoiNum(String doiNum) {
        this.doiNum = doiNum;
    }

    public String getWorkUnits() {
        return workUnits;
    }

    public void setWorkUnits(String workUnits) {
        this.workUnits = workUnits;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getSubarea() {
        return subarea;
    }

    public void setSubarea(String subarea) {
        this.subarea = subarea;
    }

    public int getCiteNum() {
        return citeNum;
    }

    public void setCiteNum(int citeNum) {
        this.citeNum = citeNum;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ScientificPaper{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", journalFullName='" + journalFullName + '\'' +
                ", journalShortName='" + journalShortName + '\'' +
                ", reelNum=" + reelNum +
                ", issue=" + issue +
                ", beginPageNum=" + beginPageNum +
                ", endPageNum=" + endPageNum +
                ", doiNum='" + doiNum + '\'' +
                ", workUnits='" + workUnits + '\'' +
                ", authors='" + authors + '\'' +
                ", subarea='" + subarea + '\'' +
                ", citeNum=" + citeNum +
                ", achievement='" + achievement + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", type=" + type +
                '}';
    }
}
