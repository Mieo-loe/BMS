package com.tencent.service;

import com.tencent.model.CashRecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICashRecordService {
    /**
     * 查询消费记录和对应的书籍id和会员卡
     *
     * @return 查询结果
     */
    List<CashRecord> selectAll();

    /**
     * 把记录放入回收站
     *
     * @param id 消费记录id
     */
    void recycleById(Integer id);

    /**
     * 彻底删除消费记录
     * @param id 消费记录id
     */
    void deleteById(Integer id);

    /**
     * 插入消费记录
     * @param cashRecord 需要插入的消费记录对象
     */
    void insert(CashRecord cashRecord );

    /**
     * 通过消费记录时间倒叙查询（获得最新的消费记录）
     * @return 查询结果
     */
    List<CashRecord> selectForEcharts();

    /**
     * 通过id查询消费记录信息
     *
     * @param id 消费记录id
     * @return 查询结果
     */
    CashRecord selectById(Integer id);

    /**
     * 通过消费记录时间查询
     *
     * @param cashDate 消费记录时间
     * @return 查询结果
     */
    List<CashRecord> selectByCashDate(@Param("cashDate") String cashDate);

}
