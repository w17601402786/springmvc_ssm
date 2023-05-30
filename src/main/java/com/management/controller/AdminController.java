package com.management.controller;

import com.management.mapper.StudentMapper;
import com.management.mapper.TeacherMapper;
import com.management.pojo.*;
import com.management.service.*;
import com.management.tools.ResultCommon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
@RestController
@RequestMapping("/admin")
@Tag(name = "管理员控制器", description = "只接受管理员的请求")
public class AdminController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    UsersService usersService;

    @Autowired
    ClassesService classesService;

    @Autowired
    CourseService courseService;

    @Autowired
    CourseScheduleService courseScheduleService;

    @Autowired
    GradeService gradeService;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    TeacherService teacherService;


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

    @Operation(summary = "根据用户id删除用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @RequestMapping(value = "/users/delete",produces = "application/json",method = RequestMethod.GET)
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


    @Operation(summary = "修改用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/users/update")
    public ResultCommon<String> updateUser(
            @Parameter(description = "要修改的用户信息", required = true)
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class)
                    )
            })
            @RequestBody Users user
    ) {

        int result = usersService.updateUser(user,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "修改失败");
        }

        return new ResultCommon<>(200, "修改成功");

    }



    @Operation(summary = "查询用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/users/getUsers")
    public ResultCommon<List<Users>> getUsers(
            @Parameter(description = "要查询的用户信息", required = true)
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class)
                    )
            })
            @RequestBody Users user
    ) {

        List<Users> users;

        if (user.getUserType() != null && !"".equals(user.getUserType()) ){
            switch (user.getUserType()){
                case "admin":
                    users = usersService.getUsers(user,"admin");
                    break;
                case "student":
                    users = usersService.getStudentUsers(user,"admin");
                    break;
                case "teacher":
                    users = usersService.getTeacherUsers(user,"admin");
                    break;
                default:
                    return new ResultCommon<>(500,"参数错误");
            }

            return new ResultCommon<>(200,"成功",users);

        }

        user.setUserType("admin");
        List<Users> adminUsers = usersService.getUsers(user,"admin");
        user.setUserType("teacher");
        List<Users> teacherUsers = usersService.getTeacherUsers(user,"admin");
        user.setUserType("student");
        List<Users> studentUsers = usersService.getStudentUsers(user,"admin");

        users = Stream.of(adminUsers, teacherUsers, studentUsers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return new ResultCommon<>(200, "查询成功", users);
    }

    @Operation(summary = "根据用户id查询用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/users/getUserById")
    public ResultCommon<Users> getUserById(
            @Parameter(name = "id", description = "用户ID", required = true)
            Integer id,
            @Parameter(name = "userType", description = "用户类型", required = true)
            String userType
    ) {

        Users user = new Users();

        user.setId(id);
        user.setUserType(userType);

        List<Users> users;
        switch (userType){
            case "admin":
                users = usersService.getUsers(user,"admin");
                break;
            case "teacher":
                users = usersService.getTeacherUsers(user,"admin");
                break;
            case "student":
                users = usersService.getStudentUsers(user,"admin");
                break;
            default:
                return new ResultCommon<>(404, "必要参数缺少或者错误");
        }


        if (users.size() == 0){
            return new ResultCommon<>(500, "查询失败");
        }

        return new ResultCommon<>(200, "查询成功", users.get(0));
    }



    @Operation(summary = "添加班级")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/classes/add")
    public ResultCommon<String> addClass(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "要添加的班级信息", required = true
            )
            @RequestBody
            Classes classes
    ){

        int result = classesService.addClasses(classes,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "增加失败");
        }

        return new ResultCommon<>(200, "增加成功");

    }


    @Operation(summary = "根据班级id删除班级信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @RequestMapping(value = "/classes/delete",method = RequestMethod.GET)
    public ResultCommon<String> deleteClassById(
            @Parameter(name = "id", description = "班级ID", required = true)
            Integer id
    ) {

        int result = classesService.deleteClassesById(id,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "删除失败,可能是班级不存在");
        }

        return new ResultCommon<>(200, "删除成功");
    }


    @Operation(summary = "修改班级信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/classes/update")
    public ResultCommon<String> updateClass(
            @Parameter(description = "要修改的班级信息", required = true)
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Classes.class)
                    )
            })
            @RequestBody Classes classes
    ) {

        // 存储查询所需信息
        Classes newClasses = new Classes();
        newClasses.setId(classes.getId());

        List<Classes> classesList = classesService.getClasses(newClasses);

        // 首先判断该班级是否已经存在，如果存在，则返回错误信息
        if (classesList.size() == 0) {
            return new ResultCommon<>(400, "该班级不存在");
        }

        log.info("classes: {}", classes);

        Classes oldClasses = classesList.get(0);

        //TODO 这里还没有进行测试，服务层代码也还没有完善
        int result = classesService.updateClasses(classes,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "修改失败");
        }

        return new ResultCommon<>(200, "修改成功");

    }


    @Operation(summary = "查询班级信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/classes/getClasses")
    public ResultCommon<List<Classes>> getClasses(
            @Parameter(description = "要查询的班级信息", required = true)
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Classes.class)
                    )
            })
            @RequestBody Classes classes
    ) {
        return new ResultCommon<>(200, "查询成功", classesService.getClasses(classes));
    }


    @Operation(summary = "添加课程")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/course/add")
    public ResultCommon<String> addCourse(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "要添加的课程信息", required = true
            )
            @RequestBody
            Course course
    ){
        int result = courseService.addCourse(course,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "添加失败");
        }

        return new ResultCommon<>(200, "添加成功");
    }

    @Operation(summary = "根据课程id删除课程信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @RequestMapping(value = "/course/delete",method = RequestMethod.GET)
    public ResultCommon<String> deleteCourseById(
            @Parameter(name = "id", description = "课程ID", required = true)
            Integer id
    ){
        int result = courseService.deleteCourseById(id,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "删除失败,可能是课程不存在");
        }

        return new ResultCommon<>(200, "删除成功");
    }

    @Operation(summary = "修改课程信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/course/update")
    public ResultCommon<String> updateCourse(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "修改后的课程信息", required = true
            )
            @RequestBody
            Course course
    ){
        int result = courseService.updateCourse(course,"admin");

        if (result == 0){
            return new ResultCommon<>(500, "修改失败");
        }

        return new ResultCommon<>(200, "修改成功");

    }

    @Operation(summary = "查看课程信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/course/getCourses")
    public ResultCommon<List<Course>> getCourses(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "查询条件", required = true
            )
            @RequestBody
            Course course
    ){
        List<Course> courses = courseService.getCourse(course,"admin");

        return new ResultCommon<>(200,"查询成功",courses);
    }


    @Operation(summary = "批量添加课表信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/course_schedule/add")
    public ResultCommon<String> addSchedule(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "要添加的课表信息", required = true
            )
            @RequestBody
            List<CourseSchedule> courseSchedules
    ){


        int result = courseScheduleService.addCourseSchedules(courseSchedules,"admin");

        if(result == 0){
            return new ResultCommon<>(500,"添加失败");
        }

        return new ResultCommon<>(200,"添加成功");

    }


    @Operation(summary = "根据课表id删除课表信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @RequestMapping(value = "/course_schedule/delete",method = RequestMethod.GET)
    public ResultCommon<String> deleteScheduleById(
            @Parameter(name = "id", description = "课表ID", required = true)
            Integer id
    ){

        int result = courseScheduleService.deleteCourseSchedule(id,"admin");

        if(result == 0){
            return new ResultCommon<>(500,"删除失败");
        }

        return new ResultCommon<>(200,"删除成功");

    }


    @Operation(summary = "修改课表信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/course_schedule/update")
    public ResultCommon<String> updateSchedule(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "修改后的课表信息", required = true
            )
            @RequestBody
            CourseSchedule courseSchedule
    ){
        int result = courseScheduleService.updateCourseSchedule(courseSchedule,"admin");

        if(result == 0){
            return new ResultCommon<>(500,"修改失败");
        }

        return new ResultCommon<>(200,"修改成功");
    }

    @Operation(summary = "查看课表信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/course_schedule/getSchedules")
    public ResultCommon<List<CourseSchedule>> getSchedules(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "查询条件", required = true
            )
            @RequestBody
            CourseSchedule courseSchedule
    ){


        List<CourseSchedule> courseSchedules = courseScheduleService.getCourseSchedule(courseSchedule,"admin");


        return new ResultCommon<List<CourseSchedule>>(200,"查询成功",courseSchedules);

    }

    @Operation(summary = "查看课表信息(或条件查询)",description = "主要查有课时间的时候，需要这个，不然按与条件查不到我想要的")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "401",description = "未登录"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/course_schedule/getSchedulesOr")
    public ResultCommon<List<CourseSchedule>> getSchedulesOr(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "查询条件", required = true
            )
            @RequestBody
            CourseSchedule courseSchedule
    ){


        List<CourseSchedule> courseSchedules = courseScheduleService.getCourseScheduleOr(courseSchedule,"admin");


        return new ResultCommon<List<CourseSchedule>>(200,"查询成功",courseSchedules);

    }


    @Operation(summary = "添加学生成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/grade/addGrade")
    public ResultCommon<String> addGrade(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "要添加的学生成绩信息", required = true
            )
            @RequestBody
            Grade grade
    ){

        List<Grade> grades = new ArrayList<>();

        grades.add(grade);

        int result = gradeService.addGradesByAdmin(grades,"admin");

        if(result == 0){
            return new ResultCommon<String>(500,"添加失败");
        }

        return new ResultCommon<String>(200,"添加成功");


    }


    @Operation(summary = "批量添加学生成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/grade/addGrades")
    public ResultCommon<String> addGrades(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "要添加的学生成绩信息", required = true
            )
            @RequestBody
            List<Grade> grades
    ){

        int result = gradeService.addGradesByAdmin(grades,"admin");

        if(result == 0){
            return new ResultCommon<String>(500,"添加失败");
        }

        return new ResultCommon<String>(200,"添加成功");


    }



    @Operation(summary = "根据学生成绩id删除学生成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/grade/deleteGradeById")
    public ResultCommon<String> deleteGradeById(
            @Parameter(name = "id", description = "学生成绩ID", required = true)
            Integer id
    ){

        int result = gradeService.deleteGrade(id,"admin");

        if(result == 0){
            return new ResultCommon<String>(500,"删除失败");
        }

        return new ResultCommon<String>(200,"删除成功");

    }


    @Operation(summary = "修改学生成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/grade/updateGrade")
    public ResultCommon<String> updateGrade(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "修改后的学生成绩信息", required = true
            )
            @RequestBody
            Grade grade
    ){
        int result = gradeService.updateGrade(grade,"admin");
        if(result == 0){
            return new ResultCommon<String>(500,"修改失败");
        }

        return new ResultCommon<String>(200,"修改成功");
    }


    @Operation(summary = "查看学生成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/grade/getGrades")
    public ResultCommon<List<Grade>> getGrades(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "查询条件", required = true
            )
            @RequestBody
            Grade grade
    ){

        List<Grade> grades = gradeService.getGrades(grade,"admin");
        return new ResultCommon<List<Grade>>(200,"成功",grades);
    }


    @Operation(summary = "区间查看学生成绩信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "成功"),
            @ApiResponse(responseCode = "500",description = "失败")
    })
    @PostMapping("/grade/getGradesRange")
    public ResultCommon<List<Grade>> getGradesRange(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "查询条件", required = true
            )
            @RequestBody
            GradeQuery grade
    ){

        List<Grade> grades = gradeService.getGradesByScoreRange(grade.getGrade(),grade.getMin(), grade.getMax(), "admin");
        return new ResultCommon<List<Grade>>(200,"成功",grades);
    }



    @Operation(summary = "管理员查看自己某个课程的学生信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "400", description = "失败"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @RequestMapping(value = "/course/getStudents", produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<Student>> getStudents(
            @Parameter(description = "课程编号", required = true)
            @RequestParam String courseId) {

        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        List<Student> result = studentMapper.getStudentByCourId(courseId);

        return new ResultCommon<>(200, "成功",result);
    }

    @Operation(summary = "管理员查看所有教师信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "400", description = "失败"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @RequestMapping(value = "/commonData/getAllTeachers", produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<Teacher>> getAllTeachers() {

        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        List<Teacher> result = teacherService.getAllTeachers("admin");

        return new ResultCommon<>(200, "成功",result);
    }


    @Operation(summary = "管理员查看所有场地信息",description = "其实没有场地这个表，但是我们的场地允许管理员自己随意编辑，这里我们只要从数据库找出所有课程表信息，对场地去重就行了")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "400", description = "失败"),
            @ApiResponse(responseCode = "401", description = "未登录")
    })
    @RequestMapping(value = "/commonData/getAllLocations", produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public ResultCommon<List<CourseSchedule>> getAllLocations() {

        Users user = (Users) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResultCommon<>(401, "未登录", null);
        }

        List<CourseSchedule> result = courseScheduleService.getAllLocations("admin");

        return new ResultCommon<>(200, "成功",result);
    }


}
