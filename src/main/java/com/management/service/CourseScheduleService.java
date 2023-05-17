package com.management.service;

import com.management.pojo.CourseSchedule;

import java.util.List;

/**
 * 课程表管理业务逻辑接口
 * 需要实现：
 * <ol>
 *     <li>管理员对课程表的增删改查</li>
 *     <li>根据课程号、课程名、教师进行课程表查询</li>
 *     <li>根据时间进行查询</li>
 *     <li>
 *         管理员排课时（也就是课表的增删改查），
 *         一名教师不能同时给两个班级上课，一个班不能同时上两门课，一个教室不能同时排两门课
 *     </li>
 * </ol>
 */
public interface CourseScheduleService {


    /**
     * 添加课程表
     * <p color="red">需要进行排课冲突检测</p>
     * @param courseSchedule 课程表信息
     * @param userType 当前用户类型
     * @return 添加结果
     */
    int addCourseSchedule(CourseSchedule courseSchedule, String userType);

    /**
     * 根据课程表ID删除课程表
     * @param id 课程表ID
     * @param userType 当前用户类型
     * @return 删除结果
     */
    int deleteCourseSchedule(int id, String userType);

    /**
     * 修改课程表
     * <p>需要进行排课冲突检测</p>
     * @param courseSchedule 修改后课程表信息
     * @param userType 当前用户类型
     * @return 修改结果
     */
    int updateCourseSchedule(CourseSchedule courseSchedule, String userType);


    /**
     * 查询课程表
     * @param courseSchedule 查询条件
     * @param userType 当前用户类型
     * @return 课程表信息
     */
    List<CourseSchedule> getCourseSchedule(CourseSchedule courseSchedule, String userType);


    /**
     * 根据userId查询课程表信息
     * @param userId 用户ID
     * @return 课程表信息
     */
    List<CourseSchedule> getCourseSchedulesByUserId(Integer userId);

}
