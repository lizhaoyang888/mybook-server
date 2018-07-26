package com.mapper;

import com.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class UserDynaSqlProvider {
    public String SelectWithParam(User user){
        return new SQL(){
            {
                SELECT("*");
                FROM("tb_user");
                if (user.getId() != null) {
                    WHERE("id = #{id}");
                }
                if (user.getLoginname() != null){
                    WHERE("loginname = #{loginname}");
                }
                if (user.getPassword() != null){
                    WHERE("password = #{password}");
                }
                if (user.getUsername() != null){
                    WHERE("username = #{username}");
                }
                if (user.getPhone() != null){
                    WHERE("phone = #{phone}");
                }
                if (user.getAddress() != null){
                    WHERE("address = #{address}");
                }
            }
        }.toString();
    }
    public String InsertWithParam(User user){
        return new SQL(){
            {
                INSERT_INTO("tb_user");
                if (user.getLoginname() != null){
                    VALUES("loginname"," #{loginname}");
                }
                if (user.getPassword() != null){
                    VALUES("password"," #{password}");
                }
                if (user.getUsername() != null){
                    VALUES("username"," #{username}");
                }
                if (user.getPhone() != null){
                    VALUES("phone"," #{phone}");
                }
                if (user.getAddress() != null){
                    VALUES("address"," #{address}");
                }
            }
        }.toString();
    }
    public String UpdateWithParam(User user){
        return new SQL(){
            {
                UPDATE("tb_user");
                if (user.getLoginname() != null){
                    SET("loginname = #{loginname}");
                }
                if (user.getPassword() != null){
                    SET("password = #{password}");
                }
                if (user.getUsername() != null){
                    SET("username = #{username}");
                }
                if (user.getPhone() != null){
                    SET("phone = #{phone}");
                }
                if (user.getAddress() != null){
                    SET("address = #{address}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
    public String DeleteWithParam(User user){
        return new SQL(){
            {
                DELETE_FROM("tb_user");
                if (user.getId() != null) {
                    WHERE("id = #{id}");
                }
                if (user.getLoginname() != null){
                    WHERE("loginname = #{loginname}");
                }
                if (user.getPassword() != null){
                    WHERE("password = #{password}");
                }
                if (user.getUsername() != null){
                    WHERE("username = #{username}");
                }
                if (user.getPhone() != null){
                    WHERE("phone = #{phone}");
                }
                if (user.getAddress() != null){
                    WHERE("address = #{address}");
                }
            }
        }.toString();
    }
}
