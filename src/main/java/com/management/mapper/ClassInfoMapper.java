package com.management.mapper;

import com.management.pojo.ClassInfo;

import java.util.List;

public interface ClassInfoMapper {

    /**
     * 添加班级信息
     *
     * @param classInfo 班级信息
     */
    void addClass(ClassInfo classInfo);

    /**
     * 删除班级信息
     *
     * @param id 班级ID
     */
    void deleteClass(Integer id);

    /**
     * 修改班级信息
     *
     * @param classInfo 班级信息
     */
    void updateClass(ClassInfo classInfo);

    /**
     * 根据班级ID查询班级信息
     *
     * @param id 班级ID
     * @return 查询到的班级信息
     */
    ClassInfo getClassByCid(Integer id);

    /**
     * 根据班级名称查询班级信息
     *
     * @param name 班级名称
     * @return 查询到的班级信息
     */
    List<ClassInfo> getClassByCname(String name);

    /**
     * 根据专业ID查询班级信息
     *
     * @param major 专业
     * @return 查询到的班级信息
     */
    List<ClassInfo> getClassByMajor(Integer major);

}
