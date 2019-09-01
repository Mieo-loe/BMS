package com.tencent.service.impl;

import com.tencent.dao.IBookDao;
import com.tencent.model.Book;
import com.tencent.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 */
@Transactional
@Service
public class BookServiceImpl implements IBookService{
    private final
    IBookDao bookDao;

    @Autowired
    public BookServiceImpl(IBookDao bookDao) {this.bookDao = bookDao;}

    @Override
    public void recycleById(Integer id) {
        bookDao.recycleById(id);
    }

    @Override
    public void deleteById(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public void insert(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void updateBookNumberById(Integer id, Integer bookNumber) {
        bookDao.updateBookNumberById(id, bookNumber);
    }

    @Override
    public void updateById(Book book) {
        bookDao.updateById(book);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public Book selectById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> selectAllAndStaff() {
        return bookDao.selectAllAndStaff();
    }

    @Override
    public List<String> selectBookCategory() {
        return bookDao.selectBookCategory();
    }

    @Override
    public List<Book> selectBookAndStaffByCondition(String bookName, String bookCategory) {
        return bookDao.selectBookAndStaffByCondition(bookName, bookCategory);
    }
}
