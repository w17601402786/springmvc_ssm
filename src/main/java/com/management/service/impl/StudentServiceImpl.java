package com.management.service.impl;

import com.management.mapper.StudentMapper;
import com.management.pojo.*;
import com.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;


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
        return studentMapper.getStudentByStudentId(studentId);
    }

    @Override
    public Student getStudentByName(String name) {

        List<Student> students = studentMapper.getStudentByName(name);

        return students.size() == 0 ? null : students.get(0);
    }

    @Override
    public List<Student> getStudentByClasses(Classes classes) {
        return null;
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return null;
    }

    @Override
    public Classes getClasses(Integer userId) {
        return null;
    }

    @Override
    public Student getStudentByUserId(Integer userId) {
        return studentMapper.getStudentByUserId(userId);
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
