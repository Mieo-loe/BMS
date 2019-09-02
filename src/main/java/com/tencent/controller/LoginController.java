package com.tencent.controller;

import com.tencent.dao.IStaffDao;
import com.tencent.model.Staff;
import com.tencent.service.IStaffService;
import com.tencent.util.expection.ErrorExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    IStaffService staffServiceImpl;

    @RequestMapping("/verifyUsername")
    public @ResponseBody
    Map<String, String> verifyUsername(@RequestBody Map<String, String> userCode) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "<font color=\"red\" size=\"3px\">用户名不存在</font>");
        List<String> list = staffServiceImpl.selectStaffUsername();
        for (String s : list) {
            if (s.equals(userCode.get("username"))) {
                map.put("msg", "<font color=\"green\" size=\"3px\">用户名正确</font>");
                return map;
            }
        }
        return map;
    }

    @RequestMapping("/verifyUsernameAndPassword")
    public ModelAndView verifyUsernameAndPassword(String username, String password,HttpServletRequest request) throws ErrorExpection {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session=request.getSession();
        modelAndView.addObject("msg", "<font size=\"3px\" color=\"red\">密码错误，请重试</font>");
        modelAndView.setViewName("forward:/login.jsp");
        List<Staff> list = staffServiceImpl.selectAll();
        for (Staff staff : list) {
            if (staff.getStaffUsername().equals(username) && staff.getStaffPassword().equals(password)) {
                //判断是否是管理员
                if (staff.getId() == 0) {
                    session.setAttribute("user", staff);
                    session.setAttribute("userId", staff.getId());
                    modelAndView.setViewName("frame_plus");
                }
                //如果是员工判断是否有进入权限
                else if (staff.getStaffPermission() == 1) {
                    Date date1 = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                    //那时间中的日期去掉
                    String s=dateFormat.format(date1);
                    String startWorkTime = staff.getStartWorktime();
                    String endWorkTime = staff.getEndWorktime();
                    Date startWorkDate;
                    Date endWorkDate;
                    Date date;
                    try {
                        date=dateFormat.parse(s);
                        startWorkDate = dateFormat.parse(startWorkTime);
                        endWorkDate = dateFormat.parse(endWorkTime);
                        //如果员工在上班时间内，可以登录;否则不行
                    } catch (Exception e) {
                        throw new ErrorExpection("日期解析错误");
                    }
                    if (startWorkDate.getTime() <= date.getTime() && endWorkDate.getTime() >= date.getTime()) {
                        session.setAttribute("user", staff);
                        session.setAttribute("userId", staff.getId());
                        modelAndView.setViewName("frame");
                    }else{
                        modelAndView.addObject("msg", "<font size=\"3px\" color=\"red\">对不起，你不在工作时间内，无法登录</font>");
                    }
                } else {
                    modelAndView.addObject("msg", "<font size=\"3px\" color=\"red\">对不起，您没有进入权限</font>");
                }
            }
        }
        return modelAndView;
    }
}
