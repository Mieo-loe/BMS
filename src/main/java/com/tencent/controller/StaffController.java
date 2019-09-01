package com.tencent.controller;

import com.tencent.dao.IRecycleDao;
import com.tencent.dao.IStaffDao;
import com.tencent.model.Staff;
import com.tencent.service.IRecycleService;
import com.tencent.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    IStaffService staffServiceImpl;
    @Autowired
    IRecycleService recycleServiceImpl;
    public ModelAndView modelAndView=new ModelAndView();
    public static List<Staff> STAFFS;
    public static String STAFFNAME;
    
    @RequestMapping("/stafflist")
    public ModelAndView selectAll() {
       List<Staff> staffs= staffServiceImpl.selectAll();
       STAFFS=staffs;
       STAFFNAME=null;
        modelAndView.addObject("staffs", staffs);
        modelAndView.addObject("staffName", STAFFNAME);
        modelAndView.setViewName("/staff/stafflist");
        return modelAndView;
    }
    
    @RequestMapping("/selectById")
    public @ResponseBody
    Map<String, Object> selectById(@RequestBody Map<String, Object> args) {
        Integer id = Integer.parseInt(args.get("id").toString());
        Map<String, Object> map = new HashMap<>();
        Staff staff = staffServiceImpl.selectById(id);
        map.put("staff", staff);
        return map;
    }

    @RequestMapping("/staffQuery")
    public ModelAndView selectByCondition( String staffName) {
        STAFFNAME = staffName;
        List<Staff> staffs = staffServiceImpl.selectByCondition(staffName);
        modelAndView.addObject("staffName", STAFFNAME);
        modelAndView.addObject("staffs", staffs);
        modelAndView.setViewName("/staff/stafflist");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(Staff staff) {
        staffServiceImpl.updateById(staff);
        modelAndView.setViewName("forward:/staff/stafflist");
        return modelAndView;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(Staff staff) {
        staffServiceImpl.insert(staff);
        modelAndView.setViewName("forward:/staff/stafflist");
        return modelAndView;
    }
    @RequestMapping("/delete")
    public ModelAndView insert(Integer id) {
        staffServiceImpl.delete(id);
        modelAndView.setViewName("forward:/staff/stafflist");
        return modelAndView;
    }

    @RequestMapping("/frame_plus")
    public ModelAndView framePlus(){
        modelAndView.setViewName("frame_plus");
        return modelAndView;
    }
}
