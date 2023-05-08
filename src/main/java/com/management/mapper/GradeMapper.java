package com.management.mapper;

import com.management.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    // 增加一条成绩记录
    int addGrade(Grade grade);

    // 删除一条成绩记录
    int deleteGradeById(Integer id);

    // 修改一条成绩记录
    int updateGrade(Grade grade);

    // 查询所有成绩记录
    List<Grade> getAllGrades();

    // 根据id查询一条成绩记录
    Grade getGradeById(Integer id);

    // 根据学生号和课程号查询一条成绩记录
    Grade getGradeByStudentIdAndCourseId(String studentId, String courseId);

    List<Grade> getScoreByTeacherId(String teacherId);
}
