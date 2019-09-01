package com.tencent.dao;

import com.tencent.model.CashRecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository("cashRecordDao")
public interface ICashRecordDao {
    /**
     * 查询消费记录和对应的书籍id和会员卡
     *
     * @return 查询结果
     */
    @Select("select * from cash_record where isdelete=0")
    @Results(id = "cashRecordAndBookAndCard", value = {
            @Result(property = "bookId",column = "book_id"),
            @Result(property = "carId",column = "car_id"),
            @Result(property = "staId",column = "sta_id"),
            @Result(property = "staff",column = "sta_id",one = @One(select = "com.tencent.dao.IStaffDao.selectById")),
            @Result(property = "book",column = "boo_id",one = @One(select = "com.tencent.dao.IBookDao.selectById")),
            @Result(property = "card",column = "car_id",one = @One(select = "com.tencent.dao.ICardDao.selectById"))
    })
    List<CashRecord> selectAll();

    /**
     * 把记录放入回收站
     *
     * @param id 消费记录id
     */
    @Update("update cash_record set isdelete = 1 where id=#{id}")
    void recycleById(Integer id);

    /**
     * 彻底删除消费记录
     * @param id 消费记录id
     */
    @Delete("delete from cash_record where id=#{id}")
    void deleteById(Integer id);

    /**
     * 插入消费记录
     * @param cashRecord 需要插入的消费记录对象
     */
    @Insert("insert into cash_record (cashDate, cashAmount, cashProfit, boo_id, car_id, sta_id) " +
            "values (#{cashDate},#{cashAmount},#{cashProfit},#{booId},#{carId},#{staId});")
    void insert(CashRecord cashRecord );

    /**
     * 通过消费记录时间倒叙查询（获得最新的消费记录）
     * @return 查询结果
     */
    @Select("select cashDate,sum(cashAmount) cashAmount,sum(cashProfit) cashProfit from cash_record group by cashDate order by cashDate desc")
    List<CashRecord> selectForEcharts();

    /**
     * 通过id查询消费记录信息
     *
     * @param id 消费记录id
     * @return 查询结果
     */
    @Select("select * from cash_record where isdelete=0 and id=#{id}")
   CashRecord selectById(Integer id);

    /**
     * 通过消费记录时间查询
     *
     * @param cashDate 消费记录时间
     * @return 查询结果
     */
    @Select(" <script>" +
            " select * from cashrecordandbookandcard where isdelete=0" +
            " <if test='cashDate != null'>" +
            " and cashDate=#{cashDate}" +
            " </if>" +
            " </script>")
    @ResultMap(value = "cashRecordAndBookAndCard")
    List<CashRecord> selectByCashDate(@Param("cashDate") String cashDate);


}
