package com.management.service.impl;


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

    @Override
    public int addUser(Users user) {
        return usersMapper.addUser(user);
    }

    @Override
    public int deleteUser(int userId) {
        return usersMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(Users user) {
        return usersMapper.updateUser(user);
    }

    @Override
    public Users getUserById(int userId) {
        return usersMapper.getUserById(userId);
    }

    @Override
    public Users getUserByUsername(String username) {
        return usersMapper.getUserByUsername(username);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    @Override
    public Users getUserByUserNameAndPassword(String userName, String password) {
        return usersMapper.getUserByUserNameAndPassword(userName,password);
    }
}
