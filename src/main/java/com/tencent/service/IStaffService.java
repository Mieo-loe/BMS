package com.tencent.service;

import com.tencent.model.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  interface IStaffService {
    /**
     * 插入员工信息
     * @param staff 插入的员工对象
     */
    void insert(Staff staff);

    /**
     * 通过员工id删除记录
     * @param id 员工id
     */
    void delete(Integer id);

    /**
     * 修改员工信息
     * @param staff 修改的员工对象
     */
    void updateById(Staff staff);

    /**
     * 查询所有员工账号（用于ajax校验）
     * @return 查询结果
     */
    List<String> selectStaffUsername();

    /**
     * 查询所有员工信息(包括管理员)
     * @return 查询结果
     */
    List<Staff> selectAll();

    /**
     * 通过员工信息查询记录
     * @param staffName 员工名
     * @return 查询结果
     */
    List<Staff> selectByCondition(String staffName);

    /**
     * 通过id查询员工信息
     * @return 查询结果
     */
    Staff selectById(Integer id);

    /**
     * 通过用户id修改用户密码
     * @param staff 要修改密码的用户对象
     */
    void updatePasswordById(Staff staff);
}
