package com.ylsislove.model;

/**
 * @Description 工作经历
 * @ClassName WorkExperience
 * @Author Apple_Coco
 * @Date 2019/9/21 2:01
 * @Version V1.0
 */
public class WorkExperience {

    private String workDate;
    private String leaveDate;
    private String departmentName;
    private String workName;

    public WorkExperience() {
    }

    public WorkExperience(String workDate, String leaveDate, String departmentName, String workName) {
        this.workDate = workDate;
        this.leaveDate = leaveDate;
        this.departmentName = departmentName;
        this.workName = workName;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workDate='" + workDate + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", workName='" + workName + '\'' +
                '}';
    }
}
