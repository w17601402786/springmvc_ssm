package com.management.pojo;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "用户基本信息", description = "用户基本信息")
public class Users {

    @Schema(title = "用户ID", description = "用户ID")
    private int id;

    @Schema(title = "用户名", description = "用户名")
    private String username;

    @Schema(title = "密码", description = "密码")
    private String password;

    @Schema(title = "用户类型", description = "用户类型", allowableValues = {"student", "teacher", "admin"})
    private String userType;

    private Student studentInfo = null;

    private Teacher teacherInfo = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public Student getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(Student studentInfo) {
        this.studentInfo = studentInfo;
    }

    public Teacher getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(Teacher teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", studentInfo=" + studentInfo +
                ", teacherInfo=" + teacherInfo +
                '}';
    }
}
