package com.service.impl;

import com.bean.Person;
import com.mapper.OnePersonMapper;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private OnePersonMapper personMapper;
    @Override
    public Person selectPersonById(String name) {
        return personMapper.selectPersonById(name);
    }
}
