package com.ylsislove.model.dto;

/**
 * 作者
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 0:49
 */
public class Author {

    private String authorName;
    private String mask;
    private String isOurTeacher;
    private String userId;

    public Author() {
    }

    public Author(String authorName, String mask, String isOurTeacher, String userId) {
        this.authorName = authorName;
        this.mask = mask;
        this.isOurTeacher = isOurTeacher;
        this.userId = userId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
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
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", mask='" + mask + '\'' +
                ", isOurTeacher='" + isOurTeacher + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
