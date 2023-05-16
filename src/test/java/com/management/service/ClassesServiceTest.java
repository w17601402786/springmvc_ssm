package com.management.service;

import com.management.pojo.Classes;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class ClassesServiceTest extends TestCase {


    @Autowired
    private ClassesService classesService;

    @Test
    public void testAddClasses() {

        Classes classes = new Classes();
        classes.setName("软件工程");
        classes.setMajor("软件工程");
        classes.setCounsellor("王宇哲");
        classes.setYear(2018);
        classes.setNum(60);

        int result = classesService.addClasses(classes, "admin");
        System.out.println(result);

    }

    @Test
    public void testUpdateClasses() {

        Classes classes = new Classes();
        classes.setId(3);
        classes.setName("1111");
        classes.setMajor("111");
        classes.setCounsellor("qqqq");
        classes.setYear(2018);
        classes.setNum(60);

        classesService.updateClasses(classes, "admin");



    }

    @Test
    public void testDeleteClassesById() {

        classesService.deleteClassesById(3, "admin");

    }

    @Test
    public void testGetClasses() {
        List<Classes> classes = classesService.getClasses(null);


        classes.forEach(System.out::println);


    }
}