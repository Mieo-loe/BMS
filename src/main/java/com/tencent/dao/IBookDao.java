package com.tencent.dao;

import com.tencent.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository("bookDao")
public
interface IBookDao {

    /**
     * 把记录放入回收站
     *
     * @param id 书本id
     */
    @Update("update book set isdelete = 1 where id=#{id}")
    void recycleById(Integer id);

    /**
     * 永久删除书本记录
     * @param id 书本id
     */
    @Delete("delete from book where id=#{id}")
    void deleteById(Integer id);

    /**
     * 插入图书信息
     * @param book 插入的图书对象
     */
    @Insert("insert into book (bookCode, bookName, bookPrice, bookNumber, bookCategory, bookDate, sta_id)" +
            "values (#{bookCode},#{bookName},#{bookPrice},#{bookNumber},#{bookCategory},#{bookDate},#{staId});")
    void insert(Book book);

    /**
     * 更改书籍数量
     * @param id 书本id
     * @param bookNumber 书本数量
     */
    @Update("update book set bookNumber=#{bookNumber} where id=#{id}")
    void updateBookNumberById(@Param("id") Integer id,@Param("bookNumber") Integer bookNumber);

    /**
     *  更新书本信息
     * @param book 需要更新的书本对象
     */
    @Update("update book set bookCode=#{bookCode},bookName=#{bookName},bookCategory=#{bookCategory},bookNumber=#{bookNumber},bookPrice=#{bookPrice},bookDate=#{bookDate},sta_id=#{staId} where id=#{id}")
    void updateById(Book book);

    /**
     * 查询所有书籍信息
     * @return 查询结果
     */
    @Select("select * from Book where isdelete=0")
    List<Book> selectAll();

    /**
     * 通过id查询书籍信息
     *
     * @param id 书本id
     * @return 查询结果
     */
    @Select("select * from book where id=#{id} and isdelete=0")
    Book selectById(Integer id);

    /**
     * 查询所有书籍信息和员工信息
     *
     * @return 查询结果
     */
    @Select("SELECT * from bookandstaff where isdelete=0 " +
            " order by id ")
    @Results(id = "bookAndStaff", value = {
            @Result(property = "staId", column = "sid"),
            @Result(property = "staff.staffCode", column = "staffCode"),
            @Result(property = "staff.staffName", column = "staffName"),
            @Result(property = "staff.staffSex", column = "staffSex"),
            @Result(property = "staff.staffAddress", column = "staffAddress"),
            @Result(property = "staff.staffUsername", column = "staffUsername"),
            @Result(property = "staff.staffPassword", column = "staffPassword"),
            @Result(property = "staff.staffPhone", column = "staffPhone"),
            @Result(property = "staff.staffPermission", column = "staffPermission"),
            @Result(property = "staff.startWorktime", column = "startWorktime"),
            @Result(property = "staff.endWorktime", column = "endWorktime"),
    })
    List<Book> selectAllAndStaff();

    /**
     * 查询所有书籍分类
     *
     * @return 书籍分类
     */
    @Select("select distinct bookCategory from book where isdelete=0")
    List<String> selectBookCategory();

   /**
    * 通过书本名称查询书籍信息和录入的员工信息
    *
    * @param bookName 书本名称
    * @return 查询结果
    */
   @Select("<script>" +
           "SELECT * from bookandstaff where isdelete=0" +
           " <if test='bookName !=null'>" +
           " and bookName like CONCAT('%',#{bookName},'%')" +
           " </if>" +
           " <if test='bookCategory != null or bookCategory !=\"\"'>" +
           " and bookCategory like CONCAT('%',#{bookCategory},'%')" +
           " </if>" +
           "</script>")
   @ResultMap(value = "bookAndStaff")
   List<Book> selectBookAndStaffByCondition(@Param("bookName") String bookName, @Param("bookCategory") String bookCategory);

}
