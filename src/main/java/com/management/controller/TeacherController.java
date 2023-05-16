package com.management.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.management.pojo.CourseSchedule;
import com.management.pojo.Grade;
import com.management.pojo.Teacher;
import com.management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mysql.cj.MysqlType.JSON;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /*
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
     * @param teacherName 教师姓名
     * @return 课程表信息（JSON字符串）
     */
    @GetMapping("/{teacherId}/courseSchedules")
    @ResponseBody
    public String getCourseSchedulesByTeacherId(@PathVariable String teacherId) {
        List<CourseSchedule> courseSchedules = teacherService.getCourse(teacherId);
        return JSON.toString();
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
