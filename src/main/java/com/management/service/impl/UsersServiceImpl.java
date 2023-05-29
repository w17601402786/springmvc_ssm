package com.management.service.impl;

import com.management.mapper.StudentMapper;
import com.management.mapper.TeacherMapper;
import com.management.mapper.UsersMapper;
import com.management.pojo.Users;
import com.management.service.UsersService;
import com.management.tools.ResultCommon;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
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
    @Transactional(rollbackFor = Exception.class)
    public int addUser(Users user, String thisUserType) {

        if (!thisUserType.equals("admin")){
            return 0;
        }


        boolean result = false;


        int id = usersMapper.addUser(user);

        result = (id != 0);

        switch (user.getUserType()) {
            case "teacher":
                user.getTeacherInfo().setUserId(user.getId());
                System.out.println("user.getTeacherInfo() = " + user.getTeacherInfo());
                result = result && (teacherMapper.addTeacher(user.getTeacherInfo()) != 0 );
                break;
            case "student":
                user.getStudentInfo().setUserId(user.getId());
                System.out.println("user.getStudentInfo() = " + user.getStudentInfo());
                result = result && (studentMapper.addStudent(user.getStudentInfo()) != 0);
                break;
        }


        if (!result){
            throw new RuntimeException("添加用户失败");
        }

        return 1;
    }


    @Override
    @Transactional
    public int updateUser(Users user,String thisUserType) {

        if (!thisUserType.equals("admin")){
            return 0;
        }


        // 存储查询所需信息
        Users newUser = new Users();
        newUser.setId(user.getId());

        List<Users> users = getUsers(newUser, "admin");

        // 首先判断该用户是否已经存在，如果存在，则返回错误信息
        if (users.size() == 0) {
            throw new RuntimeException("用户不存在，无法更新");
        }


        Users oldUser = users.get(0);


        //存储每一步执行的结果
        int result = 0;

        //修改涉及到用户类型的时候，需要将对应的信息置空，并且判断是否有必要参数
        if (!oldUser.getUserType().equals(user.getUserType())){


            //判断原用户类型,以删除对应的用户信息
            switch (oldUser.getUserType()){
                case "admin":
                    break;
                case "teacher":

                    result = teacherMapper.deleteTeacherByUserId(oldUser.getId());

                    if (result == 0){
                        throw new RuntimeException("删除失败");
                    }

                    break;
                case "student":

                    result = studentMapper.deleteStudentByUserId(oldUser.getId());

                    if (result == 0){
                        throw new RuntimeException("删除失败");
                    }
                    break;
                default:
                    throw new RuntimeException("原用户类型存在问题");
            }


            //添加新的用户对应数据
            switch (user.getUserType()) {
                case "admin":

                    user.setStudentInfo(null);
                    user.setTeacherInfo(null);
                    break;
                case "teacher":

                    user.setStudentInfo(null);
                    if (user.getTeacherInfo() == null || user.getTeacherInfo().isEmpty()) {
                        throw new RuntimeException("缺少必要参数");
                    }
                    result = teacherMapper.addTeacher(user.getTeacherInfo());

                    if (result == 0){
                        throw new RuntimeException("添加失败");
                    }

                    break;
                case "student":

                    user.setTeacherInfo(null);
                    if (user.getStudentInfo() == null || user.getStudentInfo().isEmpty()) {
                        throw new RuntimeException("缺少必要参数");
                    }

                    result = studentMapper.addStudent(user.getStudentInfo());

                    if (result == 0){
                        throw new RuntimeException("添加失败");
                    }

                    break;
                default:
                    throw new RuntimeException("缺少必要参数");
            }
        }


        if (user.getTeacherInfo()!=null){
            result = teacherMapper.updateTeacher(user.getTeacherInfo());
        } else if (user.getStudentInfo() != null) {
            result = studentMapper.updateStudent(user.getStudentInfo());
        }


        //只要用户信息能更新成功一个就行了
        result = usersMapper.updateUser(user) + result;

        if (result == 0){
            throw new RuntimeException("更新失败");
        }

        return result;
    }

    @Override
    @Transactional
    public int deleteUserById(Integer userId,String thisUserType) {
        if (!thisUserType.equals("admin")){
            return -1;
        }


        //尝试删除用户的其他信息
        teacherMapper.deleteTeacherByUserId(userId);
        studentMapper.deleteStudentByUserId(userId);

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

    @Override
    public int updatePassword(Users user) {

        //防止用户修改其他信息，比如权限
        Users changeUser = new Users();
        changeUser.setId(user.getId());
        changeUser.setPassword(user.getPassword());

        return usersMapper.updateUser(changeUser);

    }


}
