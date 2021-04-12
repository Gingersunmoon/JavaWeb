package com.test;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

public class BookServiceTest {
    private BookService bookService=new BookServiceImpl();

    @Test
    public void page(){
        Page<Book> page = bookService.page(3, 4);
        System.out.println("总页数："+page.getPageTotal());
        System.out.println("总书本数"+page.getPageTotalCount());
        List<Book> items = page.getItems();
        for(Book book:items){
            System.out.println(book);
        }
    }

    @Test
    public void Testoi(){

    }
}
