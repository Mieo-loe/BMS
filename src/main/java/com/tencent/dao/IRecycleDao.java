package com.tencent.dao;

import com.tencent.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository("recycleDao")
public interface IRecycleDao {

    /**
     * 插入删除记录
     *
     * @param recycle 删除记录
     */
    @Select("update ${tableName} set isdelete=0 where id=#{recordId}")
    void restore(Recycle recycle);

    /**
     * 根据记录id删除回收站信息
     *
     * @param recordId 记录id
     */
    @Delete("delete from recycle where recordid=#{recordId}")
    void delete(Integer recordId);

    /**
     * 插入删除记录
     *
     * @param recycle 删除记录
     */
    @Insert("insert into recycle (tableName, recordId, deleteTime) " +
            "values (#{tableName},#{recordId},#{deleteTime})")
    void insert(Recycle recycle);

    /**
     * 通过记录id查询回收站信息
     *
     * @param id 删除记录id
     * @return 查询结果
     */
    @Select("select * from recycle where recordid=#{id}")
    Recycle selectByRecordId(Integer id);

    /**
     * 通过表名查询删除记录
     *
     * @param tableName 表名
     * @return 查询结果
     */
    @Select("select * from recycle where tableName=#{tableName}")
    List<Recycle> selectAll(String tableName);

    /**
     * 通过记录id查询所有书本信息
     *
     * @param recycle 删除记录
     * @return 查询结果
     */
    @Select("select * from book where id=#{recordId}")
    Book bookSelectAll(Recycle recycle);

    /**
     * 通过删除记录查询删除的员工信息
     *
     * @param recycle 删除记录
     * @return 查询结果
     */
    @Select("select * from customer where id=#{recordId}")
    @Results(id = "customerAndStaff", value = {
            @Result(property = "staId", column = "sta_id"),
            @Result(property = "staff", column = "sta_id", one = @One(select = "com.tencent.dao.IStaffDao.selectById"))
    })
    Customer custoemrSelectAll(Recycle recycle);

    /**
     * 通过删除记录查询删除的会员卡信息
     *
     * @param recycle 删除记录
     * @return 查询结果
     */
    @Select("select * from card where id=#{recordId}")
    @Results(id = "cardAndCustomerAndStaff", value = {
            @Result(property = "cusId", column = "cus_id"),
            @Result(property = "staId", column = "sta_id"),
            @Result(property = "customer", column = "cus_id", one = @One(select = "com.tencent.dao.ICustomerDao.selectById")),
            @Result(property = "staff", column = "sta_id", one = @One(select = "com.tencent.dao.IStaffDao.selectById"))
    })
    Card cardSeletcAll(Recycle recycle);

    /**
     * 通过删除记录查询删除的消费记录信息
     *
     * @param recycle 删除记录
     * @return 查询结果
     */
    @Select("select * from cash_record where id=#{recordId}")
    @Results(id = "cashRecordAndBookAndCard", value = {
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "carId", column = "car_id"),
            @Result(property = "staId", column = "sta_id"),
            @Result(property = "staff", column = "sta_id", one = @One(select = "com.tencent.dao.IStaffDao.selectById")),
            @Result(property = "book", column = "boo_id", one = @One(select = "com.tencent.dao.IBookDao.selectById")),
            @Result(property = "card", column = "car_id", one = @One(select = "com.tencent.dao.ICardDao.selectById"))
    })
    CashRecord cashRecordSelectAll(Recycle recycle);

}
