package com.management.service.impl;

import com.management.mapper.CourseScheduleMapper;
import com.management.pojo.CourseSchedule;
import com.management.service.CourseScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
@Transactional
public class CourseScheduleServiceImpl implements CourseScheduleService {


    @Autowired
    CourseScheduleMapper courseScheduleMapper;


    @Override
    public int addCourseSchedules(List<CourseSchedule> courseSchedule, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        return courseScheduleMapper.addCourseSchedules(courseSchedule);
    }

    @Override
    public int addCourseSchedule(CourseSchedule courseSchedule, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        return courseScheduleMapper.addCourseSchedule(courseSchedule);

    }

    @Override
    public int deleteCourseSchedule(int id, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        return courseScheduleMapper.deleteCourseScheduleById(id);
    }

    @Override
    public int updateCourseSchedule(CourseSchedule courseSchedule, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        return courseScheduleMapper.updateCourseSchedule(courseSchedule);
    }

    @Override
    public List<CourseSchedule> getCourseSchedule(CourseSchedule courseSchedule, String userType) {

        //TODO 添加权限判断


        return courseScheduleMapper.getCourseSchedules(courseSchedule);
    }

}
