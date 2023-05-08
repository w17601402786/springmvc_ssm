package com.management.pojo;

import java.util.Date;

public class Teacher {
    private int id;
    private String teacherId;
    private String name;
    private String gender;
    private Date birthday;
    private String faculty;
    private String phone;
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
