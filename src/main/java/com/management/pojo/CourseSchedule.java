package com.management.pojo;

import java.util.Date;


/**
 * 课程安排类
 * <table summary="成员变量说明">
 *     <tr>
 *         <th>成员变量</th>
 *         <th>类型</th>
 *         <th>含义</th>
 *     </tr>
 *     <tr>
 *         <td>id</td>
 *         <td>Integer</td>
 *         <td>课表记录的唯一标识</td>
 *     </tr>
 *     <tr>
 *         <td>courseId</td>
 *         <td>String</td>
 *         <td>所安排的课程的编号</td>
 *     </tr>
 *     <tr>
 *         <td>classId</td>
 *         <td>String</td>
 *         <td>上课班级的编号</td>
 *     </tr>
 *     <tr>
 *         <td>teacherId</td>
 *         <td>String</td>
 *         <td>授课教师的编号</td>
 *     </tr>
 *     <tr>
 *         <td>start_time</td>
 *         <td>Integer</td>
 *         <td>上课开始节次</td>
 *     </tr>
 *     <tr>
 *         <td>end_time</td>
 *         <td>Integer</td>
 *         <td>上课结束节次</td>
 *     </tr>
 *     <tr>
 *         <td>location</td>
 *         <td>String</td>
 *         <td>上课地点</td>
 *     </tr>
 *     <tr>
 *         <td>courseInfo</td>
 *         <td>Course</td>
 *         <td>所安排的课程详情</td>
 *     </tr>
 *     <tr>
 *         <td>classInfo</td>
 *         <td>ClassInfo</td>
 *         <td>上课班级的详情</td>
 *     </tr>
 * </table>
 */
public class CourseSchedule {
    private Integer id;
    private String courseId;
    private String classId;
    private String teacherId;
    /**
     * 课程开始的节次
     */
    private Integer startTime;

    /**
     * 课程结束的节次
     */
    private Integer endTime;
    private String location;

    /**
     * 课程安排的周次
     * <p color="green">
     *     使用位运算来存储，一个week最多存储32个周的数据
     * </p>
     * <p color="yellow">
     *     例如：第1、3、5周上课，那么week=0010101B=21
     * </p>
     */
    private Integer week;

    /**
     * 课程安排的星期
     * <p color="green">
     *     使用位运算来存储，一个day最多存储7个星期的数据
     * </p>
     * <p color="yellow">
     *     例如：周一、周三、周五上课，那么day=0010101B=21
     * </p>
     */
    private Integer day;

    private Course courseInfo = null;
    private Classes classes = null;
    private Teacher teacher = null;

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

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Course getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(Course courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "CourseSchedule{" +
                "id=" + id +
                ", courseId='" + courseId + '\'' +
                ", classId='" + classId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", location='" + location + '\'' +
                ", week=" + week +
                ", day=" + day +
                ", courseInfo=" + courseInfo +
                ", classInfo=" + classes +
                ", teacher=" + teacher +
                '}';
    }
}
