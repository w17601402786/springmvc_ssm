package com.management.service.impl;

import com.management.mapper.StudentMapper;
import com.management.mapper.TeacherMapper;
import com.management.mapper.UsersMapper;
import com.management.pojo.Users;
import com.management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Users getUserById(Integer userId) {
        return usersMapper.getUserById(userId);
    }


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
    public List<Users> getUsers(Users user, String thisUserType) {

        if (!thisUserType.equals("admin")){
            return null;
        }

        return usersMapper.getUsers(user);
    }

    @Override
    public List<Users> getStudentUsers(Users user, String thisUserType) {

        if (!thisUserType.equals("admin")){
            return null;
        }

        return usersMapper.getStudentUsers(user);
    }

    @Override
    public List<Users> getTeacherUsers(Users user, String thisUserType) {

        if (!thisUserType.equals("admin")){
            return null;
        }

        return usersMapper.getTeacherUsers(user);
    }

    @Override
    public Users login(Users user) {

        Map<String, Object> map  = new HashMap<>();

        map.put("userName", user.getUsername());
        map.put("password", user.getPassword());

        user = usersMapper.getUserByUserNameAndPassword(map);

        if (user == null){
            return null;
        }

        if (user.getUserType().equals("student")){
            user = usersMapper.getStudentUsers(user).get(0);
        }else if (user.getUserType().equals("teacher")){
            user = usersMapper.getTeacherUsers(user).get(0);
        }

        return user;
    }

}
