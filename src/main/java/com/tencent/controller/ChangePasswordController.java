package com.tencent.controller;

import com.tencent.dao.IStaffDao;
import com.tencent.model.Staff;
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
@RequestMapping("/changePassword")
public class ChangePasswordController {
    @Autowired
    IStaffService staffServiceImpl;
    @RequestMapping("/verifyUsername")
    public @ResponseBody
    Map<String, String> verifyUsername(@RequestBody Map<String, Object> user) {
        Map<String ,String> map=new HashMap<>();
        map.put("msg", "<font color=\"green\" size=\"3px\">用户名可用</font>");
        List<String> list = staffServiceImpl.selectStaffUsername();
        for (String s : list) {
            if (s.equals(user.get("username"))) {
                map.put("msg", "<font color=\"red\" size=\"3px\">用户名已存在</font>");
                return map;
            }
        }
        return map;

    }

    @RequestMapping("/changePassword")
    public ModelAndView changePassword(Staff staff){
        Map<String,String> map=new HashMap<>();
        staffServiceImpl.updatePasswordById(staff);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("forward:/login.jsp");
        return modelAndView;
    }
}
