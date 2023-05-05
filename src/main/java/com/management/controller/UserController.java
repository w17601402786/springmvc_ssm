package com.management.controller;

import com.management.pojo.Users;
import com.management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@CrossOrigin  //在服务器端支持跨域访问
@RestController  //如果本类中全部都是ajax请求,则使用此注解,方法上的@ResponseBody可不写
@RequestMapping("/user")
public class UserController {

    //切记切记:一定会有业务逻辑层的对象
    @Autowired
    UsersService userService;

    public static final int PAGE_SIZE = 5;

    //user/selectUserPage?userName=z&userSex=男&page=null
    @RequestMapping(value = "/selectUserPage")
    public List<Users> selectUserPage(String userName, String userSex, Integer page){
        //根据页码计算起始行
        int startRow = 0;
        if(page != null){
            startRow = (page-1) * PAGE_SIZE;
        }

//        List<Users> users = userService.selectUserPage(userName,userSex,startRow);

        List<Users> users = new ArrayList<>();

        return users;
    }
    ///user/getRowCount?userName=z&userSex=男
    @RequestMapping("/getRowCount")

    public int getRowCount(String userName,String userSex){
//        return userService.getRowCount(userName,userSex);

        return 0;

    }
    ///user/deleteUserById?userId= 15968162087363060
    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId){
//        return userService.deleteUserById(userId);

        return 0;

    }
    ///user/createUser(参数见下面)
    @RequestMapping("/createUser")
    public int createUser(Users user){

        return userService.addUser(user);
    }
}
