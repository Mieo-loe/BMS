package com.tencent.controller.recycle;

import com.tencent.model.CashRecord;
import com.tencent.model.Recycle;
import com.tencent.service.ICashRecordService;
import com.tencent.service.IRecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recycleCashRecord")
public class RecycleCashRecordController {
    @Autowired
    IRecycleService recycelServiceImpl;
    @Autowired
    ICashRecordService cashRecordServiceImpl;
    private static String CASHDATE;
    private static List<CashRecord> CASHRECORDS;
    private ModelAndView modelAndView=new ModelAndView();
    @RequestMapping("/cashrecordlist")
    public ModelAndView selectAll(){
        CASHDATE=null;
    List<Recycle> recycles= recycelServiceImpl.selectAll("cash_record");
    List<CashRecord> cashRecords=new ArrayList<>();
        for (Recycle recycle : recycles) {
            CashRecord cashRecord= recycelServiceImpl.cashRecordSelectAll(recycle);
            cashRecord.setDeleteTime(recycle.getDeleteTime());
           cashRecords.add(cashRecord);
        }
        CASHRECORDS=cashRecords;
        modelAndView.addObject("cashDate",CASHDATE);
        modelAndView.addObject("cashRecords", CASHRECORDS);
        modelAndView.setViewName("/recycle/recyclecash");
        return modelAndView;
    }

    @RequestMapping("/restore")
    public ModelAndView restore(Integer id){
        Recycle recycle= recycelServiceImpl.selectByRecordId(id);
        recycelServiceImpl.restore(recycle);
        recycelServiceImpl.delete(id);
        modelAndView.setViewName("forward:/recycleCashRecord/cashrecordlist");
        return modelAndView;
    }

    @RequestMapping("/query")
    public ModelAndView selectByCondition(String cashDate){
        List<CashRecord> list=new ArrayList<>();
        for (CashRecord cashRecord : CASHRECORDS) {
            if(!"".equals(cashDate)){
                if(cashDate.equals(cashRecord.getCashDate())){
                    list.add(cashRecord);
                }
            }
        }
        modelAndView.addObject("cashRecords", list);
        modelAndView.addObject("cashDate", cashDate);
        return modelAndView;
    }

    @RequestMapping("/remove")
    public ModelAndView deleteAll(){
        for (CashRecord cashrecord : CASHRECORDS) {
            cashRecordServiceImpl.deleteById(cashrecord.getId());
            recycelServiceImpl.delete(cashrecord.getId());
        }
        modelAndView.setViewName("forward:/recycleCashRecord/cashrecordlist");
        return modelAndView;
    }
}
