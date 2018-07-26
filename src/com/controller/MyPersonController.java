package com.controller;


import com.DateFormater;
import com.alibaba.fastjson.JSONObject;
import com.bean.MyPerson;
import com.service.MyPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

@Controller
@RequestMapping(value = "/myperson")
public class MyPersonController {

    @Autowired
    @Qualifier("myPersonService")
    private MyPersonService myPersonService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void doPost(@RequestBody MyPerson myPerson, HttpServletResponse response){
        myPersonService.addMyPerson(myPerson);
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().println(JSONObject.toJSONString(myPerson));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public void query(@RequestBody MyPerson myPerson, HttpServletResponse response){
        MyPerson person = myPersonService.findWithNoAndPassword(myPerson.getNo(),myPerson.getPassword());
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().println(JSONObject.toJSONString(person));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/registers",method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response){
        try {
            MyPerson myPerson = new MyPerson();
            request.setCharacterEncoding("UTF-8");
            String str = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((str = reader.readLine()) != null)
            {
                sb.append(str).append("\n");
            }
            String streamIn  = sb.toString();
            JSONObject object = JSONObject.parseObject(streamIn);
            myPerson.setName(object.getString("name"));
            //myPerson.setDate(DateFormater.strToDateLong(object.getString("date")));
            Date date = new Date();
            myPerson.setDate(DateFormater.getDateToString(date));
            myPerson.setNo(object.getString("no"));
            myPerson.setPassword(object.getString("password"));
            myPersonService.addMyPerson(myPerson);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(JSONObject.toJSONString(myPerson));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
