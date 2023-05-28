package com.management.controller;


import com.management.pojo.*;
import com.management.service.CourseScheduleService;
import com.management.service.GradeService;
import com.management.service.TeacherService;
import com.management.tools.ResultCommon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/teacher")
@CrossOrigin
@Tag(name= "教师控制器",description = "主要实现教师允许的操作")
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

    @Operation(summary = "教师查看自己的信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @GetMapping(value = "/info", produces = "application/json")
    public ResultCommon<Users> info() {

        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }
        return new ResultCommon<>(200, "成功", user);
    }

    @Operation(summary = "教师查看自己课程信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @GetMapping(value = "/courseInfo", produces = "application/json;charset=utf-8")
    public ResultCommon<List<Course>> courseInfo() {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        List<Course> courseList = teacherService.getCourses(user.getTeacherInfo().getTeacherId());

        return new ResultCommon<>(200, "成功", courseList);

    }

    @Operation(summary = "教师查看自己课程的课表信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @GetMapping(value = "/courseScheduleInfo", produces = "application/json;charset=utf-8")
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

    @Operation(summary = "教师查看自己所授课程的成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @GetMapping(value = "/gradeInfo", produces = "application/json;charset=utf-8")
    public ResultCommon<List<Grade>> gradeInfo(
            @Parameter(description = "课程编号", required = true)
            @RequestParam String courseId) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        Grade grade = new Grade();
        grade.setCourseId(courseId);

        //TODO 记得加个判断，即只能查看自己的课程的成绩

        List<Grade> gradeList = gradeService.getGradesByTeacher(grade, user,"teacher");

        return new ResultCommon<>(200, "成功", gradeList);
    }

    //TODO 查看自己所授课班级的学生
    @Operation(summary = "教师查看自己所授课程的学生信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "400", description = "失败"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @PostMapping(value = "/getStudents", produces = "application/json;charset=utf-8")
    public ResultCommon<List<Student>> getStudents(
            @Parameter(description = "课程编号", required = true)
            @RequestParam String courseId) {

        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }


        List<Student> result = teacherService.getStudentsByCourseId(courseId,user.getTeacherInfo().getTeacherId());

        return new ResultCommon<>(200, "成功",result);
    }


    @Operation(summary = "教师提交自己所授课程的成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "400", description = "失败"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @PostMapping(value = "/addGrade", produces = "application/json;charset=utf-8")
    public ResultCommon<String> addGrade(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "成绩信息", required = true)
            @RequestBody
            Grade grade) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        //打印info级别的日志
        log.info("grade:{}", grade);

        List<Grade> gradeList = new ArrayList<>();
        gradeList.add(grade);

        int result = gradeService.addGradesByTeacher(gradeList, user.getUserType());

        if (result == 0) {
            return new ResultCommon<>(400, "失败", null);
        }

        return new ResultCommon<>(200, "成功");
    }

    @Operation(summary = "教师批量提交自己所授课程的成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @PostMapping(value = "/addGrades", produces = "application/json;charset=utf-8")
    public ResultCommon<String> addGrades(
            @Parameter(description = "成绩信息列表", required = true)
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(mediaType = "application/json",array = @ArraySchema(
                            schema = @Schema(implementation = Grade.class)
                    ))
            })
            @RequestBody
            List<Grade> grades
    ) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        int result = gradeService.addGradesByTeacher(grades, user.getUserType());

        if (result == 0) {
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
