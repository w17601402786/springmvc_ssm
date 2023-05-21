package com.management.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("课程信息")
public class Course {

    @ApiModelProperty("课程ID")
    private int id;

    @ApiModelProperty("课程号")
    private String courseId;

    @ApiModelProperty("课程名")
    private String name;

    @ApiModelProperty("学时")
    private int hours;

    @ApiModelProperty("学分")
    private int credit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", credit=" + credit +
                '}';
    }
}
