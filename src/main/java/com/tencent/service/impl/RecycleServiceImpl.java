package com.tencent.service.impl;

import com.tencent.dao.IRecycleDao;
import com.tencent.model.*;
import com.tencent.service.IRecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class RecycleServiceImpl implements IRecycleService {
    @Autowired
    IRecycleDao recycleDao;
    @Override
    public void restore(Recycle recycle) {
        recycleDao.restore(recycle);
    }

    @Override
    public void delete(Integer recordId) {
        recycleDao.delete(recordId);
    }

    @Override
    public void insert(Recycle recycle) {
        recycleDao.insert(recycle);
    }

    @Override
    public Recycle selectByRecordId(Integer id) {
        return recycleDao.selectByRecordId(id);
    }

    @Override
    public List<Recycle> selectAll(String tableName) {
        return recycleDao.selectAll(tableName);
    }

    @Override
    public Book bookSelectAll(Recycle recycle) {
        return recycleDao.bookSelectAll(recycle);
    }

    @Override
    public Customer custoemrSelectAll(Recycle recycle) {
        return recycleDao.custoemrSelectAll(recycle);
    }

    @Override
    public Card cardSeletcAll(Recycle recycle) {
        return recycleDao.cardSeletcAll(recycle);
    }

    @Override
    public CashRecord cashRecordSelectAll(Recycle recycle) {
        return recycleDao.cashRecordSelectAll(recycle);
    }
}
