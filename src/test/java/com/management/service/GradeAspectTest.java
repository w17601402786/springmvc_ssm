package com.management.service;

import com.management.pojo.Grade;
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
public class GradeAspectTest extends TestCase {

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
}