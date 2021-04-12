package com.dao;

import com.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int SaveOrderItem(OrderItem orderItem);

    List<OrderItem> queryOrderItemsByOrderId(String orderedId);
}
