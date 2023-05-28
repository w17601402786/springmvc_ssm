package com.management.service;

import com.management.pojo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {




    /**
     * 获取所有老师信息
     * <p>仅管理员可用</p>
     * <p>即需要验证userType="admin"</p>
     * @param userType 当前用户类型
     * @return 所有老师信息
     */
    List<Teacher> getAllTeachers(String userType);


    /**
     * 通过老师的Bean获取老师信息
     * <p>仅管理员可用</p>
     * @param  teacher 老师的Bean
     * @param userType 当前用户类型
     * @return 老师信息
     */
    List<Teacher> getTeachers(Teacher teacher,String userType);


    /**
     * 添加老师信息
     * <p>仅管理员可用</p>
     * <span color="red">
     *     注意！这里的不是单纯的添加功能，需要进行用户存在的验证
     *     如果用户存在，才可以添加老师信息
     *     如果用户不存在，不可以添加老师信息
     *     用户信息存储在Teacher的userInfo属性中
     *     记得判断userInfo是否为空，以及
     *     老师信息中职工号是否为空
     *     以及当前用户是否已经拥有其老师信息
     *     以及记得修改用户的userType属性
     * </span>
     * @param teacher 老师信息
     * @param userType 当前用户类型
     * @return 添加结果
     */
    int addTeacher(Teacher teacher,String userType);

    /**
     * 根据用户ID删除老师信息
     * <p>仅管理员可用</p>
     * <span color="red">
     *     记得同时删除用户信息
     * </span>
     * @param userId 用户ID
     * @param userType 当前用户类型
     * @return 删除结果
     */
    int deleteTeacherByUserId(Integer userId, String userType);


    /**
     * 更新老师信息
     * <p>仅管理员可用</p>
     * <span color="red">
     *     使用用户的教工号和用户ID对学生信息进行更新
     * </span>
     * @param teacher 更新后的老师信息
     * @param userType 当前用户类型
     * @return 更新结果
     */
    int updateTeacher(Teacher teacher,String userType);


    /**
     * 根据教工号查询单个学生信息
     * @param teacherId 职工号
     * @return 老师信息
     */
    Teacher getTeacherByTeacherId(String teacherId);


    /**
     * 通过课程号获取教师所授班级所有学生信息
     * @param courseId 教师所授课程id
     * @param teacherId 教师id
     * @return 教师对象
     */
    List<Student> getStudentsByCourseId(String courseId,String teacherId);

    /**
     * 根据姓名查询单个老师信息
     * @param name 姓名
     * @return 老师信息
     */
    @Deprecated
    Teacher getTeacherByName(String name);


    /**
     * 获取当前老师的信息
     * @param userId 用户ID
     * @return 当前老师信息
     */
    Teacher getTeacherByUserId(Integer userId);


    /**
     * 获取当前学生的课程信息
     * <p color="yellow">
     *  涉及三个表，教师表，
     *  课程的数据表、课程表的联合查询
     *  记得对课程去重
     * </p>
     * @param teacherId 用户ID
     * @return 课程信息列表
     */
    List<Course> getCourses(String teacherId);

    /**
     * 获取当前老师的学生成绩信息
     * @param userId 用户ID
     * @return 成绩信息列表
     * @deprecated 废弃，你就不能调用getGrades方法吗？
     */
    List<Grade> getGrades(Integer userId);


    /**
     * 通过教师的id获取教师的基本信息
     * @param Id 教师的id
     * @return 教师对象
     * @deprecated 废弃，你就不能调用getTeachers方法吗？
     */
    Teacher getTeacherById(Integer Id);





    /**
     * 通过教师的教工号获取教师的基本信息
     * @param teacherID 教师的教工号
     * @return 教师对象
     * @deprecated 废弃，你就不能调用getTeachers方法吗？
     */
    @Deprecated
    Teacher getTeacherByTeacherID(String teacherID);

    /**
     * 更新教师的基本信息
     * @param teacher 修改后的教师对象
     * @return 更新结果
     * @deprecated 废弃，你就不能调用updateTeacher方法吗？
     */
    int updateTeacher(Teacher teacher);

    /**
     * 获取教师的课程信息
     *
     * @param teacherId 教师的教工号
     * @return 课程列表
     * @deprecated 废弃，你就不能调用courseService的getCourse方法吗？
     */
    @Deprecated
    List<Course> getCourse(String teacherId);


    /**
     * 获取教师的教学班的学生的成绩信息
     * @param teacherId  教师的教工号
     * @return 成绩列表
     * @deprecated GradeService中有getGrade方法，你就不能调用一下吗？
     */
    @Deprecated
    List<Grade> getGrade(String teacherId);


}
