package com.tencent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.dao.IRecycleDao;
import com.tencent.model.Book;
import com.tencent.model.Recycle;
import com.tencent.service.IBookService;
import com.tencent.service.IRecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    private static String BOOKNAME;
    private static String BOOKCATEGORY;
    private static List<String> BOOKCATEGORYS;
    private static Integer CURRENTPAGE;
    @Autowired
    IBookService bookServiceImpl;
    @Autowired
    IRecycleService recycelServiceImpl;
    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("/booklist")
    public ModelAndView selectAll(Integer currentPage) {
        BOOKNAME=null;
        BOOKCATEGORY=null;
        BOOKCATEGORYS=null;
        CURRENTPAGE=null;
        currentPage = (currentPage == null) ? 1 : currentPage;
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Book> books = bookServiceImpl.selectAllAndStaff();
        // 取分页信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        /*获取书籍分类信息*/
        BOOKCATEGORYS= bookServiceImpl.selectBookCategory();
        modelAndView.addObject("books", books);
        modelAndView.addObject("bookCategorys", BOOKCATEGORYS);
        modelAndView.addObject("bookName", BOOKNAME);
        modelAndView.addObject("bookCategory", BOOKCATEGORY);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", total);
        modelAndView.setViewName("/book/booklist");
        return modelAndView;
    }

    @RequestMapping("/bookQuery")
    public ModelAndView selectByCondition(Integer currentPage, String bookName, String bookCategory) {
        currentPage = (currentPage == null) ? 1 : currentPage;
        BOOKNAME = bookName;
        BOOKCATEGORY = bookCategory;
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Book> books = bookServiceImpl.selectBookAndStaffByCondition(bookName, bookCategory);
        // 取分页信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        /*获取书籍分类信息*/
        List<String> bookCategorys = bookServiceImpl.selectBookCategory();
        modelAndView.addObject("bookCategorys", BOOKCATEGORYS);
        modelAndView.addObject("bookName", BOOKNAME);
        modelAndView.addObject("bookCategory", BOOKCATEGORY);
        modelAndView.addObject("books", books);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", total);
        modelAndView.setViewName("/book/booklist");
        return modelAndView;
    }

    @RequestMapping("/rollPage")
    public @ResponseBody
    Map<String, Object> selectAllAjax(@RequestBody Map<String, Object> current) {
        Map<String, Object> model = new HashMap<>();
        Integer currentPage = Integer.parseInt(current.get("currentPage").toString());
        System.out.println("currentPage = " + currentPage);
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Book> list = bookServiceImpl.selectAllAndStaff();
        // 取分页信息
        PageInfo<Book> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        model.put("books", list);
        model.put("currentPage", currentPage);
        model.put("totalCount", total);
        model.put("lastPage", lastPage);
        return model;
    }

    @RequestMapping("/queryRollPage")
    public @ResponseBody
    Map<String, Object> selectByCondition(@RequestBody Map<String, Object> current) {
        Map<String, Object> model = new HashMap<>();
        Integer currentPage = Integer.parseInt(current.get("currentPage").toString());
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Book> list = bookServiceImpl.selectBookAndStaffByCondition(BOOKNAME, BOOKCATEGORY);
        // 取分页信息
        PageInfo<Book> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        model.put("books", list);
        model.put("currentPage", currentPage);
        model.put("totalCount", total);
        model.put("lastPage", lastPage);
        return model;
    }

    @RequestMapping("/selectById")
    public @ResponseBody
    Map<String, Object> selectById(@RequestBody Map<String, Object> current) {
        Map<String, Object> model = new HashMap<>();
        Integer id = Integer.parseInt(current.get("id").toString());
        Book book = bookServiceImpl.selectById(id);
        model.put("book", book);
        return model;
    }

    @RequestMapping("/update")
    public ModelAndView update(Book book, Integer currentPage) {
        bookServiceImpl.updateById(book);
       modelAndView.setViewName("forward:/book/booklist");
        return modelAndView;
    }

    @RequestMapping("/recycle")
    public ModelAndView recycle(Integer id) {
        Recycle recycle=new Recycle();
        recycle.setTableName("book");
        recycle.setRecordId(id);
        Date date=new Date();
        recycle.setDeleteTime(date);
        recycelServiceImpl.insert(recycle);
        bookServiceImpl.recycleById(id);
        modelAndView.setViewName("forward:/book/booklist");
        return modelAndView;
    }

    @RequestMapping("/insert")
    public ModelAndView update(Book book) {
        bookServiceImpl.insert(book);
        modelAndView.setViewName("forward:/book/booklist");
        return modelAndView;
    }

}
