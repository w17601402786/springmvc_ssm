package com.management.controller;

import com.management.pojo.Users;
import com.management.service.UsersService;
import com.management.tools.ResultCommon;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin  //在服务器端支持跨域访问
@RestController  //如果本类中全部都是ajax请求,则使用此注解,方法上的@ResponseBody可不写
@Api(tags = "用户控制器",value = "主要实现登录功能")
public class UsersController {

    //切记切记:一定会有业务逻辑层的对象
    @Autowired
    UsersService userService;

    @Autowired
    HttpServletRequest request;

    @ApiOperation(value = "用户登录",notes = "根据用户名和密码登录,登录后将用户信息存入session")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)
    })
    @ApiResponses( value ={
            @ApiResponse(code = 200,message = "登录成功"),
            @ApiResponse(code = 401,message = "用户名或密码错误"),
            @ApiResponse(code = 402,message = "用户名或密码为空")
    })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultCommon<Users> login(Users user){


        if (user.getUsername() == null || user.getUsername().equals("")){
            return new ResultCommon<>(402,"用户名或密码为空");

        }

        if (user.getPassword() == null || user.getPassword().equals("")){

            return new ResultCommon<>(402,"用户名或密码为空");

        }


        //最后请求得到的Users对象，包含其所有信息
        user = userService.login(user);

        if (user == null){

            return new ResultCommon<>(401,"用户名或密码错误");

        }

        //将用户信息存入session
        request.getSession().setAttribute("user",user);


        return new ResultCommon<>(200,"登录成功",user);

    }

}
