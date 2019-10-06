package com.ylsislove.model.research;

/**
 * 专利
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 13:46
 */
public class Patent {

    private int id;
    private String applicationDate;
    private String authorizationDate;
    private String patentId;
    private String patentType;
    private String level;
    private String title;
    private String inventors;

    public Patent() {
    }

    public Patent(int id, String applicationDate, String authorizationDate, String patentId, String patentType, String level, String title, String inventors) {
        this.id = id;
        this.applicationDate = applicationDate;
        this.authorizationDate = authorizationDate;
        this.patentId = patentId;
        this.patentType = patentType;
        this.level = level;
        this.title = title;
        this.inventors = inventors;
    }

    public Patent(String applicationDate, String authorizationDate, String patentId, String patentType, String level, String title, String inventors) {
        this.applicationDate = applicationDate;
        this.authorizationDate = authorizationDate;
        this.patentId = patentId;
        this.patentType = patentType;
        this.level = level;
        this.title = title;
        this.inventors = inventors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(String authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public String getPatentId() {
        return patentId;
    }

    public void setPatentId(String patentId) {
        this.patentId = patentId;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInventors() {
        return inventors;
    }

    public void setInventors(String inventors) {
        this.inventors = inventors;
    }

    @Override
    public String toString() {
        return "Patent{" +
                "id=" + id +
                ", applicationDate='" + applicationDate + '\'' +
                ", authorizationDate='" + authorizationDate + '\'' +
                ", patentId='" + patentId + '\'' +
                ", patentType='" + patentType + '\'' +
                ", level='" + level + '\'' +
                ", title='" + title + '\'' +
                ", inventors='" + inventors + '\'' +
                '}';
    }
}
