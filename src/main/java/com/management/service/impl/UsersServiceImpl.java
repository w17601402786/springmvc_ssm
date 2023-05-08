package com.management.service.impl;

import com.management.mapper.StudentMapper;
import com.management.mapper.TeacherMapper;
import com.management.mapper.UsersMapper;
import com.management.pojo.Users;
import com.management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int addUser(Users user, String thisUserType) {

        if (!thisUserType.equals("admin")){
            return -1;
        }

        return usersMapper.addUser(user);
    }


    @Override
    public int updateUser(Users user,String thisUserType) {

        if (!thisUserType.equals("admin")){
            return -1;
        }

        return usersMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer userId,String thisUserType) {
        if (!thisUserType.equals("admin")){
            return -1;
        }
        return usersMapper.deleteUserById(userId);
    }

    @Override
    public List<Users> getAllUsers(String thisUserType) {

        if (!thisUserType.equals("admin")){
            return null;
        }

        return usersMapper.getAllUsers();
    }

    @Override
    public Users getUserById(Integer userId) {
        return usersMapper.getUserById(userId);
    }

    @Override
    public List<Users> getUsers(Users user, String thisUserType) {

        if (!thisUserType.equals("admin")){
            return null;
        }

        return usersMapper.getUsers(user);
    }

}
