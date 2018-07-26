package com.mapper;

import org.apache.ibatis.annotations.*;

import com.bean.User;

import java.util.List;

public interface UserMapper {
    /*
     * 根据登录名和密码查询用户
     */
    @Select("select * from tb_user where loginname = #{loginname} and password = #{password}")
    User findWithLoginnameAndPassword(@Param("loginname") String loginname,@Param("password") String password);

    /*
     * 根据id查询用户
     */
    @Select("select * from tb_user where id = #{id}")
    User findWithId(@Param("id") Integer id);

    /**
     * 修改用户
     */
    @Update("update tb_user set loginname = #{loginname},password = #{password} where id = #{id}")
    void modifyUser(User user);

    /**
     * 注册用户
     */
    @Insert("insert into tb_user(loginname,password,username,phone,address) values(#{loginname},#{password}," +
            "#{username},#{phone},#{address})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int addUser(User user);

    /**
     * 查询所有用户
     */
    @Select("select * from tb_user")
    List<User> findAllUser();

    /**
     * 删除用户
     */
    @Delete("delete from tb_user where id = #{id}")
    int delete(Integer id);
}
