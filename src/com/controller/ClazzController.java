package com.controller;

import com.bean.Clazz;
import com.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClazzController {

    @Autowired
    @Qualifier("clazzService")
    private ClazzService clazzService;

    @RequestMapping(value = "/clazz")
    public String clazz(Integer id,Model model){
        Clazz clazz = clazzService.selectClazzById(id);
        model.addAttribute("students",clazz.getStudents());
        return "clazz_student_info";
    }
}
