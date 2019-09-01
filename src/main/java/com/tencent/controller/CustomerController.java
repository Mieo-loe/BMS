package com.tencent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.dao.IRecycleDao;
import com.tencent.model.Customer;
import com.tencent.model.Recycle;
import com.tencent.service.ICustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerServiceImpl;
    @Autowired
    IRecycleService recycleServiceImpl;
    private static String CUSTOMERNAME;
    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("/customerlist")
    public ModelAndView select(Integer currentPage) {
        CUSTOMERNAME=null;
        currentPage = (currentPage == null) ? 1 : currentPage;
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Customer> customers = customerServiceImpl.selectAllAndStaff();
        // 取分页信息
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        /*获取书籍分类信息*/
        modelAndView.addObject("customerName", CUSTOMERNAME);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", total);
        modelAndView.addObject("lastPage", lastPage);
        modelAndView.setViewName("/customer/customerlist");
        return modelAndView;
    }

    @RequestMapping("/rollPage")
    public @ResponseBody
    Map<String, Object> selectAllAjax(@RequestBody Map<String, Integer> current) {
        Map<String, Object> model = new HashMap<String, Object>();
        Integer currentPage = current.get("currentPage");
        System.out.println("currentPage = " + currentPage);
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Customer> list = customerServiceImpl.selectAllAndStaff();
        // 取分页信息
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        model.put("customers", list);
        model.put("currentPage", currentPage);
        model.put("totalCount", total);
        model.put("lastPage", lastPage);
        return model;
    }

    @RequestMapping("/customerQuery")
    public ModelAndView selectByCondition(Integer currentPage,String customerName) {
        currentPage = (currentPage == null) ? 1 : currentPage;
        CUSTOMERNAME=customerName;
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Customer> customers = customerServiceImpl.selectByCustomerName(customerName);
        // 取分页信息
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        /*获取书籍分类信息*/
        modelAndView.addObject("customerName", customerName);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", total);
        modelAndView.addObject("lastPage", lastPage);
        modelAndView.setViewName("/customer/customerlist");
        return modelAndView;
    }

    @RequestMapping("/queryRollPage")
    public @ResponseBody
    Map<String, Object> selectByCondition(@RequestBody Map<String, Integer> current) {
        Map<String, Object> model = new HashMap<String, Object>();
        Integer currentPage = current.get("currentPage");
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Customer> list = customerServiceImpl.selectByCustomerName(CUSTOMERNAME);
        // 取分页信息
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        model.put("customers", list);
        model.put("currentPage", currentPage);
        model.put("totalCount", total);
        model.put("lastPage", lastPage);
        return model;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(Customer customer){
        customerServiceImpl.insert(customer);
        modelAndView.setViewName("forward:/customer/customerlist");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(Customer customer){
        customerServiceImpl.update(customer);
        modelAndView.setViewName("forward:/customer/customerlist");
        return modelAndView;
    }

    @RequestMapping("/recycle")
    public ModelAndView recycle(Integer id){
        Recycle recycle=new Recycle();
        recycle.setTableName("customer");
        recycle.setRecordId(id);
        Date date=new Date();
        recycle.setDeleteTime(date);
        recycleServiceImpl.insert(recycle);
        customerServiceImpl.recycle(id);
        modelAndView.setViewName("forward:/customer/customerlist");
        return modelAndView;
    }

    @RequestMapping("/selectById")
    public @ResponseBody
    Map<String, Object> selectById(@RequestBody Map<String, Object> current) {
        Map<String, Object> model = new HashMap<>();
        Integer id = Integer.parseInt(current.get("id").toString());
       Customer customer= customerServiceImpl.selectById(id);
        model.put("customer", customer);
        return model;
    }
}
