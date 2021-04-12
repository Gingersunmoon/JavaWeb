package com.web;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String No = req.getParameter("pageNo");
        Integer pageNo;
        if (No != null)
            pageNo = Integer.parseInt(No);
        else
            pageNo = 1;
        String Size = req.getParameter("pageSize");
        Integer pageSize;
        if (Size == null)
            pageSize = Page.PAGE_SIZE;
        else
            pageSize = Integer.parseInt(Size);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer min;
        Integer max;
        StringBuilder sb=new StringBuilder("client/bookServlet?action=pageByPrice");
        try {
            min=Integer.parseInt(req.getParameter("min"));
        } catch (NumberFormatException e) {
            min=0;
        }
        sb.append("&min="+min);
        //param中value未赋值的参数默认值不是null！！！！！
/*        if(req.getParameter("min")==null)
            min=0;
        else {
            min=Integer.parseInt(req.getParameter("min"));
            sb.append("&min="+min);
        }*/
        try {
            max=Integer.parseInt(req.getParameter("max"));
        } catch (NumberFormatException e) {
            max=Integer.MAX_VALUE;
        }
        sb.append("&max="+max);
/*        if(req.getParameter("max")==null)
            max=Integer.MAX_VALUE;
        else {
            max=Integer.parseInt(req.getParameter("max"));
            sb.append("&max="+max);
        }*/
        String No = req.getParameter("pageNo");
        Integer pageNo;
        if (No != null)
            pageNo = Integer.parseInt(No);
        else
            pageNo = 1;
        String Size = req.getParameter("pageSize");
        Integer pageSize;
        if (Size == null)
            pageSize = Page.PAGE_SIZE;
        else
            pageSize = Integer.parseInt(Size);
        Page<Book> page=bookService.pageByPrice(pageNo,pageSize,min,max);
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
