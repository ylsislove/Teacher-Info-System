package com.ylsislove.model;

/**
 * @Description 教师基本信息，包括工号，姓名，性别，职称，学历，最后毕业院校，电话号码
 * 常用邮箱，常用职务，出生年月，密码，是否为管理员
 * @ClassName User
 * @Author Apple_Coco
 * @Date 2019/9/5 16:33
 * @Version V1.0
 */
public class User {
    private String userId;
    private String department;
    private String username;
    private String enname;
    private String sex;
    private String birth;
    private String worktime;
    private String parttime;
    private String position;
    private String title;
    private String titletime;
    private String worktype;
    private String worklevel;
    private String honorarytitle;
    private String parttimejob;
    private String email;
    private String password;
    private boolean isadmin = false;

    public User() {
    }

    public User(String userId, String department, String username, String enname, String sex, String birth, String worktime, String parttime, String position, String title, String titletime, String worktype, String worklevel, String honorarytitle, String parttimejob, String email, String password, boolean isadmin) {
        this.userId = userId;
        this.department = department;
        this.username = username;
        this.enname = enname;
        this.sex = sex;
        this.birth = birth;
        this.worktime = worktime;
        this.parttime = parttime;
        this.position = position;
        this.title = title;
        this.titletime = titletime;
        this.worktype = worktype;
        this.worklevel = worklevel;
        this.honorarytitle = honorarytitle;
        this.parttimejob = parttimejob;
        this.email = email;
        this.password = password;
        this.isadmin = isadmin;
    }

    public User(String userId, String department, String username, String enname, String sex, String birth, String worktime, String parttime, String position, String title, String titletime, String worktype, String worklevel, String honorarytitle, String parttimejob, String email) {
        this.userId = userId;
        this.department = department;
        this.username = username;
        this.enname = enname;
        this.sex = sex;
        this.birth = birth;
        this.worktime = worktime;
        this.parttime = parttime;
        this.position = position;
        this.title = title;
        this.titletime = titletime;
        this.worktype = worktype;
        this.worklevel = worklevel;
        this.honorarytitle = honorarytitle;
        this.parttimejob = parttimejob;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getParttime() {
        return parttime;
    }

    public void setParttime(String parttime) {
        this.parttime = parttime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitletime() {
        return titletime;
    }

    public void setTitletime(String titletime) {
        this.titletime = titletime;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getWorklevel() {
        return worklevel;
    }

    public void setWorklevel(String worklevel) {
        this.worklevel = worklevel;
    }

    public String getHonorarytitle() {
        return honorarytitle;
    }

    public void setHonorarytitle(String honorarytitle) {
        this.honorarytitle = honorarytitle;
    }

    public String getParttimejob() {
        return parttimejob;
    }

    public void setParttimejob(String parttimejob) {
        this.parttimejob = parttimejob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", department='" + department + '\'' +
                ", username='" + username + '\'' +
                ", enname='" + enname + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", worktime='" + worktime + '\'' +
                ", parttime='" + parttime + '\'' +
                ", position='" + position + '\'' +
                ", title='" + title + '\'' +
                ", titletime='" + titletime + '\'' +
                ", worktype='" + worktype + '\'' +
                ", worklevel='" + worklevel + '\'' +
                ", honorarytitle='" + honorarytitle + '\'' +
                ", parttimejob='" + parttimejob + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isadmin=" + isadmin +
                '}';
    }
}
