package com.tencent.service.impl;

import com.tencent.dao.ICashRecordDao;
import com.tencent.model.CashRecord;
import com.tencent.service.ICashRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class CashRecordServiceImpl implements ICashRecordService {
    @Autowired
    ICashRecordDao cashRecordDao;
    @Override
    public List<CashRecord> selectAll() {
        return cashRecordDao.selectAll();
    }

    @Override
    public void recycleById(Integer id) {
        cashRecordDao.recycleById(id);
    }

    @Override
    public void deleteById(Integer id) {
            cashRecordDao.deleteById(id);
    }

    @Override
    public void insert(CashRecord cashRecord) {
            cashRecordDao.insert(cashRecord);
    }

    @Override
    public List<CashRecord> selectForEcharts() {
        return cashRecordDao.selectForEcharts();
    }

    @Override
    public CashRecord selectById(Integer id) {
        return cashRecordDao.selectById(id);
    }

    @Override
    public List<CashRecord> selectByCashDate(String cashDate) {
        return cashRecordDao.selectByCashDate(cashDate);
    }
}
