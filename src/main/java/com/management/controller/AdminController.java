package com.management.controller;

import com.management.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/admin")
@Api(tags = "管理员控制器",value = "只接受管理员的请求")
public class AdminController {

    @Autowired
    UsersService usersService;

    @ApiOperation("根据用户id删除用户信息")
    @ApiImplicitParam(name = "id",value = "用户ID")
    @RequestMapping("/user/delete")
    public Map<String,Object> deleteUserById(Integer id){

        Map<String,Object> resultMap = new HashMap<>();
        //返回json对象
        resultMap.put("code",200);

        return resultMap;

    }


}
