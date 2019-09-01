package com.tencent.service;

import com.tencent.model.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerService {
    /**
     * 把记录放入回收站
     *
     * @param id 用户记录id
     */
    void recycle(Integer id);

    void deleteById(Integer id);

    /**
     * 修改用户信息
     *
     * @param customer 修改的用户对象
     */
    void update(Customer customer);

    /**
     * 插入用户信息
     *
     * @param customer 插入的用户对象
     */
    void insert(Customer customer);

    /**
     * 查找所有顾客信息，和录入员的详细信息
     *
     * @return 查询结果
     */
    List<Customer> selectAllAndStaff();

    /**
     * 通过用户名字查找用户信息
     *
     * @param customerName 用户名
     * @return 查询结果
     */
    List<Customer> selectByCustomerName(String customerName);

    /**
     * 通过用户id查找用户信息
     *
     * @param id 用户记录id
     * @return 插叙结果
     */
    Customer selectById(Integer id);
}
