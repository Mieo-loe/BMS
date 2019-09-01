package com.tencent.controller.echarts;

import com.tencent.dao.ICashRecordDao;
import com.tencent.model.Book;
import com.tencent.model.CashRecord;
import com.tencent.service.ICashRecordService;
import com.tencent.util.expection.ErrorExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.NewThreadAction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/echarts")
public class echartsController {
    @Autowired
    ICashRecordService cashRecordServiceImpl;
    class Line{
        private String cashDate;
        private Double cashAmount;
        private Double cashProfit;

        public String getCashDate() {
            return cashDate;
        }

        public void setCashDate(String cashDate) {
            this.cashDate = cashDate;
        }

        public Double getCashAmount() {
            return cashAmount;
        }

        public void setCashAmount(Double cashAmount) {
            this.cashAmount = cashAmount;
        }

        public Double getCashProfit() {
            return cashProfit;
        }

        public void setCashProfit(Double cashProfit) {
            this.cashProfit = cashProfit;
        }
    }

    @RequestMapping("/lineChart")
    public @ResponseBody
    List<Line> lineChart() throws ErrorExpection, ParseException {
        System.out.println("cashRecordDao= = ============================================================================");
        List<Line> lines=new ArrayList<Line>();
        //查询最近的消费记录
        List<CashRecord> cashRecords=cashRecordServiceImpl.selectForEcharts();
        for (CashRecord cashRecord : cashRecords) {
          if(lines.size()<30){
              Line line=new Line();
//              DateFormat dateFormat=new SimpleDateFormat("MM:dd");
//             Date date= dateFormat.parse(cashRecord.getCashDate());
//             String dateString=dateFormat.format(date);
              line.setCashDate(cashRecord.getCashDate());
              line.setCashAmount(cashRecord.getCashAmount());
              line.setCashProfit(cashRecord.getCashProfit());
              lines.add(line);
          }else {
              break;
          }
        }
        List<Line> lines1=new ArrayList<>();
        for(int i=lines.size()-1;i>=0;i--){
            lines1.add(lines.get(i));
        }
        return lines1;
    }
}
