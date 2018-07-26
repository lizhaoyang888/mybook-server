package com.service;

import com.bean.MyPerson;

import java.util.List;

public interface MyPersonService {
    MyPerson findWithLoginnameAndPassword(String name, String password);
    int addMyPerson(MyPerson person);
    List<MyPerson> findAllMyPerson();
    MyPerson findWithNoAndPassword(String no, String password);
}
