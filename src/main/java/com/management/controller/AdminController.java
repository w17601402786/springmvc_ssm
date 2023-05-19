package com.management.controller;

import com.management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UsersService usersService;

//    @RequestMapping("/user/add")
//    public int addUser(Users user, HttpServletRequest request){
//
//        if (user.getUsername() == null || user.getUsername().equals("")){
//            return 402;
//        }
//
//        if (user.getPassword() == null || user.getPassword().equals("")){
//            return 402;
//        }
//
//        Users currentUser = (Users) request.getSession().getAttribute("user");
//
//
//        usersService.addUser(user, currentUser.getUserType());
//
//        //返回明文
//        return 200;
//
//    }

    @RequestMapping("/user/delete")
    public Map<String,Object> deleteUserById(){

        Map<String,Object> resultMap = new HashMap<>();
        //返回json对象
        resultMap.put("code",200);

        return resultMap;

    }


}
