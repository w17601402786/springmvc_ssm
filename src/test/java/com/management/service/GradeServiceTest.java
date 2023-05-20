package com.management.service;

import com.management.pojo.Grade;
import com.management.pojo.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {
        "classpath:applicationContext_service.xml",
        "classpath:applicationContext_mapper.xml"
})
public class GradeServiceTest extends TestCase {

    @Autowired
    GradeService gradeService;


    public void testAddGradeByAdmin() {
    }

    public void testAddGradeByTeacher() {
    }

    public void testDeleteGrade() {
    }

    public void testUpdateGrade() {
    }

    @Test
    public void testGetGrades() {

        Grade grade = new Grade();

        List<Grade> grades = gradeService.getGrades(grade,"admin");

        grades.forEach(System.out::println);


    }

    @Test
    public void testGetGradesByScoreRange(){

        Grade grade = new Grade();


        Student student = new Student();

        student.setName("王");

        grade.setStudentInfo(student);

        List<Grade> grades = gradeService.getGradesByScoreRange(grade, 0, 86, "admin");

        grades.forEach(System.out::println);


    }

}