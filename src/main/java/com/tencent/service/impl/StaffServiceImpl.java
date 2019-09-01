package com.tencent.service.impl;

import com.tencent.dao.IStaffDao;
import com.tencent.model.Staff;
import com.tencent.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public  class StaffServiceImpl implements IStaffService {
    @Autowired
    IStaffDao staffDao;
    @Override
    public void insert(Staff staff) {
        staffDao.insert(staff);
    }

    @Override
    public void delete(Integer id) {
        staffDao.delete(id);
    }

    @Override
    public void updateById(Staff staff) {
        staffDao.updateById(staff);
    }

    @Override
    public List<String> selectStaffUsername() {
        return staffDao.selectStaffUsername();
    }

    @Override
    public List<Staff> selectAll() {
        return staffDao.selectAll();
    }

    @Override
    public List<Staff> selectByCondition(String staffName) {
        return staffDao.selectByCondition(staffName);
    }

    @Override
    public Staff selectById(Integer id) {
        return staffDao.selectById(id);
    }

    @Override
    public void updatePasswordById(Staff staff) {
            staffDao.updatePasswordById(staff);
    }
}
