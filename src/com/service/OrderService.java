package com.service;

import com.bean.Order;

public interface OrderService {
    Order selectOrderById(Integer id);
}
