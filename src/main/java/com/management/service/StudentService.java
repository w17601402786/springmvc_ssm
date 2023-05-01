package com.management.service;

import com.management.pojo.Course;
import com.management.pojo.Score;
import com.management.pojo.Student;

import java.util.List;

public interface StudentService {
    // 获取学生信息
    Student getStudentById(Integer id);

    // 根据学号获取学生信息
    Student getStudentByStudentId(String studentId);

    // 更新学生信息
    int updateStudent(Student student);

    // 获取学生所属班级的基本信息
    String getClassInfo(String studentId);

    // 获取学生所选课程信息
    List<Course> getCourses(String studentId);

    // 获取学生所在班级的课程表信息
    List<Course> getCourseTable(String studentId);

    // 获取学生的成绩信息
    List<Score> getScores(String studentId);

    // 修改学生登录密码
    int changePassword(String studentId, String password);
}
