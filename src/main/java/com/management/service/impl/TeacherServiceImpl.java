package com.management.service.impl;

import com.management.mapper.*;
import com.management.pojo.Course;
import com.management.pojo.CourseSchedule;
import com.management.pojo.Grade;
import com.management.pojo.Teacher;
import com.management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseScheduleMapper courseScheduleMapper;
    @Autowired
    private GradeMapper gradeMapper;
//
//    @Override
//    public List<Teacher> getAllTeachers(String userType) {
//        return null;
//    }
//
//    @Override
//    public List<Teacher> getTeachers(Teacher teacher, String userType) {
//        return null;
//    }
//
//    @Override
//    public int addTeacher(Teacher teacher, String userType) {
//        return 0;
//    }
//
//    @Override
//    public int deleteTeacherByUserId(Integer userId, String userType) {
//        return 0;
//    }
//
//    @Override
//    public int updateTeacher(Teacher teacher, String userType) {
//        return 0;
//    }
//
//    @Override
//    public Teacher getTeacherByTeacherId(String teacherId) {
//        return null;
//    }
//
//    @Override
//    public Teacher getTeacherByName(String name) {
//        return null;
//    }
//
//    @Override
//    public Teacher getTeacherByUserId(Integer userId) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getCourses(Integer userId) {
//        return null;
//    }
//
//    @Override
//    public List<CourseSchedule> getCourseSchedule(Integer userId) {
//        return null;
//    }
//
//    @Override
//    public List<Grade> getGrades(Integer userId) {
//        return null;
//    }
//


    @Override
    public List<Teacher> getAllTeachers(String userType) {
        return null;
    }

    @Override
    public List<Teacher> getTeachers(Teacher teacher, String userType) {
        return null;
    }

    @Override
    public int addTeacher(Teacher teacher, String userType) {
        return 0;
    }

    @Override
    public int deleteTeacherByUserId(Integer userId, String userType) {
        return 0;
    }

    @Override
    public int updateTeacher(Teacher teacher, String userType) {
        return 0;
    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {
        return teacherMapper.getTeacherByTeacherId(teacherId);
    }

    @Override
    public Teacher getTeacherByName(String name) {
        List<Teacher> teachers = teacherMapper.getTeacherByName();
        return teachers.size() == 0 ? null : teachers.get(0);
    }


    @Override
    public Teacher getTeacherByUserId(Integer userId) {
        return teacherMapper.getTeacherByUserId(userId);
    }

    @Override
    public List<Course> getCourses(String teacherId) {
        List<Course> courses = teacherMapper.getTeacherCourses(teacherId);
        return courses;
    }

    @Override
    public List<CourseSchedule> getCourseSchedule(Integer userId) {
        List<CourseSchedule> courseSchedules = courseScheduleMapper.getCourseScheduleByUserId(userId);
        return courseSchedules;
    }

    @Override
    public List<Grade> getGrades(Integer userId) {
        return null;
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public Teacher getTeacherByTeacherID(String teacherID) {
        return teacherMapper.getTeacherByTeacherId(teacherID);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }


    @Override
    public List<Course> getCourse(String teacherId) {
        List<Course> courses = teacherMapper.getTeacherCourses(teacherId);
        return courses;

    }

    @Override
    public List<CourseSchedule> getGradeCalendar(String teacherId) {
        List<CourseSchedule> courseSchedules = courseScheduleMapper.getCourseSchedulesByTeacherId(teacherId);
        return courseSchedules;
    }

    @Override
    public List<Grade> getGrade(String teacherId) {
        return teacherMapper.getGrade(teacherId);
    }

    @Override
    public int submitGrade(String studentId, String courseId, int score) {

        //TODO 这里应该使用addGrade方法进行添加

        return 0;


//        Grade g = gradeMapper.getGradeByStudentIdAndCourseId(studentId, courseId);
//        if(g == null){
//            return 0;
//        }
//        g.setScore(score);
//        return gradeMapper.updateGrade(g);
    }

}