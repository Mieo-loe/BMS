package com.tencent.controller.recycle;

import com.tencent.dao.IBookDao;
import com.tencent.dao.IRecycleDao;
import com.tencent.model.Book;
import com.tencent.model.Recycle;
import com.tencent.service.IBookService;
import com.tencent.service.IRecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.PrivateKey;
import java.util.*;

@Controller
@RequestMapping("/recycleBook")
public class RecycleBookController {

    @Autowired
    IRecycleService recycleServiceImpl;
    @Autowired
    IBookService bookServiceImpl;
    private ModelAndView modelAndView = new ModelAndView();
    private static List<Book> BOOKS = new ArrayList<>();
    private static Set<String> BOOKCATEGORYS = new HashSet<>();
    @RequestMapping("/booklist")
    public ModelAndView selectAll() {
        /*获取书籍分类信息*/
        List<Recycle> recycles = recycleServiceImpl.selectAll("book");
        List<Book> books = new ArrayList<>();
        Set<String> bookCategorys = new HashSet<>();
        for (Recycle recycle : recycles) {
            Book book = recycleServiceImpl.bookSelectAll(recycle);
            if(book!=null){
                book.setDeleteTime(recycle.getDeleteTime());
                books.add(book);
            }
        }
        for (Book book : books) {
            bookCategorys.add(book.getBookCategory());
        }
        BOOKS = books;
        BOOKCATEGORYS = bookCategorys;
        modelAndView.addObject("bookCategorys", BOOKCATEGORYS);
        modelAndView.addObject("books", BOOKS);
        modelAndView.setViewName("/recycle/recyclebook");
        return modelAndView;
    }

    @RequestMapping("/restore")
    public ModelAndView restore(Integer id) {
        Recycle recycle = recycleServiceImpl.selectByRecordId(id);
        recycleServiceImpl.restore(recycle);
        recycleServiceImpl.delete(id);
        modelAndView.setViewName("forward:/recycleBook/booklist");
        return modelAndView;
    }

    @RequestMapping("/query")
    public ModelAndView selectByCondition(String bookName, String bookCategory) {
        List<Book> books = new ArrayList<>();
        for (Book book : BOOKS) {
            //两个查询条件都为空
            if ("".equals(bookName) && "".equals(bookCategory)) {
                    books.add(book);
            }
            //两个查询条件都不为空
            else if (!"".equals(bookName) && !"".equals(bookCategory)) {
                      if (book.getBookName().equals(bookName) && book.getBookCategory().equals(bookCategory)) {
                    books.add(book);
                }
            }
            //两个查询条件只有一个为空
            else if (book.getBookName().equals(bookName) || book.getBookCategory().equals(bookCategory)) {
                books.add(book);
            }
        }
        modelAndView.addObject("bookName", bookName);
        modelAndView.addObject("bookCategorys", BOOKCATEGORYS);
        modelAndView.addObject("books", books);
        modelAndView.setViewName("/recycle/recyclebook");
        return modelAndView;
    }
    
    @RequestMapping("/remove")
    public ModelAndView deleteAll(){
        for (Book book : BOOKS) {
            bookServiceImpl.deleteById(book.getId());
            recycleServiceImpl.delete(book.getId());
        }
         modelAndView.setViewName("forward:/recycleBook/booklist");
        return modelAndView;
    }
}
