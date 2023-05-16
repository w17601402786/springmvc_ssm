package com.management.service;

import com.management.pojo.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class StudentServiceTest extends TestCase {

    @Autowired
    StudentService studentService;


    public void testGetAllStudents() {
    }

    public void testGetStudents() {
    }

    public void testAddStudent() {
    }

    @Test
    public void testDeleteStudentByUserId() {
        Student student = studentService.getStudentByUserId(4);
        System.out.println(student.getName());
    }

    public void testUpdateStudent() {
    }

    @Test
    public void testGetStudentByStudentId() {
        Student student = studentService.getStudentByStudentId("101");
        System.out.println(student.getName());
    }

    @Test
    public void testGetStudentByName() {
        Student student = studentService.getStudentByName("张三");
        System.out.println(student);
    }

    public void testGetStudentByClassInfo() {
    }

    public void testGetStudentByMajor() {
    }

    public void testGetClassInfo() {
    }

    public void testGetStudentByUserId() {
    }

    public void testGetCourses() {
    }

    public void testGetCourseSchedule() {
    }

    public void testGetGrades() {
    }
}