package com.mapper;

import com.bean.MyPerson;
import com.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MyPersonMapper {
    /*
     * 根据登录名和密码查询用户
     */
    @Select("select * from myperson where name = #{name} and password = #{password}")
    MyPerson findWithLoginnameAndPassword(@Param("name") String name, @Param("password") String password);

    @Select("select * from myperson where no = #{no} and password = #{password}")
    MyPerson findWithNoAndPassword(@Param("no") String no, @Param("password") String password);

    /**
     * 注册用户
     */
    @Insert("insert into myperson(name,password,no,date,img,mac) values(#{name},#{password}," +
            "#{no},#{date},#{img},#{mac})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int addMyPerson(MyPerson person);

    /**
     * 查询所有用户
     */
    @Select("select * from myperson")
    List<MyPerson> findAllMyPerson();

}
