package com.management.service.impl;

import com.management.mapper.GradeMapper;
import com.management.pojo.Course;
import com.management.pojo.Grade;
import com.management.pojo.Users;
import com.management.service.GradeService;
import com.management.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GradeServiceImpl implements GradeService {


    @Autowired
    GradeMapper gradeMapper;

    @Autowired
    TeacherService teacherService;


    @Override
    public int addGradesByAdmin(List<Grade> grades, String userType) {

        if (userType.equals("admin")) {
            return 0;
        }



        return gradeMapper.addGrades(grades);
    }

    /**
     * 老师录入成绩需要进行验证，确保是自己的授课，必须保证录入
     * @param grades 成绩信息
     * @param userType 当前用户类型
     * @return 添加结果
     */
    @Override
    public int addGradesByTeacher(List<Grade> grades, String userType) {

        if (!userType.equals("teacher")) {
            return 0;
        }

        grades.forEach(System.out::println);


        return gradeMapper.addGrades(grades);
    }

    @Override
    public int deleteGrade(int id, String userType) {

        if (userType.equals("admin")) {
            return 0;
        }

        return  gradeMapper.deleteGradeById(id);
    }

    @Override
    public int updateGrade(Grade grade, String userType) {

        if (userType.equals("admin")) {
            return 0;
        }

        return gradeMapper.updateGrade(grade);
    }



    /**
     * TODO 在切面中进行判断，如果是学生，则只能查询自己的成绩
     * TODO 在切面中进行判断，如果是教师，则只能查询自己教授的课程的成绩
     * TODO 在切面中进行判断，如果是管理员，则可以查询所有的成绩
     * @param grade 成绩信息
     *              <p>
     *              可以关联grade中的其他属性进行查询
     *              例如：grade中的studentId属性不为空，则查询该学生的所有成绩
     *              也可以通过student对象的其他属性进行查询
     *              例如：grade.student对象中的name属性不为空，则查询该名字的学生的所有成绩
     *              也可以通过course对象的其他属性进行查询
     *              例如：grade.course对象中的name属性不为空，则查询该课程的所有成绩

     *              </p>
     * @param userType 当前用户类型
     * @return 查询结果
     */
    @Override
    public List<Grade> getGrades(Grade grade,String userType) {

        return gradeMapper.getGrades(grade);
    }

    @Override
    public List<Grade> getGradesByTeacher(Grade grade, Users users, String userType) {



        if (!"teacher".equals(userType)){
            return null;
        }


        List<Course> courseList = teacherService.getCourses(users.getTeacherInfo().getTeacherId());

        boolean isExist = false;



        for (Course course : courseList){
            if (course.getCourseId().equals(grade.getCourseId())){
                isExist = true;
                break;
            }
        }

        if (!isExist && !(grade.getCourseId() == null || "".equals(grade.getCourseId()))){
            return null;
        }


        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("grade",grade);
        paramMap.put("teacherInfo",users.getTeacherInfo());


        return gradeMapper.getGradesByScoreRange(paramMap);
    }


    @Override
    public List<Grade> getGradesByScoreRange(Grade grade,int minScore, int maxScore,String userType) {

        Map<String,Object> map = new HashMap<>();

        map.put("grade",grade);
        map.put("minScore",minScore);
        map.put("maxScore",maxScore);

        return gradeMapper.getGradesByScoreRange(map);
    }

    @Override
    @Deprecated
    public List<Grade> getGradesByStudentId(String studentId) {
        return null;
    }

    @Override
    @Deprecated
    public List<Grade> getGradesByCourseId(String courseId) {
        return null;
    }


}
