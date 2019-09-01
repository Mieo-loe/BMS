package com.tencent.dao;

import com.tencent.model.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository("customerDao")
public interface ICustomerDao {

    /**
     * 把记录放入回收站
     * @param id 用户记录id
     */
    @Update("update customer set isdelete =1 where id=#{id}")
    void recycle(Integer id);

    @Delete("delete from customer where id=#{id}")
    void deleteById(Integer id );

    /**
     * 修改用户信息
     * @param customer 修改的用户对象
     */
    @Update("update customer set customerCode=#{customerCode},customerName=#{customerName},customerPhone=#{customerPhone} where id=#{id}")
    void update(Customer customer);

    /**
     * 插入用户信息
     * @param customer 插入的用户对象
     */
    @Insert("insert into customer (customerCode, customerName, customerPhone, sta_id)" +
            "values (#{customerCode},#{customerName},#{customerPhone},#{staId})")
    void insert(Customer customer);

    /**
     * 查找所有顾客信息，和录入员的详细信息
     * @return  查询结果
     */
    @Select("select * from customer where isdelete=0")
    @Results(id = "customerAndStaff", value = {
            @Result(property = "staId",column = "sta_id"),
            @Result(property = "staff",column = "sta_id",one = @One(select = "com.tencent.dao.IStaffDao.selectById"))
    })
    List<Customer> selectAllAndStaff();

    /**
     * 通过用户名字查找用户信息
     * @param customerName 用户名
     * @return 查询结果
     */
    @Select("select * from customer where isdelete=0 and customerName like CONCAT('%',#{customerName},'%')")
    @ResultMap(value = "customerAndStaff")
    List<Customer> selectByCustomerName(String customerName);

    /**
     * 通过用户id查找用户信息
     * @param id 用户记录id
     * @return 插叙结果
     */
    @Select("select * from customer where id=#{id}")
    Customer selectById(Integer id);

}
