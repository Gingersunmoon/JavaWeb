package com.dao;

import com.pojo.Order;

import java.util.List;

public interface OrderDao {
    int SaveOrder(Order order);

    List<Order> queryOrders();

    List<Order> queryOrdersByUserId(Integer userId);

    int changeOrderStatus(String orderId);
}
