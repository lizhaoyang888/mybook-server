package com.service;

import com.bean.Person;

public interface PersonService {
    Person selectPersonById(String name);
}
