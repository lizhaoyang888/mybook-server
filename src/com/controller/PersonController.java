package com.controller;

import com.bean.Person;
import com.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @Autowired
    @Qualifier("personService")
    private PersonService personService;

    //public static Log logger = LogFactory.getLog(PersonController);
    @RequestMapping(value = "/person")
    public String person(String name, Model model){
        Person person = personService.selectPersonById(name);
        model.addAttribute("person",person);
        return "personinfo";
    }
}
