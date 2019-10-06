package com.ylsislove.model.experience;

/**
 * @Description 出国经历
 * @ClassName AbroadExperience
 * @Author Apple_Coco
 * @Date 2019/9/21 1:58
 * @Version V1.0
 */
public class AbroadExperience {

    private String abroadDate;
    private String backDate;
    private String departmentName;
    private String majorName;
    private String tutorName;

    public AbroadExperience() {
    }

    public AbroadExperience(String abroadDate, String backDate, String departmentName, String majorName, String tutorName) {
        this.abroadDate = abroadDate;
        this.backDate = backDate;
        this.departmentName = departmentName;
        this.majorName = majorName;
        this.tutorName = tutorName;
    }

    public String getAbroadDate() {
        return abroadDate;
    }

    public void setAbroadDate(String abroadDate) {
        this.abroadDate = abroadDate;
    }

    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    @Override
    public String toString() {
        return "AbroadExperience{" +
                "abroadDate='" + abroadDate + '\'' +
                ", backDate='" + backDate + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", tutorName='" + tutorName + '\'' +
                '}';
    }
}
