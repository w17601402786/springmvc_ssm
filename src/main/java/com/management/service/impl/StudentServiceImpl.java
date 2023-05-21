package com.management.service.impl;

import com.management.mapper.ClassesMapper;
import com.management.mapper.GradeMapper;
import com.management.mapper.StudentMapper;
import com.management.mapper.UsersMapper;
import com.management.pojo.*;
import com.management.service.ClassesService;
import com.management.service.CourseScheduleService;
import com.management.service.StudentService;
import com.management.tools.ResultCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ClassesMapper classesMapper;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    GradeMapper gradeMapper;

    @Autowired
    ClassesService classesService;

    @Autowired
    CourseScheduleService courseScheduleService;


    @Override
    public List<Student> getAllStudents(String userType) {

        if (!userType.equals("admin")){
            return null;
        }

        return studentMapper.getStudents(null);
    }

    @Override
    public List<Student> getStudents(Student student, String userType) {

        if (!userType.equals("admin")){
            return null;
        }

        return studentMapper.getStudents(student);
    }

    @Override
    public int addStudent(Student student, String userType) {
        if (!userType.equals("admin")){
            return 0;
        }

        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudentByUserId(Integer userId, String userType) {

        // 只有管理员可以删除学生
        if (!userType.equals("admin")){
            return 0;
        }

        return studentMapper.deleteStudentByUserId(userId);
    }

    @Override
    public int updateStudent(Student student,String userType) {

        if (!userType.equals("admin")){
            return 0;
        }

        return studentMapper.updateStudent(student);
    }




    @Override
    public Student getStudentByStudentId(String studentId) {

        Student student = new Student();
        student.setStudentId(studentId);

        List<Student> students = studentMapper.getStudents(student);

        return students.size() == 0 ? null : students.get(0);
    }

    @Override
    public List<Student> getStudentsByName(String name) {

        Student student = new Student();
        student.setName(name);

        return studentMapper.getStudents(student);

    }

    @Override
    public List<Student> getStudentByClasses(Classes classes) {

        Student student = new Student();
        student.setClasses(classes);

        return studentMapper.getStudents(student);

    }

    @Override
    public List<Student> getStudentByMajor(String major) {

        Student student = new Student();
        student.setMajor(major);

        return studentMapper.getStudents(student);
    }

    @Override
    public Student getStudentByUserId(Integer userId) {

        Student student = new Student();
        student.setUserId(userId);

        List<Student> students = studentMapper.getStudents(student);

        return students.size() == 0 ? null : students.get(0);
    }

    @Override
    public Classes getClasses(Users user) {
        // 如果已经有了班级信息，直接返回
        if (user.getStudentInfo()!=null && user.getStudentInfo().getClasses()!=null){
            return user.getStudentInfo().getClasses();
        }


        Classes classes = new Classes();
        classes.setClassId(user.getStudentInfo().getClassId());

        List<Classes> classesList = classesService.getClasses(classes);


        return classesList.size() == 0 ? null : classesList.get(0);
    }


    private Classes getClassesByUser(Users user){
        // 先尝试获取自己的班级信息
        if (user.getStudentInfo()!=null && user.getStudentInfo().getClasses()!=null){
            return user.getStudentInfo().getClasses();
        }else {
            Classes classes = new Classes();
            classes.setClassId(user.getStudentInfo().getClassId());

            List<Classes> classesList = classesService.getClasses(classes);

            if (classesList.size() == 0){
                return null;
            }

            return classesList.get(0);
        }
    }


    @Override
    public List<Course> getCourses(Users user) {

        Classes myClass = getClasses(user);

        if (myClass == null){
            return null;
        }

        //再获取当前班级的课程表信息
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setClassId(myClass.getClassId());

        List<CourseSchedule> courseScheduleList = courseScheduleService.getCourseSchedule(courseSchedule, user.getUserType());

        if (courseScheduleList.size() == 0){
            return null;
        }

        // 最后获取课程信息
        List<Course> courseList = new ArrayList<>();

        courseScheduleList.forEach(courseSchedule1 -> {
            courseList.add(courseSchedule1.getCourseInfo());
        });



        return new ArrayList<>(courseList.stream()
                .collect(Collectors.toMap(Course::getId, course -> course, (c1, c2) -> c1))
                .values());

    }

    @Override
    public List<CourseSchedule> getCourseSchedule(Users user) {


        CourseSchedule courseSchedule = new CourseSchedule();

        Classes myClass = getClasses(user);

        if (myClass == null){
            return null;
        }

        courseSchedule.setClassId(myClass.getClassId());

        return courseScheduleService.getCourseSchedule(courseSchedule, user.getUserType());


    }

    @Override
    public List<Grade> getGrades(Integer userId) {

        Student student = new Student();
        student.setUserId(userId);

        Grade grade = new Grade();
        grade.setStudentInfo(student);

        return gradeMapper.getGrades(grade);

    }


    @Override
    public List<Grade> getGradeByStudentId(String studentId) {
        Student student = new Student();
        student.setStudentId(studentId);

        Grade grade = new Grade();
        grade.setStudentInfo(student);

        return gradeMapper.getGrades(grade);
    }

    @Override
    public int selectCourse(String studentId, String courseId) {
        return 0;
    }

    @Override
    public int withdrawCourse(String studentId, String courseId) {
        return 0;
    }

}
