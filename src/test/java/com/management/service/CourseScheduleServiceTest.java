package com.management.service;

import com.management.mapper.ClassesMapper;
import com.management.mapper.TeacherMapper;
import com.management.pojo.CourseSchedule;
import com.management.pojo.Teacher;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        courseSchedule.setWeek(1);
        courseSchedule.setDay(1);

        courseScheduleService.addCourseSchedule(courseSchedule, "admin");

    }

    @Test
    public void testDeleteCourseSchedule() {

        courseScheduleService.deleteCourseSchedule(5, "admin");

    }

    @Test
    public void testUpdateCourseSchedule() {

        CourseSchedule courseSchedule = new CourseSchedule();

        courseSchedule.setId(1);
        courseSchedule.setCourseId("0001");
        courseSchedule.setTeacherId("0001");
        courseSchedule.setClassId("0000");
        courseSchedule.setLocation("教学楼");
        courseSchedule.setTeacher(teacherMapper.getTeacherByTeacherId("0001"));
        courseSchedule.setCourseInfo(null);
        courseSchedule.setClasses(classesMapper.getClassesById("0000"));
        courseSchedule.setStartTime(1);
        courseSchedule.setEndTime(2);
        courseSchedule.setWeek(1);

        courseScheduleService.updateCourseSchedule(courseSchedule, "admin");

    }

    @Test
    public void testGetCourseSchedule() {

        CourseSchedule courseSchedule = new CourseSchedule();

        Teacher teacher = new Teacher();
        teacher.setName("王");

        courseSchedule.setTeacher(teacher);

        List<CourseSchedule> courseSchedules = courseScheduleService.getCourseSchedule(courseSchedule, "admin");

        System.out.println("courseSchedules.size() = " + courseSchedules.size());

        courseSchedules.forEach(System.out::println);

    }
}