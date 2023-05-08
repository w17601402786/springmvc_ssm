package com.management.service.impl;

import com.management.mapper.StudentMapper;
import com.management.mapper.TeacherMapper;
import com.management.mapper.UsersMapper;
import com.management.pojo.Student;
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
    public Users getUserByUsername(String username,String thisUserType) {

        if (!thisUserType.equals("admin")){
            return null;
        }

        return usersMapper.getUserByUsername(username);
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
        return 0;
    }

    @Override
    public List<Users> getAllUsers(String thisUserType) {

        if (!thisUserType.equals("admin")){
            return null;
        }

        return usersMapper.getAllUsers();
    }

    @Override
    public List<Users> getUsersByType(String userType,String thisUsertype) {

        if (!thisUsertype.equals("admin")){
            return null;
        }

        return null;
    }

    @Override
    public Users getUserById(Integer userId,String thisUserType) {

        if (!thisUserType.equals("admin")){
            return null;
        }

        return null;
    }
}
