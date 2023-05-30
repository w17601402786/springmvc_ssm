package com.management.mapper;

import com.management.pojo.CourseSchedule;
import org.springframework.web.bind.annotation.PathVariable;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface CourseScheduleMapper {
    /**
     * 添加一条课程表信息
     * @param courseSchedule 课程表信息
     * @return 添加结果
     */
    int addCourseSchedule(CourseSchedule courseSchedule);

    /**
     * 通过课程表id删除一条课程表信息
     * @param id 课程表id
     * @return 删除结果
     */
    @Delete("delete from course_schedule where id=#{id}")
    int deleteCourseScheduleById(Integer id);

    /**
     * 修改一条课程表信息
     * <p color="yellow">
     *  调课不需要改课程信息、教师信息、班级信息，只需要改时间、地点
     * </p>
     * @param courseSchedule 修改后的课程表信息
     * @return 修改结果
     */
    int updateCourseSchedule(CourseSchedule courseSchedule);

    /**
     * 查询课程表信息
     * @param courseSchedule 课程表信息
     * @return 课程表信息
     */
    List<CourseSchedule> getCourseSchedules(CourseSchedule courseSchedule);

    /**
     * 查询课程表信息(按照或条件)
     * @param courseSchedule 课程表信息
     * @return 课程表信息
     */
    List<CourseSchedule> getCourseSchedulesOr(CourseSchedule courseSchedule);
    /**
     * 批量添加一条课程表信息
     * @param courseSchedule 课程表信息
     * @return 添加结果
     */
    int addCourseSchedules(List<CourseSchedule> courseSchedule);

    List<CourseSchedule> getAllLocations();

}
