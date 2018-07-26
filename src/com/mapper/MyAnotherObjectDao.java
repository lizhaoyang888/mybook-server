package com.mapper;

import com.bean.MyAnotherObject;
import com.bean.MyObject;

import javax.servlet.Servlet;

public class MyAnotherObjectDao {
    private MyAnotherObject myAnotherObject = new MyAnotherObject();
    public MyObject getMyObject(){
        return myAnotherObject.getMyObject();
    }
}
