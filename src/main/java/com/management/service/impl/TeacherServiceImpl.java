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

    @Override
    public List<Teacher> getAllTeachers(String userType) {

        if (!userType.equals("admin")){
            return null;
        }

        return teacherMapper.getTeachers(null);
    }

    @Override
    // todo 用都不会用，傻叼
    public List<Teacher> getTeachers(Teacher teacher, String userType) {

        if (!userType.equals("admin")){
            return null;
        }

        return teacherMapper.getTeachers(teacher);
    }

    @Override
    public int addTeacher(Teacher teacher, String userType) {

        //TODO 傻叼，好多地方都看你都在瞎用权限验证
        //TODO 权限给老师了，管理员干啥？
        if (!userType.equals("admin")){
            return 0;
        }

        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int deleteTeacherByUserId(Integer userId, String userType) {
        if (!userType.equals("admin")){
            return 0;
        }

        return teacherMapper.deleteTeacherByUserId(userId);
    }

    @Override
    public int updateTeacher(Teacher teacher, String userType) {

        if (!userType.equals("admin")){
            return 0;
        }

        return teacherMapper.updateTeacher(teacher);

    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {

        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);

        List<Teacher> teachers = teacherMapper.getTeachers(teacher);

        return teachers.size() == 0 ? null : teachers.get(0);
    }

    @Override
    public Teacher getTeacherByName(String name) {

        Teacher teacher = new Teacher();
        teacher.setName(name);

        List<Teacher> teachers = teacherMapper.getTeachers(teacher);
        return teachers.size() == 0 ? null : teachers.get(0);
    }


    @Override
    public Teacher getTeacherByUserId(Integer userId) {

        Teacher teacher = new Teacher();
        teacher.setUserId(userId);

        List<Teacher> teachers = teacherMapper.getTeachers(teacher);

        return teachers.size() == 0 ? null : teachers.get(0);
    }



    //-----------------你他妈-----------------//
    //以下代码全都废弃，不要用了，用了就是傻叼
    //以下代码全都废弃，不要用了，用了就是傻叼
    //以下代码全都废弃，不要用了，用了就是傻叼
    //-----------------你他妈-----------------//


    @Override
    @Deprecated
    public List<Course> getCourses(String teacherId) {
        List<Course> courses = teacherMapper.getTeacherCourses(teacherId);
        return courses;
    }


    @Override
    @Deprecated
    public List<Grade> getGrades(Integer userId) {
        return null;
    }

    @Override
    @Deprecated
    public Teacher getTeacherById(Integer id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    @Deprecated
    public Teacher getTeacherByTeacherID(String teacherID) {
        return teacherMapper.getTeacherByTeacherId(teacherID);
    }

    @Override
    @Deprecated
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }


    @Override
    @Deprecated
    public List<Course> getCourse(String teacherId) {
        List<Course> courses = teacherMapper.getTeacherCourses(teacherId);
        return courses;

    }



    @Override
    @Deprecated
    public List<Grade> getGrade(String teacherId) {
        return teacherMapper.getGrade(teacherId);
    }

    @Override
    @Deprecated
    public int submitGrade(String studentId, String courseId, int score) {

        //TODO 这里应该使用addGrade方法进行添加

        return 0;

    }

}