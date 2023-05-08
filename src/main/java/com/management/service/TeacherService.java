package com.management.service;

import com.management.pojo.Course;
import com.management.pojo.CourseSchedule;
import com.management.pojo.Grade;
import com.management.pojo.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    // 获取教师信息
    Teacher getTeacherById(Integer Id);
    // 根据教师的职工号获取相应信息
    Teacher getTeacherByTeacherID(String TeacherID);
    // 更新教师信息
    int updateTeacher(Teacher teacher);
    // 获取教师所教课程的基本信息
    List<Course> getCourse(String teacherId);
    // 获取教师的课程表信息
    List<CourseSchedule> getGradeCalendar(String teacherId);
    // 获取教师的成绩信息
    List<Grade> getGrade(String teacherId);
    // 提交成绩
    int submitGrade(String studentId, String courseId, int score);
}
