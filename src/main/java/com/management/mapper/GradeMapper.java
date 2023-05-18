package com.management.mapper;

import com.management.pojo.Grade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    /**
     * 添加一条成绩记录
     * @param grade 成绩信息
     * @return 添加结果
     */
    int addGrade(Grade grade);

    /**
     * 根据成绩ID删除一条成绩记录
     * @param id 成绩ID
     * @return 删除结果
     */
    int deleteGradeById(Integer id);

    /**
     * 根据成绩ID修改一条成绩记录,只能修改成绩
     * @param grade 成绩信息
     * @return 修改结果
     */
    int updateGrade(Grade grade);

    /**
     * 根据成绩的Bean对象查询成绩
     * @param grade 成绩信息
     *              <p>
     *              可以关联grade中的其他属性进行查询
     *              例如：grade中的studentId属性不为空，则查询该学生的所有成绩
     *              也可以通过student对象的其他属性进行查询
     *              例如：grade.student对象中的name属性不为空，则查询该名字的学生的所有成绩
     *              也可以通过course对象的其他属性进行查询
     *              例如：grade.course对象中的name属性不为空，则查询该课程的所有成绩
     *              </p>
     *
     * @return 查询结果
     */
    List<Grade> getGrades(Grade grade);

//    // 根据id查询一条成绩记录
//    Grade getGradeById(Integer id);
//
//    // 根据学生号和课程号查询一条成绩记录
//    Grade getGradeByStudentIdAndCourseId(String studentId, String courseId);
//
//    List<Grade> getScoreByTeacherId(String teacherId);
}
