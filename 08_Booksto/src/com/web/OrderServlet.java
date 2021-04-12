package com.web;

import com.pojo.Cart;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.User;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import com.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet{
    OrderService orderService=new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            String orderId = null;
            try {
                orderId = orderService.createOrder(cart, user.getId());
                JdbcUtils.commitAndClose();
                req.getSession().setAttribute("orderId", orderId);
                ((Cart) req.getSession().getAttribute("cart")).clear();
                resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
            } catch (Exception e) {
                JdbcUtils.rollbackAndClose();
                e.printStackTrace();
                orderId=e.getMessage();
                req.setAttribute("notEnoughStock",orderId);
                req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);

            }
/*            if(orderId.contains("库存不足")){
                req.setAttribute("notEnoughStock",orderId);
                req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
            }else{
                req.getSession().setAttribute("orderId", orderId);
                ((Cart) req.getSession().getAttribute("cart")).clear();
                resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
            }*/
        }
    }
        protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Order> orders = orderService.showAllOrders();
            req.setAttribute("orders",orders);
            req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
        }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        req.setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("/pages/manager/order_item_manager.jsp").forward(req,resp);
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<Order> orders= orderService.receiveOrder(orderId,null);
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }
}
