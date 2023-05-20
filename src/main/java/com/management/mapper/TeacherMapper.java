package com.management.mapper;

import com.management.pojo.Course;
import com.management.pojo.Grade;
import com.management.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    /**
     * 增加一位教师
     * @param teacher 要添加的教师对象
     * @return 影响记录数
     */
    int addTeacher(Teacher teacher);

    /**
     * 删除一位教师
     * @param id 要删除的教师id
     * @return 影响记录数
     */
    int deleteTeacherById(Integer id);

    /**
     * 修改一位教师的信息
     * @param teacher 要修改的教师对象
     * @return 影响记录数
     */
    int updateTeacher(Teacher teacher);

    /**
     * 查询所有教师的信息
     * @return 教师列表
     */
    List<Teacher> getAllTeachers();

    /**
     * 根据教师id查询一位教师的信息
     * @param id 教师id
     * @return 教师对象
     */
    Teacher getTeacherById(Integer id);

    /**
     * 根据教师号查询一位教师的信息
     * @param teacherId 教师号
     * @return 教师对象
     */
    Teacher getTeacherByTeacherId(String teacherId);

    /**
     * 根据用户ID查询教师信息
     * @param userId 用户ID
     * @return 教师信息
     */
    Teacher getTeacherByUserId(Integer userId);


    /**
     * 获取教师的课程信息
     *
     * @param teacherId 教师号
     * @return 课程列表
     */
    List<Course> getTeacherCourses(String teacherId);

    /**
     * 教师获取成绩信息
     * @param teacherId
     * @return
     */
    List<Grade> getGrade(String teacherId);


    List<Teacher> getTeacherByName();

    /**
     * Todo 根据教师的属性以及userType来查询教师
     * TODO 傻叼，谁跟你说要这样写的？
     * TODO userType是在服务层进行判断权限，进而实现权限控制的，不是在这里进行判断的
     * @param teacher 教师对象
     * @return  教师列表
     */
    List<Teacher> getTeachers(Teacher teacher);

}
