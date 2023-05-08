package com.management.service.impl;

import com.management.mapper.CourseMapper;
import com.management.mapper.CourseScheduleMapper;
import com.management.mapper.GradeMapper;
import com.management.mapper.TeacherMapper;
import com.management.pojo.Course;
import com.management.pojo.CourseSchedule;
import com.management.pojo.Grade;
import com.management.pojo.Teacher;
import com.management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherServiceImpl  implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseScheduleMapper courseScheduleMapper;
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public Teacher getTeacherByTeacherID(String TeacherID) {
        return null;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }


    @Override
    public List<Course> getCourse(String teacherId) {
        return null;
    }

    @Override
    public List<CourseSchedule> getGradeCalendar(String teacherName) {
        return courseScheduleMapper.getCourseSchedulesByTeacherName(teacherName);
    }

    @Override
    public List<Grade> getGrade(String teacherId) {
        return gradeMapper.getScoreByTeacherId(teacherId);
    }

    @Override
    public int submitGrade(String studentId, String courseId, int score) {
        Grade g = gradeMapper.getGradeByStudentIdAndCourseId(studentId, courseId);
        if(g == null){
            return 0;
        }
        g.setScore(score);
        return gradeMapper.updateGrade(g);
    }

}