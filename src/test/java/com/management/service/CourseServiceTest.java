package com.management.service;

import com.management.pojo.Course;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class CourseServiceTest extends TestCase {

    @Autowired
    CourseService courseService;

    @Test
    public void testAddCourse() {

        Course course = new Course();
        course.setCourseId("1004");
        course.setName("测试课程");
        course.setCredit(2);
        course.setHours(32);

        int result = courseService.addCourse(course,"admin");

        System.out.println(result);

        System.out.println(course);

    }

    @Test
    public void testUpdateCourse() {

        Course course = new Course();
        course.setCourseId("1003");
        course.setName("测试课2222程");
        course.setCredit(200);
        course.setHours(3200);

        int result = courseService.updateCourse(course,"admin");

        System.out.println(result);

    }

    @Test
    public void testDeleteCourseById() {

        System.out.println(
                courseService.deleteCourseById(3,"admin")
        );

    }

    @Test
    public void testGetCourse() {

        Course course = new Course();
        course.setName("学");

        List<Course> courseList = courseService.getCourse(course,"admin");

        courseList.forEach(System.out::println);

    }
}