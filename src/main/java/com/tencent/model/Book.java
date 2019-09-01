package com.tencent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(value = {"handler"})
public class Book implements Serializable {
    private Integer id;

    private String bookCode;

    private String bookName;

    private Double bookPrice;

    private Integer bookNumber;

    private String bookCategory;

    private String bookDate;

    private Integer staId;

    private Staff staff;


    private String deleteTime;

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public Integer getStaId() {
        return staId;
    }

    public void setStaId(Integer staId) {
        this.staId = staId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookCode='" + bookCode + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookNumber=" + bookNumber +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookDate='" + bookDate + '\'' +
                ", staId=" + staId +
                ", staff=" + staff +
                '}';
    }
}