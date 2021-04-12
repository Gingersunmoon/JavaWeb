package com.test;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {
    private BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"姜哥为什么这么帅",
                "Ginger",new BigDecimal(Integer.toString(99)),
                1000,12,null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"姜大哥为什么这么帅",
                "Ginger",new BigDecimal(Integer.toString(99)),
                1000,12,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for(Book book:books){
            System.out.println(book);
        }
    }

    @Test
    public void queryPageTotalCount() {
        System.out.println(bookDao.queryPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(4, 4);
        for(Book book:books){
            System.out.println(book);
        }
    }
}