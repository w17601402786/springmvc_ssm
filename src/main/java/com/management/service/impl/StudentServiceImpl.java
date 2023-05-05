package com.management.service.impl;

import com.management.mapper.CourseMapper;
import com.management.mapper.GradeMapper;
import com.management.mapper.StudentMapper;
import com.management.pojo.Course;
import com.management.pojo.Grade;
import com.management.pojo.Student;
import com.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private GradeMapper scoreMapper;

    @Override
    public Student getStudentById(Integer id) {
        return null;
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        return null;
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }

    @Override
    public String getClassInfo(String studentId) {
        return null;
    }

    @Override
    public List<Course> getCourses(String studentId) {
//        return courseMapper.getCoursesByStudentId(studentId);
        return null;
    }

    @Override
    public List<Course> getCourseTable(String studentId) {
//        return courseMapper.getCourseTableByClassId(
//                studentMapper.getStudentByStudentId(studentId).getClassId());
        return null;
    }

    @Override
    public List<Grade> getScores(String studentId) {
//        return scoreMapper.getScoresByStudentId(studentId);
        return null;
    }

    @Override
    public int changePassword(String studentId, String password) {
//        Student student = studentMapper.getStudentBySno(studentId);
//        if (student == null) {
//            return 0;
//        }
//        student.setPassword(password);
//        return studentMapper.updateStudent(student);
        return 0;
    }
}
