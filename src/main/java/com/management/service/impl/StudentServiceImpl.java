package com.management.service.impl;

import com.management.mapper.ClassesMapper;
import com.management.mapper.GradeMapper;
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

    @Autowired
    GradeMapper gradeMapper;


    @Override
    public List<Student> getAllStudents(String userType) {

        if (!userType.equals("admin")){
            return null;
        }

        return studentMapper.getStudents(null);
    }

    @Override
    public List<Student> getStudents(Student student, String userType) {

        if (!userType.equals("admin")){
            return null;
        }

        return studentMapper.getStudents(student);
    }

    @Override
    public int addStudent(Student student, String userType) {
        if (!userType.equals("student")){
            return 0;
        }

        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudentByUserId(Integer userId, String userType) {

        // 只有管理员可以删除学生
        if (!userType.equals("admin")){
            return 0;
        }

        return studentMapper.deleteStudentByUserId(userId);
    }

    @Override
    public int updateStudent(Student student,String userType) {

        if (!userType.equals("admin")){
            return 0;
        }

        return studentMapper.updateStudent(student);
    }




    @Override
    public Student getStudentByStudentId(String studentId) {

        Student student = new Student();
        student.setStudentId(studentId);

        List<Student> students = studentMapper.getStudents(student);

        return students.size() == 0 ? null : students.get(0);
    }

    @Override
    public List<Student> getStudentsByName(String name) {

        Student student = new Student();
        student.setName(name);

        return studentMapper.getStudents(student);

    }

    @Override
    public List<Student> getStudentByClasses(Classes classes) {

        Student student = new Student();
        student.setClasses(classes);

        return studentMapper.getStudents(student);

    }

    @Override
    public List<Student> getStudentByMajor(String major) {

        Student student = new Student();
        student.setMajor(major);

        return studentMapper.getStudents(student);
    }

    @Override
    public Student getStudentByUserId(Integer userId) {

        Student student = new Student();
        student.setUserId(userId);

        List<Student> students = studentMapper.getStudents(student);

        return students.size() == 0 ? null : students.get(0);
    }

    @Override
    public Classes getClasses(Integer userId) {
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

        Student student = new Student();
        student.setUserId(userId);

        Grade grade = new Grade();
        grade.setStudentInfo(student);

        return gradeMapper.getGrades(grade);

    }


    @Override
    public List<Grade> getGradeByStudentId(String studentId) {
        Student student = new Student();
        student.setStudentId(studentId);

        Grade grade = new Grade();
        grade.setStudentInfo(student);

        return gradeMapper.getGrades(grade);
    }

    @Override
    public int selectCourse(String studentId, String courseId) {
        return 0;
    }

    @Override
    public int withdrawCourse(String studentId, String courseId) {
        return 0;
    }

}
