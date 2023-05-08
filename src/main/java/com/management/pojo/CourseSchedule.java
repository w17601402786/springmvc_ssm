package com.management.pojo;

import java.util.Date;

public class CourseSchedule {
    private Integer id;
    private String courseId;
    private String classId;
    private String teacherId;
    private Date time;
    private String location;
    private Course courseInfo = null;
    private ClassInfo classInfo = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Course getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(Course courseInfo) {
        this.courseInfo = courseInfo;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }


    @Override
    public String toString() {
        return "CourseSchedule{" +
                "id=" + id +
                ", courseId='" + courseId + '\'' +
                ", classId='" + classId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", courseInfo=" + courseInfo +
                ", classInfo=" + classInfo +
                '}';
    }
}
