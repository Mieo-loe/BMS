package com.tencent.controller.recycle;

import com.tencent.dao.ICustomerDao;
import com.tencent.dao.IRecycleDao;
import com.tencent.model.Customer;
import com.tencent.model.Recycle;
import com.tencent.service.ICustomerService;
import com.tencent.service.IRecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recycleCustomer")
public class RecycleCustomerController {
    @Autowired
    IRecycleService recycelServiceImpl;
    @Autowired
    ICustomerService customerServiceImpl;
    private static String CUSTOMERNAME;
    private static List<Customer> CUSTOMERS;
    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("/customerlist")
    public ModelAndView selectAll() {
        CUSTOMERNAME=null;
        /*获取书籍分类信息*/
        List<Recycle> recycles = recycelServiceImpl.selectAll("customer");
        List<Customer> customers=new ArrayList<>();
        for (Recycle recycle : recycles) {
            Customer customer = recycelServiceImpl.custoemrSelectAll(recycle);
            customer.setDeleteTime(recycle.getDeleteTime());
            customers.add(customer);
        }
        CUSTOMERS=customers;
        modelAndView.addObject("cutomerName",CUSTOMERNAME );
        modelAndView.addObject("customers", customers);
        modelAndView.setViewName("/recycle/recyclecustomer");
        return modelAndView;
    }

    @RequestMapping("/restore")
    public ModelAndView restore(Integer id){
        Recycle recycle= recycelServiceImpl.selectByRecordId(id);
        recycelServiceImpl.restore(recycle);
        recycelServiceImpl.delete(id);
        modelAndView.setViewName("forward:/recycleCustomer/customerlist");
        return modelAndView;
    }

    @RequestMapping("/query")
    public ModelAndView selectByCondition(String customerName){
        List<Customer> list=new ArrayList<>();
        for (Customer customer : CUSTOMERS) {
            if(!"".equals(customerName)){
                if(customer.getCustomerName().equals(customerName)){
                    list.add(customer);
                }
            }
        }
        modelAndView.addObject("customers", list);
        modelAndView.addObject("customerName", customerName);
        return modelAndView;
    }

    @RequestMapping("/remove")
    public ModelAndView deleteAll(){
        for (Customer customer : CUSTOMERS) {
            customerServiceImpl.deleteById(customer.getId());
            recycelServiceImpl.delete(customer.getId());
        }
        modelAndView.setViewName("forward:/recycleCustomer/customerlist");
        return modelAndView;
    }
}
