package com.management.service.impl;

import com.management.mapper.CourseMapper;
import com.management.pojo.Course;
import com.management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public int addCourse(Course course, String userType) {

        if (!userType.equals("admin")){
            return 0;
        }

        return courseMapper.addCourse(course);
    }

    @Override
    public int updateCourse(Course course, String userType) {

        if (!userType.equals("admin")){
            return 0;
        }

        return courseMapper.updateCourse(course);
    }

    @Override
    public int deleteCourseById(Integer id, String userType) {

        if (!userType.equals("admin")){
            return 0;
        }
        return courseMapper.deleteCourseById(id);
    }

    @Override
    public List<Course> getCourse(Course course, String userType) {
        //TODO 权限控制
        return courseMapper.getCourses(course);
    }
}
