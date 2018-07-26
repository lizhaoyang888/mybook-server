package com.controller;



import com.alibaba.fastjson.JSONObject;
import com.bean.MyBook;

import com.service.MyBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/mybook")
public class MyBookController {

    @Autowired
    @Qualifier("myBookService")
    private MyBookService myBookService;

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public void query(@RequestParam(value = "pageNum") String pageNum,@RequestParam(value = "pageSize") String pageSize, HttpServletResponse response){
        int num = Integer.parseInt(pageNum);
        int size = Integer.parseInt(pageSize);
        num = (num-1)*size;
        response.setContentType("text/html;charset=UTF-8");
        List<MyBook> list = myBookService.findWithPageSize(num,size);
        Map<String,List<MyBook>> map = new HashMap<>();
        map.put("data",list);
        try {
            response.getWriter().println(JSONObject.toJSONString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
