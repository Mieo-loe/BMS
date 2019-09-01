package com.tencent.service.impl;

import com.tencent.dao.ICustomerDao;
import com.tencent.model.Customer;
import com.tencent.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerDao customerDao;
    @Override
    public void recycle(Integer id) {
        customerDao.recycle(id);
    }

    @Override
    public void deleteById(Integer id) {
        customerDao.deleteById(id);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void insert(Customer customer) {
        customerDao.insert(customer);
    }

    @Override
    public List<Customer> selectAllAndStaff() {
        return customerDao.selectAllAndStaff();
    }

    @Override
    public List<Customer> selectByCustomerName(String customerName) {
        return customerDao.selectByCustomerName(customerName);
    }

    @Override
    public Customer selectById(Integer id) {
        return customerDao.selectById(id);
    }
}
