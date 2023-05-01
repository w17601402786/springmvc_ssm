package com.management.service.impl;

import com.management.mapper.UsersMapper;
import com.management.pojo.Users;
import com.management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

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
}
