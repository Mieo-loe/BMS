package com.tencent.service;

import com.tencent.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service("iBookService")
public interface IBookService {

    /**
     * 把记录放入回收站
     *
     * @param id 书本id
     */
    void recycleById(Integer id);

    /**
     * 永久删除书本记录
     * @param id 书本id
     */
    void deleteById(Integer id);

    /**
     * 插入图书信息
     * @param book 插入的图书对象
     */
    void insert(Book book);

    /**
     * 更改书籍数量
     * @param id 书本id
     * @param bookNumber 书本数量
     */
    void updateBookNumberById( Integer id,Integer bookNumber);

    /**
     *  更新书本信息
     * @param book 需要更新的书本对象
     */
    void updateById(Book book);

    /**
     * 查询所有书籍信息
     * @return 查询结果
     */
    List<Book> selectAll();

    /**
     * 通过id查询书籍信息
     *
     * @param id 书本id
     * @return 查询结果
     */
    Book selectById(Integer id);

    /**
     * 查询所有书籍信息和员工信息
     *
     * @return 查询结果
     */
    List<Book> selectAllAndStaff();

    /**
     * 查询所有书籍分类
     *
     * @return 书籍分类
     */
    List<String> selectBookCategory();

    /**
     * 通过书本名称查询书籍信息和录入的员工信息
     *
     * @param bookName 书本名称
     * @return 查询结果
     */
    List<Book> selectBookAndStaffByCondition(String bookName, String bookCategory);


}
