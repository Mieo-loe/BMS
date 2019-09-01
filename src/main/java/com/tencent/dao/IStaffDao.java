package com.tencent.dao;

import com.tencent.model.Staff;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository("staffDao")
public interface IStaffDao {

    /**
     * 插入员工信息
     * @param staff 插入的员工对象
     */
    @Insert("insert into staff (staffCode, staffName, staffAddress, staffUsername, staffPassword, staffPhone,start_Worktime,end_Worktime)" +
            " values (#{staffCode},#{staffName},#{staffAddress},#{staffUsername},#{staffPassword},#{staffPhone},#{startWorktime},#{endWorktime}); ")
    void insert(Staff staff);

    /**
     * 通过员工id删除记录
     * @param id 员工id
     */
    @Delete("delete from staff where id=#{id}")
    void delete(Integer id);

    /**
     * 修改员工信息
     * @param staff 修改的员工对象
     */
    @Update("update staff set staffCode=#{staffCode},staffName=#{staffName},staffSex=#{staffSex}," +
            " staffAddress=#{staffAddress},staffUsername=#{staffUsername},staffPassword=#{staffPassword},staffPhone=#{staffPhone}," +
            " staff_Permission=#{staffPermission},start_Worktime=#{startWorktime},end_Worktime=#{endWorktime} " +
            " where id=#{id}")
    void updateById(Staff staff);

    /**
     * 查询所有员工账号（用于ajax校验）
     * @return 查询结果
     */
    @Select("select staffusername from staff")
     List<String> selectStaffUsername();

    /**
     * 查询所有员工信息(包括管理员)
     * @return 查询结果
     */
    @Select("select * from staff")
     List<Staff> selectAll();

    /**
     * 通过员工信息查询记录
     * @param staffName 员工名
     * @return 查询结果
     */
    @Select("select * from staff where staffName like CONCAT('%',#{staffName},'%')")
    List<Staff> selectByCondition(String staffName);

    /**
     * 通过id查询员工信息
     * @return 查询结果
     */
    @Select("select * from staff where id=#{id}")
     Staff selectById(Integer id);

    /**
     * 通过用户id修改用户密码
     * @param staff 要修改密码的用户对象
     */
    @Update("update staff set staffPassword=#{staffPassword} where id=#{id}")
    void updatePasswordById(Staff staff);
}
