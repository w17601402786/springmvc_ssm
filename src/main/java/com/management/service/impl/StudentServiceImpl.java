package com.management.service.impl;

import com.management.pojo.*;
import com.management.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> getAllStudents(String userType) {
        return null;
    }

    @Override
    public List<Student> getStudents(Student student, String userType) {
        return null;
    }

    @Override
    public int addStudent(Student student, String userType) {
        return 0;
    }

    @Override
    public int deleteStudentByUserId(Integer userId, String userType) {
        return 0;
    }

    @Override
    public int updateStudent(Student student, String userType) {
        return 0;
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        return null;
    }

    @Override
    public Student getStudentByName(String name) {
        return null;
    }

    @Override
    public List<Student> getStudentByClassInfo(ClassInfo classInfo) {
        return null;
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return null;
    }

    @Override
    public ClassInfo getClassInfo(Integer userId) {
        return null;
    }

    @Override
    public Student getStudentByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Course> getCourses(Integer userId) {
        return null;
    }

    @Override
    public List<CourseSchedule> getCourseSchedule(Integer userId) {
        return null;
    }

    @Override
    public List<Grade> getGrades(Integer userId) {
        return null;
    }
}
