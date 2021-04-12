package com.dao;

import com.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryPageTotalCount();

    List<Book> queryForPageItems(Integer begin, Integer pageSize);

    Integer queryPageTotalCount(Integer min, Integer max);

    List<Book> queryForPageItems(Integer begin, Integer pageSize, Integer min, Integer max);
}
