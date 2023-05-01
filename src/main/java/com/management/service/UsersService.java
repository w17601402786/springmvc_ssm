package com.management.service;


import com.management.pojo.Users;

import java.util.List;

public interface UsersService {

    int addUser(Users user);

    int deleteUser(int userId);

    int updateUser(Users user);

    Users getUserById(int userId);

    Users getUserByUsername(String username);

    List<Users> getAllUsers();

    Users getUserByUserNameAndPassword(String userName,String password);

}
