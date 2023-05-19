package com.management.service;

import com.management.pojo.Grade;
import com.management.pojo.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class StudentServiceTest extends TestCase {

    @Autowired
    StudentService studentService;


    public void testGetAllStudents() {
    }

    @Test
    public void testGetStudents() {


        Student student = new Student();


        List<Student> studentList = studentService.getStudents(student);

        studentList.forEach(System.out::println);

    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setId(4);
        student.setStudentId("103");
        student.setName("王五");
        student.setGender("男");
        student.setBirthday(Date.from(Instant.ofEpochSecond(2000-03-01)));
        student.setMajor("物联网");
        student.setClassId("1903");
        student.setAddress("湖北武汉");
        student.setPhone(null);
        student.setNote(null);
        student.setUserId(4);
        studentService.addStudent(student,"student");
    }

    @Test
    public void testDeleteStudent(){
        studentService.deleteStudentByUserId(4,"student");
    }

    @Test
    public void testUpdateStudent() {
        Student student = studentService.getStudentByStudentId("101");
        student.setName("王老六");
        int result = studentService.updateStudent(student);
        System.out.println("更新结果：" + result);

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

    @Test
    public void testGetStudentByUserId() {
        Student student = studentService.getStudentByUserId(4);
        System.out.println(student);
    }
    @Test
    public void testGetGradeByStudentId(){
        List<Grade> gradeList = studentService.getGradeByStudentId("101");
        for (Grade grade : gradeList){
            System.out.println(grade);
        }
    }

    public void testGetStudentByClassInfo() {
    }

    public void testGetStudentByMajor() {
    }

    public void testGetClassInfo() {
    }


    public void testGetCourses() {
    }

    public void testGetCourseSchedule() {
    }

    public void testGetGrades() {
    }


}