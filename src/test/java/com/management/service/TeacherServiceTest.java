package com.management.service;

import com.management.pojo.Course;
import com.management.pojo.CourseSchedule;
import com.management.pojo.Grade;
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
public class TeacherServiceTest extends TestCase {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void testGetTeacherById() {
        Teacher teacher = teacherService.getTeacherById(1);
        System.out.println(teacher.getName());
    }

    @Test
    public void testGetTeacherByTeacherID() {
        Teacher teacher = teacherService.getTeacherByTeacherID("t001");
        System.out.println(teacher);
    }

    @Test
    public void testUpdateTeacher() {
        Teacher teacher = teacherService.getTeacherById(1);

        System.out.println(teacher);
        teacher.setName("王宇哲");
        int result = teacherService.updateTeacher(teacher);
        System.out.println("更新结果：" + result);
    }

//    @Test
//    public void testGetCourse() {
//        List<Course> courseList = teacherService.getCourse("t001");
//        for (Course course : courseList) {
//            System.out.println(course.getName());
//        }
//    }

    @Test
    public void testGetGradeCalendar() {
        List<CourseSchedule> scheduleList = teacherService.getGradeCalendar("1001");
        for (CourseSchedule schedule : scheduleList) {
            System.out.println(schedule);
        }
    }

    @Test
    public void testGetGrade() {
        List<Grade> gradeList = teacherService.getGrade("1001");
        for (Grade grade : gradeList) {
            System.out.println(grade);
        }
    }

    @Test
    public void testSubmitGrade() {
        int result = teacherService.submitGrade("2001", "1", 80);
        System.out.println("提交结果：" + result);
    }
}