package com.dao.impl;

import com.dao.OrderItemDao;
import com.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
//Ctrl,shift,T快速生成测试
    @Override
    public int SaveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(`id`,`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?,?)";
        return update(sql,orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql="select id,name,count,price,total_Price totalPrice,order_id orderId from t_order_item where order_id=?";
        System.out.println(queryForList(OrderItem.class,sql,orderId));
        return queryForList(OrderItem.class,sql,orderId);
    }
}
