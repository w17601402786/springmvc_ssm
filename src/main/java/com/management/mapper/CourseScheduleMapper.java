package com.management.mapper;

import com.management.pojo.CourseSchedule;

import java.util.List;

public interface CourseScheduleMapper {
    /**
     * 添加一条课程表信息
     * @param courseSchedule 课程表信息
     * @return 添加结果
     */
    int addCourseSchedule(CourseSchedule courseSchedule);

    // 删除一条课程表信息
    int deleteCourseScheduleById(Integer id);

    // 修改一条课程表信息
    int updateCourseSchedule(CourseSchedule courseSchedule);

    // 查询所有课程表信息
    List<CourseSchedule> getAllCourseSchedules();

    // 根据id查询一条课程表信息
    CourseSchedule getCourseScheduleById(Integer id);

    // 根据课程号查询该门课程的课程表信息
    List<CourseSchedule> getCourseSchedulesByCourseId(String courseId);

    // 根据班级号查询该班级的课程表信息
    List<CourseSchedule> getCourseSchedulesByClassId(String classId);

    // 根据教师姓名查询该教师的课程表信息
    List<CourseSchedule> getCourseSchedulesByTeacherId(String teacherId);

    // 根据时间查询课程表信息
    List<CourseSchedule> getCourseSchedulesByTime(String time);
}
