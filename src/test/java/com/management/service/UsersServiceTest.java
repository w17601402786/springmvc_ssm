package com.management.service;

import com.management.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class UsersServiceTest{


    @Autowired
    UsersService usersService;

    @Test
    public void testGetUserById() {

        Users user = usersService.getUserById(1);

        System.out.println(user);

    }

    @Test
    public void testAddUser() {

        Users users = new Users();

        users.setUsername("qqq");
        users.setPassword("q111");
        users.setUserType("admin");

        usersService.addUser(users,"admin");

    }

    @Test
    public void testUpdateUser() {


        Users users = new Users();

        users.setId(1);
        users.setPassword("123456");
        users.setUserType("student");

        usersService.updateUser(users,"admin");

    }

    @Test
    public void testDeleteUserById() {
        usersService.deleteUserById(1,"admin");
    }

    @Test
    public void testGetAllUsers() {
        List<Users> users = usersService.getAllUsers("admin");
        users.forEach(System.out::println);
    }

    @Test
    public void testGetUsers() {

        Users user = new Users();

        user.setUserType("admin");

        List<Users> users = usersService.getUsers(user,"admin");

        users.forEach(System.out::println);
    }


    @Test
    public void testGetStudentUsers(){

        Users user = new Users();

        List<Users> users = usersService.getStudentUsers(user,"admin");

        users.forEach(System.out::println);

    }


    @Test
    public void testGetTeacherUsers(){

        Users user = new Users();

        List<Users> users = usersService.getTeacherUsers(user,"admin");

        users.forEach(System.out::println);

    }

}