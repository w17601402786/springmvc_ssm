package com.management.mapper;

import com.management.pojo.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface UsersMapper {


    /**
     * 添加用户
     * @param user 用户对象
     * @return 影响记录数
     */
    @Insert("insert into users(username,password,user_type) values(#{username},#{password},#{userType})")
    int addUser(Users user);

    /**
     * 删除用户
     * @param userId 要删除的用户的id
     * @return 删除结果
     */
    // 删除用户
    @Delete("delete from users where id=#{userId}")
    int deleteUser(int userId);

    /**
     * 修改用户信息
     * @param user 要修改的用户修改后的对象
     * @return 修改结果
     */
    @Update("update users set username=#{username},password=#{password},user_type=#{userType} where id=#{userId}")
    int updateUser(Users user);

    /**
     * 根据用户id查询用户
     * @param userId 用户id
     * @return 用户对象
     */
    @Select("select * from users where id=#{userId}")
    Users getUserById(@PathVariable("userId") int userId);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户对象
     */
    @Select("select * from users where username=#{username}")
    Users getUserByUsername(String username);

    /**
     * 查询所有用户的信息
     * @return 用户列表
     */
    @Select("select * from users")
    List<Users> getAllUsers();


    /**
     * 查询用户名密码是否正确
     * @param userName 用户名
     * @param password 密码
     * @return 正确就匹配并返回
     */
    @Select("select * from users where username=#{userName} and password=#{password}")
    Users getUserByUserNameAndPassword(@PathVariable("userName") String userName,@PathVariable("password") String password);
}

