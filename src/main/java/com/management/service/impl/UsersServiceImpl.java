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
    public int addUser(Users user) {
        return usersMapper.addUser(user);
    }

    @Override
    public Users getUserByUsername(String username) {
        return usersMapper.getUserByUsername(username);
    }

    @Override
    public int updateUser(Users user) {
        return usersMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer userId) {
        return 0;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    @Override
    public List<Users> getUsersByType(String userType) {

        return null;
    }

    @Override
    public Users getUserById(Integer userId) {
        return null;
    }
}
