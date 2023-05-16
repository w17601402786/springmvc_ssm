package com.management.pojo;

import java.util.Date;

public class Student {
    private int id;
    private String studentId;
    private String name;
    private String gender;
    private Date birthday;
    private String major;

    private String classId;
    private String address;
    private String phone;
    private String note;
    private int userId;

    private Classes classInfo = null;

    private Users userInfo = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Classes getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(Classes classInfo) {
        this.classInfo = classInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        return "Student{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", major='" + major + '\'' +
                ", classId='" + classId + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                ", userId=" + userId +
                ", classInfo=" + classInfo +
                ", userInfo=" + userInfo +
                '}';
    }
}

