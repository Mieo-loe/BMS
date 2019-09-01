package com.tencent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(value = {"handler"})
public class CashRecord implements Serializable {
    private Integer id;

    private String cashDate;

    private Double cashAmount;

    private Double cashProfit;

    private Integer booId;

    private Integer carId;

    private Integer staId;
    private Book book;
    private Integer bookNumber;
    private Card card;

    private Staff staff;

    private Integer idDelete;
    private String deleteTime;

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
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

    public Integer getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(Integer idDelete) {
        this.idDelete = idDelete;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCashDate() {
        return cashDate;
    }

    public void setCashDate(String cashDate) {
        this.cashDate = cashDate;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Double getCashProfit() {
        return cashProfit;
    }

    public void setCashProfit(Double cashProfit) {
        this.cashProfit = cashProfit;
    }

    public Integer getBooId() {
        return booId;
    }

    public void setBooId(Integer booId) {
        this.booId = booId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "CashRecord{" +
                "id=" + id +
                ", cashDate='" + cashDate + '\'' +
                ", cashAmount=" + cashAmount +
                ", cashProfit=" + cashProfit +
                ", booId=" + booId +
                ", carId=" + carId +
                ", book=" + book +
                ", card=" + card +
                '}';
    }
}