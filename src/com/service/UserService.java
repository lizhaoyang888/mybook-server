package com.service;

import com.bean.User;

import java.util.List;

public interface UserService {
    /*
     * 判断用户登录
     */
    User login(String loginname,String password);

    User loginDyna(User user);

    void modifyUser(User user);

    User findById(Integer id);

    int addUser(User user);

    List<User> findAllUser();

    int delete(Integer id);
}
