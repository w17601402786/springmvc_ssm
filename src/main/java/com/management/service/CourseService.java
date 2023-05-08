package com.management.service;

import com.management.pojo.*;

import java.util.List;

/**
 * 课程信息管理Service接口
 */
public interface CourseService {


    /**
     * 添加课程信息
     * @param course 班级信息
     * @param userType 当前用户类型
     * @return 添加结果
     */
    int addCourse(Course course,String userType);

    /**
     * 更新课程信息
     * @param course 更新后的班级信息
     * <p color="red">
     *     不能更新课程号
     * </p>
     * @param userType 当前用户类型
     * @return 更新结果
     */
    int updateCourse(Course course,String userType);

    /**
     * 根据课程号删除班级信息
     * @param courseId 课程号
     * @param userType 当前用户类型
     * @return 删除结果
     */
    int deleteCourseById(String courseId,String userType);


    /**
     * 根据Course的Bean查询班级信息
     * @param course 课程的Bean
     * @return 课程信息列表
     */
    List<Course> getCourse(Course course);




}
