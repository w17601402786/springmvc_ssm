package com.management.mapper;

import com.management.pojo.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Mapper
public interface UsersMapper {


    /**
     * 添加用户
     * @param user 用户对象
     * @return 影响记录数
     */
    int addUser(Users user);

    /**
     * 删除用户
     * @param userId 要删除的用户的id
     * @return 删除结果
     */
    @Delete("delete from users where id=#{userId}")
    int deleteUserById(int userId);

    /**
     * 修改用户信息
     * <p color=red"">
     *  不能更新userName!!!
     * </p>
     * @param user 要修改的用户修改后的对象
     * @return 修改结果
     */
    int updateUser(Users user);

    /**
     * 根据用户id查询用户
     * @param userId 用户id
     * @return 用户对象
     */
    @Select("select * from users where id=#{userId}")
    Users getUserById(@PathVariable("userId") int userId);


    /**
     * 查询所有用户的信息
     * @return 用户列表
     */
    @Select("select * from users")
    List<Users> getAllUsers();


    /**
     * 查询用户名密码是否正确
     * @param map 用户名和密码
     * @return 正确就匹配并返回
     */
    @Select("select * from users where username=#{userName} and password=#{password}")
    Users getUserByUserNameAndPassword(Map<String, Object> map);


    /**
     * 根据用户Bean查询用户
     * @param user 用户Bean
     * @return 用户列表
     */
    List<Users> getUsers(Users user);

    /**
     * 获取学生用户的信息
     * @param user 用户Bean
     * @return 学生用户列表，其中student信息包含在user中的属性中
     */
    List<Users> getStudentUsers(Users user);

    /**
     * 获取教师用户的信息
     * @param user 用户Bean
     * @return 教师用户列表，其中teacher信息包含在user中的属性中
     */
    List<Users> getTeacherUsers(Users user);

}

