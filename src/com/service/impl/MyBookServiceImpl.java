package com.service.impl;


import com.bean.MyBook;
import com.bean.MyPerson;
import com.mapper.MyBookMapper;
import com.mapper.MyPersonMapper;
import com.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("myBookService")
public class MyBookServiceImpl implements MyBookService {
    @Autowired
    private MyBookMapper myBookMapper;

    @Override
    public List<MyBook> findWithPageSize(int pageNum, int pageSize) {
        return myBookMapper.findWithPageSize(pageNum,pageSize);
    }
}
