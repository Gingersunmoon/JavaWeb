package com.service.impl;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        Page<Book> page=new Page<Book>();
        page.setPageSize(pageSize);
        Integer pageTotalCount=bookDao.queryPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal=(int)Math.ceil((double) pageTotalCount/pageSize);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        Integer begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);
        Integer pageTotalCount=bookDao.queryPageTotalCount(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal=(int)Math.ceil((double) pageTotalCount/pageSize);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        Integer begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItems(begin,pageSize,min,max);
        page.setItems(items);

        return page;
    }
}
