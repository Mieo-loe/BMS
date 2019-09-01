package com.tencent.dao;

import com.tencent.model.Card;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository("cardDao")
public interface ICardDao {

    /**
     * 通过id修改会员卡信息
     * @param id 会员卡id
     */
    @Update("update card set isdelete=1 where id=#{id}")
    void recycle(Integer id);

    /**
     * 通过id删除会员卡信息
     * @param id 会员卡id
     */
    @Delete("delete from card where id=#{id}")
    void deleteById(Integer id);

    /**
     * 添加会员卡信息
     * @param card 需要添加的会员卡对象
     */
    @Insert("insert into card (createDate, expirationDate,discount,cus_id, sta_id)" +
            " values (#{createDate},#{expirationDate},#{discount},#{cusId},#{staId});")
    void insert(Card card);

    /**
     * 修改会员卡信息
     * @param card 修改的会员卡对象
     */
    @Update("UPDATE card set createDate=#{createDate},expirationDate=#{expirationDate},discount=#{discount},cus_id=#{cusId},sta_id=#{staId} where id=#{id}")
    void update(Card card);

    /**
     * 查询卡片和持有者以及员工详细信息信息
     *
     * @return 查询结果
     */
    @Select("select * from card where isdelete=0 order by id")
    @Results(id = "cardAndCustomerAndStaff", value = {
            @Result(property = "cusId",column = "cus_id"),
            @Result(property = "staId",column = "sta_id"),
           @Result(property = "customer",column = "cus_id",one = @One(select = "com.tencent.dao.ICustomerDao.selectById")),
            @Result(property = "staff",column = "sta_id",one=@One(select = "com.tencent.dao.IStaffDao.selectById"))
    })
    List<Card> selectAllAndCustomerAndStaff();

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Select("select * from card where isdelete=0")
    @ResultMap(value="cardAndCustomerAndStaff")
    List<Card> selectAll();

    /**
     * 查找所有会员卡信息和持有者和员工的详细信息
     * @param id 会员卡id
     * @return 查询结果
     */
    @Select("select * from card where isdelete=0 and id like CONCAT('%',#{id},'%') ")
    @ResultMap(value = "cardAndCustomerAndStaff")
    List<Card> selectAllAndCustomerAndStaffById(Integer id);

    /**
     * 通过id查询会员卡的信息
     * @param id 会员卡id
     * @return 查询结果
     */
    @Select("select * from card where id=#{id}")
    Card selectById(Integer id);
}
