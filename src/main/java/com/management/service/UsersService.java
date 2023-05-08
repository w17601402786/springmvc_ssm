package com.management.service;

import com.management.pojo.Users;
import java.util.List;

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
     * @param user 用户bean
     * @param thisUserType 当前用户类型
     * @return 用户信息
     */
    List<Users> getUsers(Users user, String thisUserType);


}
