package com.ylsislove.model.research;

/**
 * 项目
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/4 1:35
 */
public class ResearchProject {

    private int id;
    private String startDate;
    private String endDate;
    private String projectId;
    private String title;
    private String source;
    private String level;
    private float contractFunds;
    private float actualFunds;
    private String workUnits;
    private String members;
    private int type;

    public ResearchProject() {
    }

    public ResearchProject(int id, String startDate, String endDate, String projectId, String title, String source, String level, float contractFunds, float actualFunds, String workUnits, String members, int type) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectId = projectId;
        this.title = title;
        this.source = source;
        this.level = level;
        this.contractFunds = contractFunds;
        this.actualFunds = actualFunds;
        this.workUnits = workUnits;
        this.members = members;
        this.type = type;
    }

    public ResearchProject(String startDate, String endDate, String projectId, String title, String source, String level, float contractFunds, float actualFunds, String workUnits, String members, int type) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectId = projectId;
        this.title = title;
        this.source = source;
        this.level = level;
        this.contractFunds = contractFunds;
        this.actualFunds = actualFunds;
        this.workUnits = workUnits;
        this.members = members;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public float getContractFunds() {
        return contractFunds;
    }

    public void setContractFunds(float contractFunds) {
        this.contractFunds = contractFunds;
    }

    public float getActualFunds() {
        return actualFunds;
    }

    public void setActualFunds(float actualFunds) {
        this.actualFunds = actualFunds;
    }

    public String getWorkUnits() {
        return workUnits;
    }

    public void setWorkUnits(String workUnits) {
        this.workUnits = workUnits;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", projectId='" + projectId + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", level='" + level + '\'' +
                ", contractFunds=" + contractFunds +
                ", actualFunds=" + actualFunds +
                ", workUnits='" + workUnits + '\'' +
                ", members='" + members + '\'' +
                ", type=" + type +
                '}';
    }
}
