package com.management.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("学生基本信息")
public class Student {

    @ApiModelProperty("学生ID")
    private int id;

    @ApiModelProperty("学号")
    private String studentId;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("出生日期")
    private Date birthday;

    @ApiModelProperty("专业")
    private String major;

    @ApiModelProperty("所在班级号")
    private String classId;

    @ApiModelProperty("家庭住址")
    private String address;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("关联的用户ID")
    private int userId;

    @ApiModelProperty("所在的班级信息")
    private Classes classes = null;

    @ApiModelProperty("关联的用户信息")
    private Users userInfo = null;


    /**
     * TODO 这个学生自己所拥有的所有学生的信息
     */
    private List<Grade> grades;

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

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }


    public boolean isEmpty(){
        if(name == null || "".equals(name)){
            return false;
        }
        if(studentId == null || "".equals(studentId)){
            return false;
        }
        if(classId == null || "".equals(classId)){
            return false;
        }
        if(userId == 0) {
            return false;
        }
        return true;
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
                ", classes=" + classes +
                ", userInfo=" + userInfo +
                ", grades=" + grades +
                '}';
    }
}

