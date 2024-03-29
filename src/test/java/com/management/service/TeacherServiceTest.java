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

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class TeacherServiceTest extends TestCase {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseScheduleService courseScheduleService;

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

    @Test
    public void testGetCourse() {
        List<Course> courseList = teacherService.getCourses("t001");
        for (Course course : courseList) {
            System.out.println(course.getName());
        }
    }

    @Test
    public void testGetGrade() {
        List<Grade> gradeList = teacherService.getGrade("t001");
        for (Grade grade : gradeList) {
            System.out.println(grade);
        }
    }


    @Test
    public void testGetTeacherByUserId(){
        Teacher teacher = teacherService.getTeacherByUserId(3);
        System.out.println(teacher);
    }

    @Test
    public void testGetAllTeachers(){
        List<Teacher> teacherList = teacherService.getAllTeachers("admin");
        teacherList.forEach(System.out::println);
    }

    @Test
    public void testGetTeachers(){
        Teacher teacher = new Teacher();


        List<Teacher> teacherList = teacherService.getTeachers(teacher,"admin");
        teacherList.forEach(System.out::println);
    }

    @Test
    public void testAddTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("赵老师");
        teacher.setGender("男");
        teacher.setBirthday(Date.from(Instant.ofEpochSecond(1990-01-01)));
        teacher.setFaculty("软件工程");
        teacher.setTeacherId("t002");
        teacher.setPhone(null);
        teacher.setUserId(2);
        teacherService.addTeacher(teacher,"teacher");
    }

    @Test
    public void testDeleteTeacher(){
        teacherService.deleteTeacherByUserId(2,"teacher");
    }
}