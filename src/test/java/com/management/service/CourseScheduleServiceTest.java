package com.management.service;

import com.management.mapper.ClassesMapper;
import com.management.mapper.TeacherMapper;
import com.management.pojo.CourseSchedule;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class CourseScheduleServiceTest extends TestCase {

    @Autowired
    private CourseScheduleService courseScheduleService;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    ClassesMapper classesMapper;


    @Test
    public void testAddCourseSchedule() {

        CourseSchedule courseSchedule = new CourseSchedule();

        courseSchedule.setCourseId("0001");
        courseSchedule.setTeacherId("0001");
        courseSchedule.setClassId("0000");
        courseSchedule.setLocation("教学楼");
        courseSchedule.setTeacher(teacherMapper.getTeacherByTeacherId("0001"));
        courseSchedule.setCourseInfo(null);
        courseSchedule.setClasses(classesMapper.getClassesById("0000"));
        courseSchedule.setStartTime(1);
        courseSchedule.setEndTime(2);

        courseScheduleService.addCourseSchedule(courseSchedule, "admin");

    }

    public void testDeleteCourseSchedule() {
    }

    public void testUpdateCourseSchedule() {
    }

    public void testGetCourseSchedule() {
    }
}