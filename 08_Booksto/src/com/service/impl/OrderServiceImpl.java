package com.service.impl;

import com.dao.BookDao;
import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.dao.impl.BookDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.*;
import com.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao=new OrderDaoImpl();
    OrderItemDao orderItemDao=new OrderItemDaoImpl();
    BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId=""+System.currentTimeMillis()+userId;
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.SaveOrder(order);
        for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            CartItem value = entry.getValue();
            OrderItem orderItem=new OrderItem(value.getId(),value.getName(),value.getCount(),value.getPrice(),value.getTotalPrice(),orderId);
            orderItemDao.SaveOrderItem(orderItem);
            Book book = bookDao.queryBookById(value.getId());
            if(book.getStock()<value.getCount()){
                throw new RuntimeException(book.getName()+" 库存不足，请调整数量!");
            }
            book.setSales(book.getSales()+value.getCount());
            book.setStock(book.getStock()-value.getCount());
            bookDao.updateBook(book);
        }
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        List<Order> orders = orderDao.queryOrders();
        return orders;
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }



    @Override
    public List<Order> receiveOrder(String orderId,Integer useId) {
        orderDao.changeOrderStatus(orderId);
        if(useId==null){
            return orderDao.queryOrders();
        }else {
            return orderDao.queryOrdersByUserId(useId);
        }
    }
}
