package com.management.pojo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(title = "成绩信息")
public class Grade implements Serializable {

    @Schema(title = "成绩ID", description = "成绩的唯一标识符", example = "1")
    private Integer id;

    @Schema(title = "该成绩所属学生学号", description = "该成绩所属的学生的唯一标识符", example = "S001")
    private String studentId;

    @Schema(title = "该成绩所属课程ID", description = "该成绩所属的课程的唯一标识符", example = "C001")
    private String courseId;

    @Schema(title = "分数", description = "该成绩的具体数值", example = "80")
    private Integer score;

    private Student studentInfo = null;

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
