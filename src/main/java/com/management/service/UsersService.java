package com.management.service;

import com.management.pojo.Users;
import java.util.List;

public interface UsersService {
    // 添加用户
    int addUser(Users user, String thisUserType);

    // 根据用户名查找用户
    Users getUserByUsername(String username, String thisUserType);

    // 更新用户信息
    int updateUser(Users user,String thisUserType);

    // 根据用户ID删除用户
    int deleteUserById(Integer userId, String thisUserType);

    // 获取所有用户
    List<Users> getAllUsers(String thisUserType);

    // 获取特定类型的所有用户
    List<Users> getUsersByType(String userType, String thisUsertype);

    // 根据用户ID获取用户信息
    Users getUserById(Integer userId, String thisUserType);
}
