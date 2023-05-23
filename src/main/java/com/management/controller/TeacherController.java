package com.management.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.management.pojo.*;
import com.management.service.CourseScheduleService;
import com.management.service.GradeService;
import com.management.service.TeacherService;
import com.management.tools.ApiCollection;
import com.management.tools.ResultCommon;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.extensions.Extensions;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static com.mysql.cj.MysqlType.JSON;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
@Api(tags = "教师控制器",value = "主要实现教师允许的操作")
public class TeacherController {


    /**
     * 用于获取session中的用户信息
     */
    @Autowired
    HttpServletRequest request;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseScheduleService courseScheduleService;

    @Autowired
    private GradeService gradeService;

    @ApiOperation("教师查看自己的信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 401,message = "未登录")
    })
    @RequestMapping(value = "/info",produces = "application/json",method = RequestMethod.GET)
    public ResultCommon<Users> info(){

        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null){
            return new ResultCommon<>(401,"未登录",null);
        }
        return new ResultCommon<>(200,"成功", user);
    }

    @ApiOperation("教师查看自己课程信息")
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

        List<Course> courseList = teacherService.getCourses(user.getTeacherInfo().getTeacherId());

        return new ResultCommon<>(200, "成功", courseList);

    }

    @ApiOperation("教师查看自己课程的课表信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 401,message = "未登录")
    })
    @RequestMapping( value = "/courseScheduleInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<CourseSchedule>> courseScheduleInfo() {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }


        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setTeacher(user.getTeacherInfo());

        List<CourseSchedule> courseScheduleList = courseScheduleService.getCourseSchedule(courseSchedule, "teacher");

        return new ResultCommon<>(200, "成功", courseScheduleList);

    }

    @ApiOperation("教师查看自己所授课程的成绩信息")
    @ApiImplicitParam(name = "courseId",value = "课程编号")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 401,message = "未登录")
    })
    @RequestMapping( value = "/gradeInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<Grade>> gradeInfo(String courseId) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        Grade grade = new Grade();
        grade.setCourseId(courseId);

        //记得加个判断，即只能查看自己的课程的成绩
        List<Grade> gradeList = gradeService.getGrades(grade,"teacher");


        return new ResultCommon<>(200, "成功", gradeList);


    }


    @ApiOperation("教师提交自己所授课程的成绩信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 401,message = "未登录")
    })
    @RequestMapping( value = "/addGrade",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public ResultCommon<String> addGrade(Grade grade) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        List<Grade> gradeList = new ArrayList<>();
        gradeList.add(grade);


        int result = gradeService.addGradesByTeacher(gradeList,user.getUserType());

        if (result == 0){
            return new ResultCommon<>(400, "失败", null);
        }

        return new ResultCommon<>(200, "成功");


    }



    @ApiOperation("教师批量提交自己所授课程的成绩信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 401,message = "未登录")
    })
    //TODO List怎么提交啊啊啊啊啊
    @PostMapping( value = "/addGrades",produces = "application/json;charset=utf-8")
    public ResultCommon<String> addGrades(
            ApiCollection<Grade> grades
    ) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        int result = gradeService.addGradesByTeacher(grades.getData(),user.getUserType());

        if (result == 0){
            return new ResultCommon<>(400, "失败", null);
        }

        return new ResultCommon<>(200, "成功");
    }



//
//
//    /**
//      根据教师编号获取教师信息
//      @param id 教师编号
//      @return 教师信息（JSON字符串）
//     */
//    @GetMapping("/{id}")
//    @ResponseBody
//    public String getTeacherById(@PathVariable Integer id){
//        Teacher teacher = teacherService.getTeacherById(id);
//        return JSON.toString();
//    }
//    /**
//     * 更新教师信息
//     *
//     * @param teacher 教师信息
//     * @return 更新结果（JSON字符串）
//     */
//    @PutMapping("/update")
//    @ResponseBody
//    public String updateTeacher(@RequestBody Teacher teacher) {
//        Map<String, Object> result = new HashMap<>();
//        int count = teacherService.updateTeacher(teacher);
//        if (count > 0) {
//            result.put("code", "success");
//            result.put("msg", "更新成功");
//        } else {
//            result.put("code", "failure");
//            result.put("msg", "更新失败");
//        }
//        return JSON.toString();
//    }
//
//    /**
//     * 获取指定教师的课程表
//     *
//     * @param teacherId 教师编号
//     * @return 课程表信息（JSON字符串）
//     */
//    @GetMapping("/{teacherId}/courseSchedules")
//    @ResponseBody
//    public List<CourseSchedule> getCourseSchedulesByTeacherId(@PathVariable String teacherId) {
//
//
//        CourseSchedule courseSchedule = new CourseSchedule();
//        courseSchedule.setTeacherId(teacherId);
//
//
//        return courseScheduleService.getCourseSchedule(courseSchedule, "teacher");
//    }
//
//    /**
//     * 获取指定教师的成绩信息
//     *
//     * @param teacherId 教师编号
//     * @return 成绩信息（JSON字符串）
//     */
//    @GetMapping("/{teacherId}/grades")
//    @ResponseBody
//    public String getGradesByTeacherId(@PathVariable String teacherId) {
//        List<Grade> grades = teacherService.getGrade(teacherId);
//        return JSON.toString();
//    }
//
//    /**
//     * 提交学生某门课程的成绩
//     *
//     * @param studentId 学生编号
//     * @param courseId  课程编号
//     * @param score     成绩
//     * @return 提交结果（JSON字符串）
//     */
//    @PostMapping("/submit_grade")
//    @ResponseBody
//    public String submitGrade(@RequestParam String studentId, @RequestParam String courseId, @RequestParam int score) {
//        Map<String, Object> result = new HashMap<>();
//        int count = teacherService.submitGrade(studentId, courseId, score);
//        if (count > 0) {
//            result.put("code", "success");
//            result.put("msg", "成绩提交成功");
//        } else {
//            result.put("code", "failure");
//            result.put("msg", "成绩提交失败");
//        }
//        return JSON.toString();
//    }

}
