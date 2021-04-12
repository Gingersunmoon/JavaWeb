package com.service;

import com.pojo.Book;
import com.pojo.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void deleteBook(Integer id);
    void updateBook(Book book);
    Book queryBookById(Integer id);
    List<Book> queryBooks();
    Page<Book> page(Integer pageNo, Integer pageSize);
    Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
