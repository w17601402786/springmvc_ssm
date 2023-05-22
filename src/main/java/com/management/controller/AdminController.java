package com.management.controller;

import com.management.pojo.Users;
import com.management.service.UsersService;
import com.management.tools.ResultCommon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/admin")
@Api(tags = "管理员控制器",value = "只接受管理员的请求")
public class AdminController {



    @Autowired
    HttpServletRequest request;

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true),
            @ApiImplicitParam(name = "userType",value = "角色",required = true)
    })
    @RequestMapping("Users/add")
    public ResultCommon<Users> addUser(Users user){

        //存储查询所需信息
        Users newUser = new Users();
        newUser.setUsername(user.getUsername());


        // 首先判断该用户是否已经存在，如果存在，则返回错误信息
        if(usersService.getUsers(user,"admin") != null){
            return new ResultCommon<>(400,"该用户已存在");
        }

        switch (user.getUserType()){
            case "admin":
                user.setStudentInfo(null);
                user.setTeacherInfo(null);
                break;
            case "teacher":
                user.setStudentInfo(null);

                if (user.getTeacherInfo()!=null || user.getTeacherInfo().isEmpty()){
                    return new ResultCommon<>(404,"必要参数缺少");
                }


            case "student":
                user.setTeacherInfo(null);

                if(user.getStudentInfo()!=null || user.getStudentInfo().isEmpty()){
                    return new ResultCommon<>(404,"必要参数缺少");
                }

        }
        // todo 叼毛王宇哲，速写！！
        return null;


    }


    @Autowired
    UsersService usersService;

    @ApiOperation("根据用户id删除用户信息")
    @ApiImplicitParam(name = "id",value = "用户ID")
    @RequestMapping("/user/delete")
    public ResultCommon<String> deleteUserById(Integer id){



        //TODO 删除用户


        return new ResultCommon<>(200,"删除成功");


    }


}
