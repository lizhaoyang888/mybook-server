package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Book;
import com.service.BookService;

/*
 * 处理图书请求控制器
 */

@Controller
public class BookController {
    /*
     * 自动注入BookService
     */
    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    /*
     * 处理main请求
     */
    @RequestMapping(value="/main")
    public String main(Model model){
        //获取所有图书请求
        List<Book> book_list = bookService.getAll();
        //将图书集合添加到model当中
        model.addAttribute("book_list", book_list);
        //转到main页面
        return "main";
    }
}
