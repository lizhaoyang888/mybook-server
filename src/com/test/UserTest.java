package com.test;

import com.alibaba.fastjson.JSONObject;
import com.bean.MyBook;
import com.mapper.MyBookMapper;
import com.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MyBookMapper myBookMapper;

    @Test
    public void test(){
        System.out.println(userMapper.findWithId(1));
    }

    @Test
    public void tt(){
        List<MyBook> list = myBookMapper.findWithPageSize(1,4);
        Map<String,List<MyBook>> map = new HashMap<>();
        map.put("data",list);
//        for (MyBook book:list){
//            System.out.println(book);
//        }
        System.out.println(JSONObject.toJSONString(map));
    }


}
