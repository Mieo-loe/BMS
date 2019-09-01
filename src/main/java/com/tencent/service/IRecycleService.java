package com.tencent.service;

import com.tencent.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRecycleService {
    /**
     * 插入删除记录
     *
     * @param recycle 删除记录
     */
    void restore(Recycle recycle);

    /**
     * 根据记录id删除回收站信息
     *
     * @param recordId 记录id
     */
    void delete(Integer recordId);

    /**
     * 插入删除记录
     *
     * @param recycle 删除记录
     */
    void insert(Recycle recycle);

    /**
     * 通过记录id查询回收站信息
     *
     * @param id 删除记录id
     * @return 查询结果
     */
    Recycle selectByRecordId(Integer id);

    /**
     * 通过表名查询删除记录
     *
     * @param tableName 表名
     * @return 查询结果
     */
    List<Recycle> selectAll(String tableName);

    /**
     * 通过记录id查询所有书本信息
     *
     * @param recycle 删除记录
     * @return 查询结果
     */
    Book bookSelectAll(Recycle recycle);

    /**
     * 通过删除记录查询删除的员工信息
     *
     * @param recycle 删除记录
     * @return 查询结果
     */
    Customer custoemrSelectAll(Recycle recycle);

    /**
     * 通过删除记录查询删除的会员卡信息
     *
     * @param recycle 删除记录
     * @return 查询结果
     */
    Card cardSeletcAll(Recycle recycle);

    /**
     * 通过删除记录查询删除的消费记录信息
     *
     * @param recycle 删除记录
     * @return 查询结果
     */
    CashRecord cashRecordSelectAll(Recycle recycle);
}
