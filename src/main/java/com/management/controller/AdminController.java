package com.management.controller;

import com.management.pojo.Users;
import com.management.service.UsersService;
import com.management.tools.ResultCommon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
@Tag(name = "管理员控制器", description = "只接受管理员的请求")
public class AdminController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    UsersService usersService;

    @PostMapping("Users/add")
    @Operation(summary = "添加用户")
    @Parameters({
            @Parameter(name = "username", description = "用户名", required = true, schema = @Schema(type = "string")),
            @Parameter(name = "password", description = "密码", required = true, schema = @Schema(type = "string")),
            @Parameter(name = "userType", description = "角色", required = true, schema = @Schema(type = "string"))
    })
    public ResultCommon<Users> addUser(Users user) {

        // 存储查询所需信息
        Users newUser = new Users();
        newUser.setUsername(user.getUsername());

        // 首先判断该用户是否已经存在，如果存在，则返回错误信息
        if (usersService.getUsers(user, "admin") != null) {
            return new ResultCommon<>(400, "该用户已存在");
        }

        switch (user.getUserType()) {
            case "admin":
                user.setStudentInfo(null);
                user.setTeacherInfo(null);
                break;
            case "teacher":
                user.setStudentInfo(null);

                if (user.getTeacherInfo() == null || user.getTeacherInfo().isEmpty()) {
                    return new ResultCommon<>(404, "必要参数缺少");
                }


            case "student":
                user.setTeacherInfo(null);

                if (user.getStudentInfo() == null || user.getStudentInfo().isEmpty()) {
                    return new ResultCommon<>(404, "必要参数缺少");
                }

        }
        return null;
    }

    @PostMapping("/user/delete")
    @Operation(summary = "根据用户id删除用户信息")
    @Parameter(name = "id", description = "用户ID", required = true)
    public ResultCommon<String> deleteUserById(@Parameter Integer id) {

        // TODO 删除用户

        return new ResultCommon<>(200, "删除成功");
    }
}
