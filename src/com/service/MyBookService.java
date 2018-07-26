package com.service;

import com.bean.MyBook;
import com.bean.MyPerson;

import java.util.List;

public interface MyBookService {
     List<MyBook> findWithPageSize(int pageNum, int pageSize);
}
