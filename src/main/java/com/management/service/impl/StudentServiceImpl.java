package com.management.service.impl;

import com.management.mapper.CourseMapper;
import com.management.mapper.ScoreMapper;
import com.management.mapper.StudentMapper;
import com.management.pojo.Course;
import com.management.pojo.Score;
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
    private ScoreMapper scoreMapper;

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        return studentMapper.getStudentByStudentId(studentId);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public String getClassInfo(String studentId) {
        return studentMapper.getClassInfo(studentId);
    }

    @Override
    public List<Course> getCourses(String studentId) {
        return courseMapper.getCoursesByStudentId(studentId);
    }

    @Override
    public List<Course> getCourseTable(String studentId) {
        return courseMapper.getCourseTableByClassId(
                studentMapper.getStudentByStudentId(studentId).getClassId());
    }

    @Override
    public List<Score> getScores(String studentId) {
        return scoreMapper.getScoresByStudentId(studentId);
    }

    @Override
    public int changePassword(String studentId, String password) {
        Student student = studentMapper.getStudentByStudentId(studentId);
        if (student == null) {
            return 0;
        }
        student.setPassword(password);
        return studentMapper.updateStudent(student);
    }
}
