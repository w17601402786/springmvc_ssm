package com.management.controller;

import com.management.pojo.Users;
import com.management.service.UsersService;
import com.management.tools.ResultCommon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin  //在服务器端支持跨域访问
@RestController  //如果本类中全部都是ajax请求,则使用此注解,方法上的@ResponseBody可不写
@Tag(name = "用户控制器",description = "主要实现登录功能")
public class UsersController {

    //切记切记:一定会有业务逻辑层的对象
    @Autowired
    UsersService userService;

    @Autowired
    HttpServletRequest request;

    @Operation(summary = "用户登录",description = "根据用户名和密码登录,登录后将用户信息存入session")
    @Parameters({
            @Parameter(name = "username", description = "用户名", required = true),
            @Parameter(name = "password", description = "密码", required = true)
    })
    @ApiResponses( value ={
            @ApiResponse(responseCode = "200",description = "登录成功"),
            @ApiResponse(responseCode = "401",description = "用户名或密码错误"),
            @ApiResponse(responseCode = "402",description = "用户名或密码为空")
    })


    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultCommon<Users> login(
            @Parameter(hidden = true) Users user){


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
