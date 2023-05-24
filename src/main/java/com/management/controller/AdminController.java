package com.management.controller;

import com.management.pojo.Grade;
import com.management.pojo.Users;
import com.management.service.UsersService;
import com.management.tools.ResultCommon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/admin")
@Tag(name = "管理员控制器", description = "只接受管理员的请求")
public class AdminController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    UsersService usersService;

    @Operation(summary = "添加用户")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping(value = "/users/add",produces = "application/json")
    public ResultCommon<Users> addUser(
            @Parameter(description = "要添加的用户信息", required = true)
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class)
                    )
            })
            @RequestBody Users user
    ) {

        // 存储查询所需信息
        Users newUser = new Users();
        newUser.setUsername(user.getUsername());

        // 首先判断该用户是否已经存在，如果存在，则返回错误信息
        if (usersService.getUsers(newUser, "admin").size() != 0) {
            return new ResultCommon<>(400, "该用户已存在");
        }

        log.info("user: {}", user);


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
                break;
            case "student":
                user.setTeacherInfo(null);

                if (user.getStudentInfo() == null || user.getStudentInfo().isEmpty()) {
                    return new ResultCommon<>(404, "必要参数缺少");
                }
                break;
            default:
                return new ResultCommon<>(404, "必要参数缺少或者错误");
        }


        int result = usersService.addUser(user,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "添加失败");
        }
        return new ResultCommon<>(200, "添加成功");
    }

    @PostMapping("/user/delete")
    @Operation(summary = "根据用户id删除用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })

    public ResultCommon<String> deleteUserById(
            @Parameter(name = "id", description = "用户ID", required = true)
            Integer id
    ) {

        int result = usersService.deleteUserById(id,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "删除失败,可能是用户不存在");
        }

        return new ResultCommon<>(200, "删除成功");
    }
}
