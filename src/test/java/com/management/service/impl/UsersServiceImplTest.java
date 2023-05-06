package com.management.service.impl;

import com.management.pojo.Users;
import com.management.service.UsersService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class UsersServiceImplTest extends TestCase {


    @Autowired
    UsersService usersService;

    @Test
    public void testAddUser() {

        Users users = new Users();

        users.setUsername("123");
        users.setPassword("123456");
        users.setUserType("admin");

        usersService.addUser(users);

    }

    @Test
    public void testGetUserByUsername() {

        Users users = usersService.getUserByUsername("123");

        System.out.println(users);
    }

    @Test
    public void testUpdateUser() {

        Users users = new Users();



    }

}