package com.management.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.management.pojo.*;
import com.management.service.CourseScheduleService;
import com.management.service.TeacherService;
import com.management.tools.ResultCommon;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mysql.cj.MysqlType.JSON;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
@ApiOperation(tags = "教师控制器",value = "主要实现教师允许的操作")
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



    /**
      根据教师编号获取教师信息
      @param id 教师编号
      @return 教师信息（JSON字符串）
     */
    @GetMapping("/{id}")
    @ResponseBody
    public String getTeacherById(@PathVariable Integer id){
        Teacher teacher = teacherService.getTeacherById(id);
        return JSON.toString();
    }
    /**
     * 更新教师信息
     *
     * @param teacher 教师信息
     * @return 更新结果（JSON字符串）
     */
    @PutMapping("/update")
    @ResponseBody
    public String updateTeacher(@RequestBody Teacher teacher) {
        Map<String, Object> result = new HashMap<>();
        int count = teacherService.updateTeacher(teacher);
        if (count > 0) {
            result.put("code", "success");
            result.put("msg", "更新成功");
        } else {
            result.put("code", "failure");
            result.put("msg", "更新失败");
        }
        return JSON.toString();
    }

    /**
     * 获取指定教师的课程表
     *
     * @param teacherId 教师编号
     * @return 课程表信息（JSON字符串）
     */
    @GetMapping("/{teacherId}/courseSchedules")
    @ResponseBody
    public List<CourseSchedule> getCourseSchedulesByTeacherId(@PathVariable String teacherId) {


        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setTeacherId(teacherId);


        return courseScheduleService.getCourseSchedule(courseSchedule, "teacher");
    }

    /**
     * 获取指定教师的成绩信息
     *
     * @param teacherId 教师编号
     * @return 成绩信息（JSON字符串）
     */
    @GetMapping("/{teacherId}/grades")
    @ResponseBody
    public String getGradesByTeacherId(@PathVariable String teacherId) {
        List<Grade> grades = teacherService.getGrade(teacherId);
        return JSON.toString();
    }

    /**
     * 提交学生某门课程的成绩
     *
     * @param studentId 学生编号
     * @param courseId  课程编号
     * @param score     成绩
     * @return 提交结果（JSON字符串）
     */
    @PostMapping("/submit_grade")
    @ResponseBody
    public String submitGrade(@RequestParam String studentId, @RequestParam String courseId, @RequestParam int score) {
        Map<String, Object> result = new HashMap<>();
        int count = teacherService.submitGrade(studentId, courseId, score);
        if (count > 0) {
            result.put("code", "success");
            result.put("msg", "成绩提交成功");
        } else {
            result.put("code", "failure");
            result.put("msg", "成绩提交失败");
        }
        return JSON.toString();
    }

}
