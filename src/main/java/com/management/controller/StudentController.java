package com.management.controller;

import com.management.pojo.*;
import com.management.service.*;
import com.management.tools.ResultCommon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
@Tag(name = "学生控制器",description = "主要实现学生允许的操作")
public class StudentController {




    @Autowired
    HttpServletRequest request;

    @Autowired
    ClassesService classesService;

    @Autowired
    CourseService courseService;

    @Autowired
    CourseScheduleService courseScheduleService;

    @Autowired
    StudentService studentService;

    @Autowired
    UsersService usersService;



    @Operation(description = "学生查看自己的信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录")
    })
    @RequestMapping( value = "/info",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<Users> info(){
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null){
            return new ResultCommon<>(401,"未登录",null);
        }
        return new ResultCommon<>(200,"成功", user);
    }

    @Operation(description = "学生查看自己班级基本信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录")
    })
    @RequestMapping( value = "/classInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<Classes> classInfo(){
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null){
            return new ResultCommon<>(401,"未登录",null);
        }


        //获取当前用户班级信息
        Classes classes = studentService.getClasses(user);

        Student student = user.getStudentInfo();
        student.setClasses(classes);

        user.setStudentInfo(student);

        request.getSession().setAttribute("user",user);

        return new ResultCommon<>(200,"成功", classes);
    }

    @Operation(description = "学生查看自己课程信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录")
    })
    @RequestMapping( value = "/courseInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<Course>> courseInfo() {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        List<Course> courseList = studentService.getCourses(user);

        return new ResultCommon<>(200, "成功", courseList);

    }

    @Operation(description = "学生查看自己课程表信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录")
    })
    @RequestMapping( value = "/courseScheduleInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<CourseSchedule>> courseScheduleInfo() {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        List<CourseSchedule> courseScheduleList = studentService.getCourseSchedule(user);

        return new ResultCommon<>(200, "成功", courseScheduleList);

    }

    @Operation(description = "学生查看自己的成绩信息")
    @ApiResponses(value = {

            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录")
    })
    @RequestMapping( value = "/scoreInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<Grade>> scoreInfo() {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        List<Grade> scoreList = studentService.getGrades(user.getId());

        return new ResultCommon<>(200, "成功", scoreList);

    }


    @Operation(description = "修改登录密码")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "402",description = "原密码错误"),
            @ApiResponse(responseCode = "403",description = "修改失败")
    })
    @RequestMapping( value = "/updatePassword",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public ResultCommon<String> updatePassword(
            @Parameter(description = "原密码", required = true) @RequestParam String oldPassword,
            @Parameter(description = "新密码", required = true) @RequestParam String newPassword
    ) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        if (!user.getPassword().equals(oldPassword)){
            return new ResultCommon<>(402, "原密码错误", null);
        }

        user.setPassword(newPassword);


        int result  = usersService.updatePassword(user);


        if (result == 0){
            return new ResultCommon<>(403, "修改失败", null);
        }

        return new ResultCommon<>(200, "成功", null);

    }


}
