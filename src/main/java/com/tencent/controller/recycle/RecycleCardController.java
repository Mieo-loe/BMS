package com.tencent.controller.recycle;

import com.tencent.model.Card;
import com.tencent.model.Recycle;
import com.tencent.service.ICardService;
import com.tencent.service.IRecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recycleCard")
public class RecycleCardController {
    private static List<Card> CARDS = new ArrayList<>();
    private static String ID;
    @Autowired
    IRecycleService recycleServiceImpl;
    @Autowired
    ICardService cardServiceImpl;
    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("/cardlist")
    public ModelAndView selectAll() {
        ID = null;
        /*获取书籍分类信息*/
        List<Recycle> recycles = recycleServiceImpl.selectAll("card");
        List<Card> cards = new ArrayList<>();
        for (Recycle recycle : recycles) {
            Card card = recycleServiceImpl.cardSeletcAll(recycle);
            card.setDeleteTime(recycle.getDeleteTime());
            cards.add(card);
        }
        CARDS = cards;
        modelAndView.addObject("id", ID);
        modelAndView.addObject("cards", cards);
        modelAndView.setViewName("/recycle/recyclecard");
        return modelAndView;
    }

    @RequestMapping("/restore")
    public ModelAndView restore(Integer id) {
        Recycle recycle = recycleServiceImpl.selectByRecordId(id);
        recycleServiceImpl.restore(recycle);
        recycleServiceImpl.delete(id);
        modelAndView.setViewName("forward:/recycleCard/cardlist");
        return modelAndView;
    }

    @RequestMapping("/query")
    public ModelAndView selectByCondition(Integer id) {
        List<Card> cards = new ArrayList<>();
        for (Card card : CARDS) {
            if (card.getId().equals(id)) {
                cards.add(card);
            }
        }
        modelAndView.addObject("id", id);
        modelAndView.addObject("cards", cards);
        modelAndView.setViewName("/recycle/recyclecard");
        return modelAndView;
    }

    @RequestMapping("/remove")
    public ModelAndView deleteAll() {
        for (Card card : CARDS) {
            cardServiceImpl.deleteById(card.getId());
            recycleServiceImpl.delete(card.getId());
        }
        modelAndView.setViewName("forward:/recycleCard/cardlist");
        return modelAndView;
    }

}
