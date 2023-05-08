package com.management.service;

import com.management.pojo.Course;
import com.management.pojo.CourseSchedule;
import com.management.pojo.Grade;
import com.management.pojo.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    /**
     * 通过教师的id获取教师的基本信息
     * @param Id 教师的id
     * @return 教师对象
     */
    Teacher getTeacherById(Integer Id);

    /**
     * 通过教师的教工号获取教师的基本信息
     * @param TeacherID 教师的教工号
     * @return 教师对象
     */
    Teacher getTeacherByTeacherID(String TeacherID);

    /**
     * 更新教师的基本信息
     * @param teacher 修改后的教师对象
     * @return 更新结果
     */
    int updateTeacher(Teacher teacher);

    /**
     * 获取教师的课程信息
     * @param teacherId 教师的教工号
     * @return 课程列表
     */
    List<Course> getCourse(String teacherId);

    /**
     * 获取教师的课程表信息
     * @param teacherId 教师的教工号
     * @return 课程表列表
     */
    List<CourseSchedule> getGradeCalendar(String teacherId);

    /**
     * 获取教师的教学班的学生的成绩信息
     * @param teacherId  教师的教工号
     * @return 成绩列表
     */
    List<Grade> getGrade(String teacherId);

    /**
     * 提交成绩
     * @param studentId 学生的学号
     * @param courseId 课程的id
     * @param score 成绩
     * @return  成绩提交结果
     */
    int submitGrade(String studentId, String courseId, int score);
}
