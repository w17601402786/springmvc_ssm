package com.management.mapper;

import com.management.pojo.Grade;
import com.management.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 添加学生基本信息
     *
     * @param student 学生信息
     */
    int addStudent(Student student);

    /**
     * 删除学生基本信息
     *
     * @param studentId 学号
     */
    int deleteStudentByUserId(Integer userId);

    /**
     * 修改学生基本信息
     *
     * @param student 学生信息
     */
    int updateStudent(Student student);


    /**
     * 通过学生Bean查询学生信息
     * @param student 学生Bean
     *                其里面关联Users类与Classes类
     *                可以通过Users里面的属性、Classes里面的属性
     *                以及自己本身具有的属性来查询学生信息
     * @return 学生信息列表
     */

    List<Student> getStudents(Student student);


    /**
     * 查询选择了某个课程的学生
     * @return 选择了某个课程的所有学生
     */
    List<Student> getStudentByCourId(String courseId);




    //---------------------------------分割线---------------------------------//
    //                         以下方法全部弃用，不再使用                       //
    //                         请使用上面的方法来代替                           //
    //---------------------------------分割线---------------------------------//



    /**
     * 获取所有学生基本信息
     * 都说了，上面的方法可以直接获取所有学生，你还写这个干啥？
     * @deprecated 请使用getStudents方法
     * @return 所有学生基本信息
     */
    @Deprecated
    List<Student> getAllStudents();

    /**
     * 根据学号查询学生基本信息
     * @deprecated 请使用getStudent方法
     * @param studentId 学号
     * @return 查询到的学生信息
     */
    @Deprecated
    @Select("select * from student where student_id = #{studentId}")
    Student getStudentByStudentId(String studentId);

    /**
     * 根据姓名查询学生基本信息
     * @deprecated 请使用getStudent方法
     * @param name 姓名
     * @return 查询到的学生信息
     */
    @Deprecated
    List<Student> getStudentByName(String name);

    /**
     * 根据专业、班级查询学生基本信息
     * @deprecated 请使用getStudent方法
     * @param major 专业
     * @param classNum 班级号
     * @return 查询到的学生信息
     */
    @Deprecated
    List<Student> getStudentByClass(String major, String classNum);



    /**
     * 获取当前学生的学生信息
     * @deprecated 请使用getStudent方法
     * @param userId 用户ID
     * @return 当前学生信息
     */
    @Deprecated
    Student getStudentByUserId(Integer userId);

    /**
     * 根据学号查询学生的成绩信息
     * @deprecated 请使用gradeMapper.getGrades方法
     * @param studentId 学生学号
     * @return 成绩信息列表
     */
    @Deprecated
    List<Grade> getGradeByStudentId(String studentId);


}
