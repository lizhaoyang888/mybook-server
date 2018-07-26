package com.service.impl;

import com.mapper.UserDynaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.mapper.UserMapper;
import com.service.UserService;

import java.util.List;
/*
 * User服务层接口实现类
 * @Service("userService")用于将当前类注释为一个Spring的bean，名为userService
 *
 */

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {
    /*
     * 自动注入UserMapper
     */
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDynaMapper userDynaMapper;

    /*
     * UserService接口login方法实现
     */
    @Transactional(readOnly=true)
    public User login(String loginname, String password) {
        // TODO Auto-generated method stub
        return userMapper.findWithLoginnameAndPassword(loginname, password);
    }

    @Override
    public User loginDyna(User user) {
        return userDynaMapper.selectUser(user);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.modifyUser(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findWithId(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }
}
