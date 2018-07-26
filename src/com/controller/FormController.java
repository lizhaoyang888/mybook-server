package com.controller;

import com.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 动态页面跳转控制器
 */

@Controller
public class FormController {
    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName){
        // 动态跳转页面
        return formName;
    }

    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(ModelAndView mv){
        User user = new User();
        mv.addObject("user",user);
        mv.setViewName("insertForm");
        return mv;
    }
}
