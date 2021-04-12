package com.web;

import com.google.gson.Gson;
import com.pojo.Book;
import com.pojo.Cart;
import com.pojo.CartItem;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{
    private BookService bookService=new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.queryBookById(Integer.parseInt(id));
        CartItem cartItem=new CartItem(book.getId(),book.getName(), 1,book.getPrice(),book.getPrice());
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        String lastName=book.getName();
        req.getSession().setAttribute("lastName",lastName);
        cart.addItem(cartItem);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.queryBookById(Integer.parseInt(id));
        CartItem cartItem=new CartItem(book.getId(),book.getName(), 1,book.getPrice(),book.getPrice());
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        String lastName=book.getName();
        cart.addItem(cartItem);
        Map<String,Object> resultMap=new HashMap<String ,Object>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",lastName);
        Gson gson=new Gson();
        String resultMapJsonToString = gson.toJson(resultMap);
        resp.getWriter().write(resultMapJsonToString);
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Cart cart=(Cart)req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int count = Integer.parseInt(req.getParameter("count"));
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateCount(id, count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
