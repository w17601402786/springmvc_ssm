package com.management.controller;

import com.management.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/admin")
@Api(tags = "管理员控制器",value = "只接受管理员的请求")
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

    @ApiOperation("根据用户id删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true)
    })
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteUserById(Integer id){

        Map<String,Object> resultMap = new HashMap<>();
        //返回json对象
        resultMap.put("code",200);

        return resultMap;

    }


}
