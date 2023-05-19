package com.management.service.impl;

import com.management.mapper.ClassesMapper;
import com.management.mapper.StudentMapper;
import com.management.mapper.UsersMapper;
import com.management.pojo.*;
import com.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ClassesMapper classesMapper;
    @Autowired
    UsersMapper usersMapper;


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
        if (!userType.equals("student")){
            return -1;
        }

        return studentMapper.addStudent(student);

    }

    @Override
    public int deleteStudentByUserId(Integer userId, String userType) {
        if (!userType.equals("student")){
            return -1;
        }

        return studentMapper.deleteStudentByUserId(userId);
    }

    @Override
    public int updateStudent(Student student,String userType) {
//        if (!userType.equals("student")){
//            return -1;
//        }
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

        List<Student> students = studentMapper.getStudentByClass(classes.getMajor(),classes.getName());
        return students.size() == 0 ? null : students;
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
//        List<Student> students = studentMapper.
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
//        return studentMapper.getGradeByStudentId()
        return null;
    }


    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public List<Course> getCourse(String studentId) {
        return null;
    }

    @Override
    public List<CourseSchedule> getGradeCalendar(String studentId) {
        return null;
    }

    @Override
    public List<Grade> getGradeByStudentId(String studentId) {
        List<Grade> grades = studentMapper.getGradeByStudentId(studentId);
        return grades;
    }

    @Override
    public int selectCourse(String studentId, String courseId) {
        return 0;
    }

    @Override
    public int withdrawCourse(String studentId, String courseId) {
        return 0;
    }

    @Override
    public List<Student> getStudents(Student student) {
        List<Student> students =  studentMapper.getStudents(student);
        return students.size() == 0 ? null : students;
    }
}
