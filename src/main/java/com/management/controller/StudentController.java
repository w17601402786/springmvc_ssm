package com.management.controller;

import com.management.pojo.*;
import com.management.service.ClassesService;
import com.management.service.CourseScheduleService;
import com.management.service.CourseService;
import com.management.tools.ResultCommon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
@Api(tags = "学生控制器",value = "主要实现学生允许的操作")
public class StudentController {




    @Autowired
    HttpServletRequest request;

    @Autowired
    ClassesService classesService;

    @Autowired
    CourseService courseService;

    @Autowired
    CourseScheduleService courseScheduleService;



    @ApiOperation("学生查看自己的信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 401,message = "未登录")
    })
    @RequestMapping( value = "/info",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<Users> info(){
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null){
            return new ResultCommon<>(401,"未登录",null);
        }
        return new ResultCommon<>(200,"成功", user);
    }

    @ApiOperation("学生查看自己班级基本信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 401,message = "未登录")
    })
    @RequestMapping( value = "/classInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<Classes> classInfo(){
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null){
            return new ResultCommon<>(401,"未登录",null);
        }


        // 如果已经有了班级信息，直接返回
        if (user.getStudentInfo()!=null && user.getStudentInfo().getClasses()!=null){
            return new ResultCommon<>(200,"成功", user.getStudentInfo().getClasses());
        }


        Classes classes = new Classes();
        classes.setClassId(user.getStudentInfo().getClassId());

        List<Classes> classesList = classesService.getClasses(classes);


        if (classesList.size() == 0){
            return new ResultCommon<>(401,"获取失败",null);
        }


        Student student = user.getStudentInfo();

        student.setClasses(classesList.get(0));

        user.setStudentInfo(student);

        request.getSession().setAttribute("user",user);

        return new ResultCommon<>(200,"成功", classesList.get(0));
    }

    @ApiOperation("学生查看自己课程信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 401,message = "未登录")
    })
    @RequestMapping( value = "/courseInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<Course>> courseInfo() {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        Classes myClass;

        // 先尝试获取自己的班级信息
        if (user.getStudentInfo()!=null && user.getStudentInfo().getClasses()!=null){
            myClass = user.getStudentInfo().getClasses();
        }else {
            Classes classes = new Classes();
            classes.setClassId(user.getStudentInfo().getClassId());

            List<Classes> classesList = classesService.getClasses(classes);

            if (classesList.size() == 0){
                return new ResultCommon<>(401,"获取失败",null);
            }

            myClass = classesList.get(0);
        }

        //再获取当前班级的课程表信息
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setClassId(myClass.getClassId());

        List<CourseSchedule> courseScheduleList = courseScheduleService.getCourseSchedule(courseSchedule, user.getUserType());

        if (courseScheduleList.size() == 0){
            return new ResultCommon<>(401,"获取失败",null);
        }

        // 最后获取课程信息
        List<Course> courseList = new ArrayList<>();

        courseScheduleList.forEach(courseSchedule1 -> {
            courseList.add(courseSchedule1.getCourseInfo());
        });


        return new ResultCommon<>(200, "成功", courseList);

    }


}
