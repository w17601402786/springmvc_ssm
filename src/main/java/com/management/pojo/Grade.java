package com.management.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("成绩基本信息")
public class Grade implements Serializable {

    @ApiModelProperty("成绩ID")
    private Integer id;

    @ApiModelProperty("该成绩所属学生学号")
    private String studentId;

    @ApiModelProperty("该成绩所属课程ID")
    private String courseId;

    @ApiModelProperty("分数")
    private Integer score;

    @ApiModelProperty("该成绩所属学生信息")
    private Student studentInfo = null;

    @ApiModelProperty("该成绩所属课程信息")
    private Course courseInfo = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(Student studentInfo) {
        this.studentInfo = studentInfo;
    }

    public Course getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(Course courseInfo) {
        this.courseInfo = courseInfo;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", score=" + score +
                ", studentInfo=" + studentInfo +
                ", courseInfo=" + courseInfo +
                '}';
    }
}
