package com.tencent.service;

import com.tencent.model.Card;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICardService {

    /**
     * 通过id修改会员卡信息
     * @param id 会员卡id
     */
    void recycle(Integer id);

    /**
     * 通过id删除会员卡信息
     * @param id 会员卡id
     */
    void deleteById(Integer id);

    /**
     * 添加会员卡信息
     * @param card 需要添加的会员卡对象
     */
    void insert(Card card);

    /**
     * 修改会员卡信息
     * @param card 修改的会员卡对象
     */
    void update(Card card);

    /**
     * 查询卡片和持有者以及员工详细信息信息
     *
     * @return 查询结果
     */
    List<Card> selectAllAndCustomerAndStaff();

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    List<Card> selectAll();

    /**
     * 查找所有会员卡信息和持有者和员工的详细信息
     * @param id 会员卡id
     * @return 查询结果
     */
    List<Card> selectAllAndCustomerAndStaffById(Integer id);

    /**
     * 通过id查询会员卡的信息
     * @param id 会员卡id
     * @return 查询结果
     */
    Card selectById(Integer id);
}
