package com.management.service;

import com.management.pojo.Users;
import com.management.service.impl.StudentServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class UsersServiceTest extends TestCase {


    @Autowired
    UsersService usersService;

    public void testGetUserById() {
    }

    public void testAddUser() {
    }

    public void testUpdateUser() {
    }

    public void testDeleteUserById() {
    }

    public void testGetAllUsers() {
    }

    @Test
    public void testGetUsers() {



        Users user = new Users();

//        user.setUsername("qqq");
//        user.setPassword("q111");
//        user.setUserType("admin");
//
        List<Users> users = usersService.getUsers(user,"admin");

        for (Users u : users) {
            System.out.println(u);
        }
    }


    @Test
    public void testGetStudentUsers(){

        Users user = new Users();

        List<Users> users = usersService.getStudentUsers(user,"admin");

        for (Users u : users) {
            System.out.println(u);
        }

    }

}