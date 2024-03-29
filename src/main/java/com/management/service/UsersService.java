package com.management.service;

import com.management.pojo.Users;
import java.util.List;

/**
 * 用户管理Service接口
 */
public interface UsersService {


    /**
     * 根据用户ID获取用户信息
     * <p>主要用于获取当前用户的信息</p>
     * @param userId 用户ID
     * @return 用户信息
     */
    Users getUserById(Integer userId);

    /**
     * 添加用户
     * <p>仅管理员可用</p>
     * @param user 用户信息
     * @param thisUserType 当前用户类型
     * @return 添加结果
     */
    int addUser(Users user, String thisUserType);


    /**
     * 更新用户信息
     * <p>仅管理员可用</p>
     * @param user 更新后的用户信息
     * @param thisUserType 当前用户类型
     * @return 更新结果
     */
    int updateUser(Users user,String thisUserType);

    /**
     * 根据用户ID删除用户
     * <p>仅管理员可用</p>
     * @param userId 用户ID
     * @param thisUserType 当前用户类型
     * @return 删除结果
     */
    int deleteUserById(Integer userId, String thisUserType);


    /**
     * 获取所有用户信息
     * <p>仅管理员可用</p>
     * @param thisUserType 当前用户类型
     * @return 所有用户信息
     */
    List<Users> getAllUsers(String thisUserType);

    /**
     * 根据用户bean获取用户信息
     * <p>仅管理员可用</p>
     * @param user 用户bean
     * @param thisUserType 当前用户类型
     * @return 用户信息
     */
    List<Users> getUsers(Users user, String thisUserType);

    /**
     * 获取所有学生用户信息
     * <p>仅管理员可用</p>
     * @param user 用户bean
     * @param thisUserType 当前用户类型
     * @return 学生用户信息
     */
    List<Users> getStudentUsers(Users user, String thisUserType);


    /**
     * 获取所有教师用户信息
     * <p>仅管理员可用</p>
     * @param user 用户bean
     * @param thisUserType 当前用户类型
     * @return 教师用户信息
     */
    List<Users> getTeacherUsers(Users user, String thisUserType);

    /**
     * 用户登录
     * @param user 包含用户名和密码的用户bean
     * @return 登录成功的用户信息，登录成功就返回完整的用户信息，否则返回null
     */
    Users login(Users user);

    /**
     * 修改密码
     * @param user 包含用户ID和新密码的用户bean
     * @return 修改结果
     */
    int updatePassword(Users user);

}
