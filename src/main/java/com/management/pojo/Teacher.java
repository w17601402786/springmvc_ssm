package com.management.pojo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(title = "教师基本信息", description = "教师基本信息")
public class Teacher {

    @Schema(title = "ID", description = "ID")
    private int id;

    @Schema(title = "教师职工号", description = "教师职工号")
    private String teacherId;

    @Schema(title = "姓名", description = "姓名")
    private String name;

    @Schema(title = "性别", description = "性别")
    private String gender;

    @Schema(title = "出生日期", description = "出生日期")
    private Date birthday;

    @Schema(title = "职位", description = "职位")
    private String faculty;

    @Schema(title = "电话", description = "电话")
    private String phone;

    @Schema(title = "关联的用户ID", description = "关联的用户ID")
    private int userId;

    private Users userInfo = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Users getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Users userInfo) {
        this.userInfo = userInfo;
    }


    /**
     * 判断必要的参数是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        if(name == null || "".equals(name)){
            return true;
        }
        if (teacherId == null || "".equals(teacherId)){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", faculty='" + faculty + '\'' +
                ", phone='" + phone + '\'' +
                ", userId=" + userId +
                ", userInfo=" + userInfo +
                '}';
    }
}
