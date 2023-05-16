package com.management.service;

import com.management.pojo.*;

import java.util.List;

/**
 * 班级信息接口
 */
public interface ClassesService {

    /**
     * 添加班级信息
     * @param classes 班级信息
     * @param userType 当前用户类型
     * @return 添加结果
     */
    int addClasses(Classes classes, String userType);

    /**
     * 更新班级信息
     * @param classes 更新后的班级信息
     * <p color="red">
     *     不能更新班级号
     * </p>
     * @param userType 当前用户类型
     * @return 更新结果
     */
    int updateClasses(Classes classes, String userType);

    /**
     * 根据班级号删除班级信息
     * @param classId 班级号
     * @param userType 当前用户类型
     * @return 删除结果
     */
    int deleteClassesById(Integer classId,String userType);


    /**
     * 根据ClassInfo的Bean查询班级信息
     * @param classes 班级的Bean
     * @return 班级信息列表
     */
    List<Classes> getClasses(Classes classes);


}
