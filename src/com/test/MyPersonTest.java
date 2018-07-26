package com.test;


import com.DateFormater;
import com.bean.MyPerson;
import com.mapper.MyPersonMapper;
import com.service.MyPersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MyPersonTest {
    @Autowired
    private MyPersonMapper personMapper;

    @Autowired
    @Qualifier("myPersonService")
    private MyPersonService myPersonService;
    @Test
    public void test(){
        Date date = new Date();
        MyPerson person = new MyPerson("李朝阳","123456","41512164",DateFormater.getDateToString(date),null);
        personMapper.addMyPerson(person);
        List<MyPerson> list = personMapper.findAllMyPerson();
        System.out.println(list);
    }

    @Test
    public void test2(){
        List<MyPerson> list = myPersonService.findAllMyPerson();
        System.out.println(list);
    }
}
