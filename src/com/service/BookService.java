package com.service;

import java.util.List;

import com.bean.Book;

public interface BookService {
    /*
     * 查询所有图书
     */
    List<Book> getAll();
}
