package com.management.service;

import com.management.pojo.Users;
import java.util.List;

public interface UsersService {
    // 添加用户
    int addUser(Users user);

    // 根据用户名查找用户
    Users getUserByUsername(String username);

    // 更新用户信息
    int updateUser(Users user);
}
