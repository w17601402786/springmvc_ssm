package com.management.service;

import com.management.pojo.*;

import java.util.List;

/**
 * 学生信息管理Service接口
 */
public interface StudentService {


    /**
     * 获取所有学生信息
     * <p>仅管理员可用</p>
     * <p>即需要验证userType="admin"</p>
     * @param userType 当前用户类型
     * @return 所有学生信息
     */
    List<Student> getAllStudents(String userType);


    /**
     * 通过学生的Bean获取学生信息
     * <p>仅管理员可用</p>
     * @param student 学生的Bean
     * @param userType 当前用户类型
     * @return 学生信息
     */
    List<Student> getStudents(Student student,String userType);


    /**
     * 添加学生信息
     * <p>仅管理员可用</p>
     * <span color="red">
     *     注意！这里的不是单纯的添加功能，需要进行用户存在的验证
     *     如果用户存在，才可以添加学生信息
     *     如果用户不存在，不可以添加学生信息
     *     用户信息存储在Student的userInfo属性中
     *     记得判断userInfo是否为空，以及
     *     学生信息中学号是否为空
     *     以及当前用户是否已经拥有其学生信息
     *     以及记得修改用户的userType属性
     * </span>
     * @param student 学生信息
     * @param userType 当前用户类型
     * @return 添加结果
     */
    int addStudent(Student student,String userType);

    /**
     * 根据用户ID删除学生信息
     * <p>仅管理员可用</p>
     * <span color="red">
     *     记得同时删除用户信息
     * </span>
     * @param userId 用户ID
     * @param userType 当前用户类型
     * @return 删除结果
     */
    int deleteStudentByUserId(Integer userId, String userType);


    /**
     * 更新学生信息
     * <p>仅管理员可用</p>
     * <span color="red">
     *     使用用户的学号和用户ID对学生信息进行更新
     * </span>
     * @param student 更新后的学生信息
     * @param userType 当前用户类型
     * @return 更新结果
     */
    int updateStudent(Student student,String userType);


    /**
     * 根据学号查询单个学生信息
     * @param studentId 学号
     * @return 学生信息
     */
    Student getStudentByStudentId(String studentId);

    /**
     * 根据姓名查询单个学生信息
     * @param name 姓名
     * @return 学生信息
     */
    List<Student> getStudentsByName(String name);

    /**
     * 根据班级信息查询学生信息
     * @param classes 班级信息
     * @return 学生信息列表
     */
    List<Student> getStudentByClasses(Classes classes);

    /**
     * 根据专业信息查询学生信息
     *
     * <p color="yellow">
     *      学生表中，每个学生都有专业信息了
     * </p>
     * @param major 专业
     * @return 学生信息列表
     */
    List<Student> getStudentByMajor(String major);


    /**
     * 根据用户ID查询当前学生的班级信息
     * <p color="red">
     *  涉及到三个表的联合查询
     * </p>
     * @param users 用户信息
     * @return 班级信息
     */
    Classes getClasses(Users users);


    /**
     * 获取当前学生的学生信息
     * @param userId 用户ID
     * @return 当前学生信息
     */
    Student getStudentByUserId(Integer userId);


    /**
     * 获取当前学生的课程信息
     * <p color="yellow">
     *  涉及四个表，学生表，班级信息表，
     *  课程的数据表、课程表的联合查询
     *  记得对课程去重
     * </p>
     * @param users 用户信息
     * @return 课程信息列表
     */
    List<Course> getCourses(Users users);

    /**
     * 获取当前用户的课程表信息
     * @param users 用户信息
     * @return 课程表信息列表
     */
    List<CourseSchedule> getCourseSchedule(Users users);


    /**
     * 获取当前学生的成绩信息
     * @param userId 用户ID
     * @return 成绩信息列表
     */
    List<Grade> getGrades(Integer userId);

    /**
     * 获取学生的成绩信息
     * @param studentId  学生的学号
     * @return 成绩列表
     */
    List<Grade> getGradeByStudentId(String studentId);

    /**
     * 选课
     * @param studentId 学生的学号
     * @param courseId 课程的id
     * @return 选课结果
     */
    int selectCourse(String studentId, String courseId);

    /**
     * 退课
     * @param studentId 学生的学号
     * @param courseId 课程的id
     * @return 退课结果
     */
    int withdrawCourse(String studentId, String courseId);



    //====================================//
    //      修改密码功能通过用户服务功能实现    //
    //====================================//

}
