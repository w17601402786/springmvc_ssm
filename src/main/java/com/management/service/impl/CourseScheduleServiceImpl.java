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
    public int addCourseSchedule(CourseSchedule courseSchedule, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        return courseScheduleMapper.addCourseSchedule(courseSchedule);
    }

    @Override
    public int deleteCourseSchedule(int id, String userType) {
        return 0;
    }

    @Override
    public int updateCourseSchedule(CourseSchedule courseSchedule, String userType) {
        return 0;
    }

    @Override
    public List<CourseSchedule> getCourseSchedule(CourseSchedule courseSchedule, String userType) {
        return null;
    }
}
