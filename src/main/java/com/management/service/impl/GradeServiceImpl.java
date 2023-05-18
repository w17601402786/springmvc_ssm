package com.management.service.impl;

import com.management.mapper.GradeMapper;
import com.management.pojo.Grade;
import com.management.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {


    @Autowired
    GradeMapper gradeMapper;


    @Override
    public int addGradeByAdmin(Grade grade, String userType) {

        if (userType.equals("admin")) {
            return 0;
        }

        gradeMapper.addGrade(grade);

        return 0;
    }

    @Override
    public int addGradeByTeacher(Grade grade, String userType) {

        if (userType.equals("teacher")) {
            return 0;
        }

        gradeMapper.addGrade(grade);

        return 0;
    }

    @Override
    public int deleteGrade(int id, String userType) {

        if (userType.equals("admin")) {
            return 0;
        }

        gradeMapper.deleteGradeById(id);

        return 0;
    }

    @Override
    public int updateGrade(Grade grade, String userType) {

        if (userType.equals("admin")) {
            return 0;
        }

        gradeMapper.updateGrade(grade);

        return 0;
    }

    @Override
    public List<Grade> getGrades(Grade grade,String userType) {

        //TODO 在切面中进行判断，如果是学生，则只能查询自己的成绩
        //TODO 在切面中进行判断，如果是教师，则只能查询自己教授的课程的成绩
        //TODO 在切面中进行判断，如果是管理员，则可以查询所有的成绩


        return gradeMapper.getGrades(grade);
    }

    @Override
    public List<Grade> getGradesByStudentId(String studentId) {
        return null;
    }

    @Override
    public List<Grade> getGradesByCourseId(String courseId) {
        return null;
    }

    @Override
    public List<Grade> getGradesByScoreRange(int minScore, int maxScore) {
        return null;
    }
}
