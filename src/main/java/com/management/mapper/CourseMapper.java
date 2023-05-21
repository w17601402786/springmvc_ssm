package com.management.mapper;

import com.management.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    /**
     * 添加一门课程信息
     * @param course 课程信息
     * @return 添加后的主键id
     */
    int addCourse(Course course);

    /**
     * 根据id删除一门课程信息
     * @param id 课程id
     * @return 删除结果
     */
    int deleteCourseById(@Param("id") Integer id);

    /**
     * 更新一门课程信息
     * @param course 课程信息
     * @return 更新结果
     */
    int updateCourse(Course course);

    /**
     * 根据课程号查询课程信息
     * @return 课程信息列表
     */
    List<Course> getCourses(Course course);

}
