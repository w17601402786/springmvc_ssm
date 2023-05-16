package com.management.mapper;

import com.management.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 添加学生基本信息
     *
     * @param student 学生信息
     */
    void addStudent(Student student);

    /**
     * 删除学生基本信息
     *
     * @param studentId 学号
     */
    void deleteStudent(String studentId);

    /**
     * 修改学生基本信息
     *
     * @param student 学生信息
     */
    void updateStudent(Student student);

    /**
     * 根据学号查询学生基本信息
     *
     * @param studentId 学号
     * @return 查询到的学生信息
     */
    Student getStudentByStudentId(String studentId);

    /**
     * 根据姓名查询学生基本信息
     *
     * @param name 姓名
     * @return 查询到的学生信息
     */
    List<Student> getStudentByName(String name);

    /**
     * 根据专业、班级查询学生基本信息
     *
     * @param major 专业
     * @param classNum 班级号
     * @return 查询到的学生信息
     */
    List<Student> getStudentByClass(String major, String classNum);

    /**
     * 获取当前学生的学生信息
     * @param userId 用户ID
     * @return 当前学生信息
     */
    Student getStudentByUserId(Integer userId);


}
