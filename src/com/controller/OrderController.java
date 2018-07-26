package com.controller;

import com.bean.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    @RequestMapping(value = "/order")
    public String order(Integer id, Model model){
        Order order = orderService.selectOrderById(id);
        model.addAttribute("order",order);
        return "order_info";
    }
}
