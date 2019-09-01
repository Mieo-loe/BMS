package com.tencent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.dao.ICardDao;
import com.tencent.model.Card;
import com.tencent.model.Recycle;
import com.tencent.service.ICardService;
import com.tencent.service.IRecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/card")
public class CardController {
    private static Integer ID;
    @Autowired
    ICardService cardServiceImpl;
    @Autowired
    IRecycleService recycelServiceImpl;
    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("/cardlist")
    public ModelAndView selectAll(Integer currentPage) {
        ID = null;
        currentPage = (currentPage == null) ? 1 : currentPage;
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Card> list = cardServiceImpl.selectAllAndCustomerAndStaff();
        // 取分页信息
        PageInfo<Card> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastpage = pageInfo.getLastPage();
        modelAndView.setViewName("/card/cardlist");
        modelAndView.addObject("cards", list);
        modelAndView.addObject("id", ID);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", total);
        modelAndView.addObject("lastPage", lastpage);
        return modelAndView;
    }

    @RequestMapping("/rollpage")
    public @ResponseBody
    Map<String, Object> selectAllAjax(@RequestBody Map<String, Integer> current) {
        ID = null;
        Map<String, Object> model = new HashMap<String, Object>();
        Integer currentPage = current.get("currentPage");
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Card> list = cardServiceImpl.selectAllAndCustomerAndStaff();
        // 取分页信息
        PageInfo<Card> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        model.put("cards", list);
        model.put("currentPage", currentPage);
        model.put("totalCount", total);
        model.put("lastPage", lastPage);
        return model;
    }

    @RequestMapping("/cardQuery")
    public ModelAndView selectByCondition(Integer currentPage, Integer id) {
        currentPage = (currentPage == null) ? 1 : currentPage;
        ID = id;
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Card> list = cardServiceImpl.selectAllAndCustomerAndStaffById(ID);
        // 取分页信息
        PageInfo<Card> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastpage = pageInfo.getLastPage();
        modelAndView.setViewName("card/cardlist");
        modelAndView.addObject("id", id);
        modelAndView.addObject("cards", list);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", total);
        modelAndView.addObject("lastPage", lastpage);
        return modelAndView;
    }

    @RequestMapping("/queryRollpage")
    public @ResponseBody
    Map<String, Object> selectByCondition(@RequestBody Map<String, Object> current) {
        Map<String, Object> model = new HashMap<String, Object>();
        Integer currentPage = Integer.parseInt(current.get("currentPage").toString());
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(currentPage, 10);
        List<Card> list = cardServiceImpl.selectAllAndCustomerAndStaffById(ID);
        // 取分页信息
        PageInfo<Card> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        int lastPage = pageInfo.getLastPage();
        model.put("cards", list);
        model.put("currentPage", currentPage);
        model.put("totalCount", total);
        model.put("lastPage", lastPage);
        return model;
    }

    @RequestMapping("/selectByIdForCheck")
    public @ResponseBody
    Map<String, Object> selectByIdForCheck(@RequestBody Map<String, Object> current) throws ParseException {
        Map<String, Object> model = new HashMap<String, Object>();
        Integer id = Integer.parseInt(current.get("id").toString());
        Card card = cardServiceImpl.selectById(id);
        model.put("card", card);
        return model;
    }

    @RequestMapping("/selectById")
    public @ResponseBody
    Map<String, Object> selectById(@RequestBody Map<String, Object> current) throws ParseException {
        Map<String, Object> model = new HashMap<String, Object>();
        Integer id = Integer.parseInt(current.get("id").toString());
        Card card = cardServiceImpl.selectById(id);
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate=new Date();
        String nowDateString=dateFormat.format(nowDate);
        nowDate=dateFormat.parse(nowDateString);
        Date expirationDate=dateFormat.parse(card.getExpirationDate());
        long RT=expirationDate.getTime()-nowDate.getTime();
        if(RT<0){
            String RTD="会员卡到期了";
            card.setDiscount(1d);
            model.put("RT", RTD);
        }else{
            long RTD=RT/(1000 * 60 * 60 * 24);
            model.put("RT", RTD);
        }
        model.put("card", card);
        return model;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(Card card) {
        cardServiceImpl.insert(card);
        modelAndView.setViewName("forward:/card/cardlist");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(Card card) {
        cardServiceImpl.update(card);
        modelAndView.setViewName("forward:/card/cardlist");
        return modelAndView;
    }

    @RequestMapping("/recycle")
    public ModelAndView recycle(Integer id) {
        Recycle recycle=new Recycle();
        recycle.setTableName("card");
        recycle.setRecordId(id);
        Date date=new Date();
        recycle.setDeleteTime(date);
        recycelServiceImpl.insert(recycle);
        cardServiceImpl.recycle(id);
        modelAndView.setViewName("forward:/card/cardlist");
        return modelAndView;
    }
}
