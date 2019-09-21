package com.ylsislove.model;

/**
 * @Description 教育经历
 * @ClassName EduExperience
 * @Author Apple_Coco
 * @Date 2019/9/20 23:31
 * @Version V1.0
 */
public class EduExperience {

    private String academicDate;
    private String graduationDate;
    private String schoolName;
    private String majorName;
    private String tutorName;

    public EduExperience() {
    }

    public EduExperience(String academicDate, String graduationDate, String schoolName, String majorName, String tutorName) {
        this.academicDate = academicDate;
        this.graduationDate = graduationDate;
        this.schoolName = schoolName;
        this.majorName = majorName;
        this.tutorName = tutorName;
    }

    public String getAcademicDate() {
        return academicDate;
    }

    public void setAcademicDate(String academicDate) {
        this.academicDate = academicDate;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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
        return "EduExperience{" +
                "academicDate='" + academicDate + '\'' +
                ", graduationDate='" + graduationDate + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", tutorName='" + tutorName + '\'' +
                '}';
    }
}
