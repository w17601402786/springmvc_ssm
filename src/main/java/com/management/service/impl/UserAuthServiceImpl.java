package com.management.service.impl;

import com.management.mapper.UsersMapper;
import com.management.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuthServiceImpl implements UserDetailsService {

    @Autowired
    UsersMapper userMapper;

    
    public Users getUserByUsername(String username) {
        Users users = new Users();
        users.setUsername(username);


        List<Users> usersList = userMapper.getUsers(users);

        return usersList.size() == 0 ? null : usersList.get(0);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("username = " + username+"进入了UserAuthServiceImpl");

        Users users = getUserByUsername(username);
        if (users==null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        String password = users.getPassword();

        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(users.getUserType());



        return new User(username,password,auths);
    }

}
