package com.service;

import com.pojo.Cart;
import com.pojo.Order;
import com.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    String createOrder(Cart cart,Integer userId);

    List<Order> showAllOrders();

    List<OrderItem> showOrderDetail(String orderedId);

    List<Order> showMyOrders(Integer userId);

    List<Order> receiveOrder(String orderId,Integer userId);
}
