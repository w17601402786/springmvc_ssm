package com.management.mapper;

import com.management.pojo.Course;

import java.util.List;

public interface CourseMapper {
    // 增加一门课程信息
    int addCourse(Course course);

    // 删除一门课程信息
    int deleteCourseById(Integer id);

    // 修改一门课程信息
    int updateCourse(Course course);

    // 查询所有课程信息
    List<Course> getAllCourses();

    // 根据id查询一门课程信息
    Course getCourseById(Integer id);

    // 根据课程号查询一门课程信息
    Course getCourseByCourseId(String courseId);
}
