package com.service.impl;


import com.bean.MyPerson;
import com.mapper.MyPersonMapper;
import com.service.MyPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("myPersonService")
public class MyPersonServiceImpl implements MyPersonService {
    @Autowired
    private MyPersonMapper myPersonMapper;

    @Override
    public MyPerson findWithNoAndPassword(String no, String password) {
        return myPersonMapper.findWithNoAndPassword(no,password);
    }

    @Override
    public MyPerson findWithLoginnameAndPassword(String name, String password) {
        return myPersonMapper.findWithLoginnameAndPassword(name,password);
    }

    @Override
    public int addMyPerson(MyPerson person) {
        return myPersonMapper.addMyPerson(person);
    }

    @Override
    public List<MyPerson> findAllMyPerson() {
        return myPersonMapper.findAllMyPerson();
    }
}
