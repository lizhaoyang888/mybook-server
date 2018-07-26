package com.mapper;

import com.bean.MyAnotherObject;
import com.bean.MyObject;

public class MyObjectDao {
    private MyObject myObject = new MyObject();
    public MyAnotherObject getMyAnotherObject(){
        return myObject.getMyAnotherObject();
    }
}
