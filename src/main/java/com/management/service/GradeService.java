package com.management.service;

import com.management.pojo.Grade;

import java.util.List;

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
     * 根据学号查询成绩
     * @param studentId 学号
     * @return 成绩信息
     */
    List<Grade> getGradesByStudentId(String studentId);


    /**
     * 根据课程ID查询成绩
     * @param courseId 课程ID
     * @return 成绩信息
     */
    List<Grade> getGradesByCourseId(String courseId);


    /**
     * 根据成绩区间查询成绩
     * @param minScore 最小成绩
     * @param maxScore 最大成绩
     * @return  成绩信息
     */
    List<Grade> getGradesByScoreRange(int minScore, int maxScore);


}
