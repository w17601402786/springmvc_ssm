package com.management.service;

import com.management.pojo.Grade;

import java.util.List;

/**
 * 成绩管理业务逻辑接口
 */
public interface GradeService {
    /**
     * 管理员添加成绩操作
     * @param grade 成绩信息
     * @param userType 当前用户类型
     * @return 添加结果
     */
    int addGradeByAdmin(Grade grade,String userType);

    /**
     * 教师添加成绩操作
     * <p color="red">
     *     注意！这里需要进行验证，必须保证录入
     *     成绩的学生和课程存在，且是该教师教授的课程
     *     否则不允许录入成绩
     * </p>
     * @param grade 成绩信息
     * @param userType 当前用户类型
     * @return 添加结果
     */
    int addGradeByTeacher(Grade grade,String userType);

    /**
     * 根据成绩ID删除成绩
     * <p>仅管理员可用</p>
     * @param id 成绩ID
     * @return 删除结果
     */
    int deleteGrade(int id,String userType);

    /**
     * 根据成绩ID修改成绩
     * <p>仅管理员可用</p>
     * @param grade 成绩信息
     * @param userType 当前用户类型
     * @return 修改结果
     */
    int updateGrade(Grade grade, String userType);


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
     * @return 成绩信息
     */
    List<Grade> getGrades(Grade grade,String userType);

    //======================//
    //  以下为查询操作接口    //
    //  暂时不实现          //
    //======================//

    /**
     * 根据学号查询成绩
     * @param studentId 学号
     * @return 成绩信息
     */
    @Deprecated
    List<Grade> getGradesByStudentId(String studentId);


    /**
     * 根据课程ID查询成绩
     * @param courseId 课程ID
     * @return 成绩信息
     */
    @Deprecated
    List<Grade> getGradesByCourseId(String courseId);


    /**
     * 根据成绩区间查询成绩
     * @param grade 成绩信息
     * @param minScore 最小成绩
     * @param maxScore 最大成绩
     * @return  成绩信息
     */
    public List<Grade> getGradesByScoreRange(Grade grade,int minScore, int maxScore,String userType);

}
