package com.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;
import com.service.UserService;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/*
 * 处理用户请求控制器
 */

@Controller
public class UserController {
    public static Log logger = LogFactory.getLog(UserController.class);
    /*
     * 自动注入UserService
     */
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /*
     * 处理login请求
     */
    @RequestMapping(value="/login")
    public ModelAndView login(String loginname,String password,ModelAndView mv,HttpSession session){
        //根据登录名和密码查找用户，判断用户登录
        //User user = userService.login(loginname, password);
        User u = new User();
        u.setLoginname(loginname);
        u.setPassword(password);
        User user = userService.loginDyna(u);
        if(user!=null){
            // 登录成功，将user对象设置到HttpSession作用范围域
            session.setAttribute("user", user);
            mv.addObject("user",user);
            mv.setViewName("modifyForm");
            //转发到main请求
            //mv.setView(new RedirectView("/main"));
        }
        else{
            // 登录失败，设置失败提示信息，并跳转到登录页面
            mv.addObject("message", "登录名或密码错误，请重新输入!");
            mv.setViewName("loginForm");
        }
        return mv;
    }

    @RequestMapping(value = "/modify")
    public ModelAndView modifyUser(Integer id,String loginname,String password,ModelAndView mv){
        User user = userService.findById(id);
        user.setPassword(password);
        user.setLoginname(loginname);
        userService.modifyUser(user);
        mv.setViewName("loginForm");
        return mv;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView insertUser(User user,ModelAndView mv){
        userService.addUser(user);
        mv.setViewName("loginForm");
        return mv;
    }

    @RequestMapping(value = "/allUser")
    public ModelAndView findAllUser(ModelAndView mv){
        List<User> list = userService.findAllUser();
        mv.addObject("user_list",list);
        mv.setViewName("userlistForm");
        return mv;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView deleteUser(Integer id,ModelAndView mv){
        userService.delete(id);
        mv.setView(new RedirectView("/allUser"));
        return mv;
    }
}
