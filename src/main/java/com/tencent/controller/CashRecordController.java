package com.tencent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.model.Book;
import com.tencent.model.CashRecord;
import com.tencent.model.Recycle;
import com.tencent.service.IBookService;
import com.tencent.service.ICashRecordService;
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

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/cash_record")
public class CashRecordController {
    @Autowired
    ICashRecordService cashRecordServiceImpl;
    @Autowired
    IBookService bookServiceImpl;
    @Autowired
    IRecycleService recycelServiceImpl;
    private static String CASHDATE;
    private static Integer BOOKID;
    private static Integer BOOKNUMBER;
    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("/cashrecordlist")
    public ModelAndView selectAll(Integer currentPage) {
        CASHDATE=null;
        currentPage = (currentPage == null) ? 1 : currentPage;
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<CashRecord> list = cashRecordServiceImpl.selectAll();
        // 取分页信息
        PageInfo<CashRecord> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        modelAndView.setViewName("cash_record/cashrecordlist");
        modelAndView.addObject("cashDate", CASHDATE);
        modelAndView.addObject("cashrecords", list);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", total);
        modelAndView.addObject("lastPage", lastPage);
        return modelAndView;
    }

    @RequestMapping("/rollpage")
    public @ResponseBody
    Map<String, Object> selectAllAjax(@RequestBody Map<String, Integer> current) {
        Map<String, Object> model = new HashMap<>();
        Integer currentPage = current.get("currentPage");
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<CashRecord> list = cashRecordServiceImpl.selectAll();
        // 取分页信息
        PageInfo<CashRecord> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        model.put("cashRecords", list);
        model.put("currentPage", currentPage);
        model.put("totalCount", total);
        model.put("lastPage", lastPage);
        return model;
    }

    @RequestMapping("/cashrecordadd")
    public ModelAndView add(CashRecord cashRecord) {
        cashRecordServiceImpl.insert(cashRecord);
        modelAndView.setViewName("forward:/cash_record/cashrecordlist");
        return modelAndView;
    }

    @RequestMapping("/cashrecordQuery")
    public ModelAndView selectByCondition(Integer currentPage,String cashDate) {
        currentPage = (currentPage == null) ? 1 : currentPage;
        CASHDATE=cashDate;
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<CashRecord> list = cashRecordServiceImpl.selectByCashDate(cashDate);
        // 取分页信息
        PageInfo<CashRecord> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        modelAndView.setViewName("cash_record/cashrecordlist");
        modelAndView.addObject("cashDate", cashDate);
        modelAndView.addObject("cashrecords", list);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", total);
        modelAndView.addObject("lastPage", lastPage);
        return modelAndView;
    }

    @RequestMapping("/queryRollpage")
    public @ResponseBody
    Map<String, Object> selectByCondition(@RequestBody Map<String, Integer> current) {
        Map<String, Object> model = new HashMap<String, Object>();
        Integer currentPage = current.get("currentPage");
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<CashRecord> list = cashRecordServiceImpl.selectByCashDate(CASHDATE);
        // 取分页信息
        PageInfo<CashRecord> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        model.put("cashRecords", list);
        model.put("currentPage", currentPage);
        model.put("totalCount", total);
        model.put("lastPage", lastPage);
        return model;
    }

    @RequestMapping("/selectById")
    public ModelAndView selectById(Integer id){
        cashRecordServiceImpl.selectById(id);
        modelAndView.setViewName("/cash_record/cashrecordlist");
        return modelAndView;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(CashRecord cashRecord){
        cashRecordServiceImpl.insert(cashRecord);
        Integer integer =BOOKNUMBER-cashRecord.getBookNumber();
        bookServiceImpl.updateBookNumberById(BOOKID, integer);
        modelAndView.setViewName("forward:/cash_record/cashrecordlist");
        return modelAndView;
    }

    @RequestMapping("/recycle")
    public ModelAndView recycle(Integer id) {
        Recycle recycle=new Recycle();
        recycle.setTableName("cash_record");
        recycle.setRecordId(id);
        Date date=new Date();
        recycle.setDeleteTime(date);
        recycelServiceImpl.insert(recycle);
        cashRecordServiceImpl.recycleById(id);
        modelAndView.setViewName("forward:/cash_record/cashrecordlist");
        return modelAndView;
    }

    @RequestMapping("/getBookPrice")
    public @ResponseBody Map<String,Object> getBookPrice(@RequestBody Map<String,Object> map){
        Integer id=Integer.parseInt(map.get("id").toString());
        BOOKID=id;
        Book book= bookServiceImpl.selectById(id);
        Map<String,Object> map1=new HashMap<>();
        map1.put("book", book);
        return map1;
    }

    @RequestMapping("/selectBookNumberById")
    public @ResponseBody
    Map<String, Object> selectBookNumberById(@RequestBody Map<String, Object> current) {
        Map<String, Object> model = new HashMap<>();
        Integer id = Integer.parseInt(current.get("id").toString());
        Book book = bookServiceImpl.selectById(id);
        Integer bookNumber=book.getBookNumber();
        BOOKNUMBER=bookNumber;
        model.put("bookNumber", bookNumber);
        return model;
    }
}
