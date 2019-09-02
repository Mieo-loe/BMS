package com.tencent.service.impl;

import com.tencent.dao.ICardDao;
import com.tencent.model.Card;
import com.tencent.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class CardServiceImpl  implements ICardService {

    private final
    ICardDao cardDao;

    @Autowired
    public CardServiceImpl(ICardDao cardDao) {this.cardDao = cardDao;}

    @Override
    public void recycle(Integer id) {
        cardDao.recycle(id);
    }

    @Override
    public void deleteById(Integer id) {
        cardDao.deleteById(id);
    }

    @Override
    public void insert(Card card) {
        cardDao.insert(card);
    }

    @Override
    public void update(Card card) {
        cardDao.update(card);
    }

    @Override
    public List<Card> selectAllAndCustomerAndStaff() {
        return cardDao.selectAllAndCustomerAndStaff();
    }

    @Override
    public List<Card> selectAll() {
        return cardDao.selectAll();
    }

    @Override
    public List<Card> selectAllAndCustomerAndStaffById(Integer id) {
        return cardDao.selectAllAndCustomerAndStaffById(id);
    }

    @Override
    public Card selectById(Integer id) {
        return cardDao.selectById(id);
    }
}
