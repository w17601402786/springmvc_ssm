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
 *         <td>time</td>
 *         <td>Date</td>
 *         <td>上课时间</td>
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
    private Date time;
    private String location;
    private Course courseInfo = null;
    private Classes classInfo = null;

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

    public Classes getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(Classes classInfo) {
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
