package com.ylsislove.model.dto;

/**
 * 项目成员
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 0:53
 */
public class Member {

    private String memberName;
    private String isOurTeacher;
    private String userId;

    public Member() {
    }

    public Member(String memberName, String isOurTeacher, String userId) {
        this.memberName = memberName;
        this.isOurTeacher = isOurTeacher;
        this.userId = userId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getIsOurTeacher() {
        return isOurTeacher;
    }

    public void setIsOurTeacher(String isOurTeacher) {
        this.isOurTeacher = isOurTeacher;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberName='" + memberName + '\'' +
                ", isOurTeacher='" + isOurTeacher + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
