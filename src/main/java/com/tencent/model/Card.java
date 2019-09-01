package com.tencent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Date;
@JsonIgnoreProperties(value = {"handler"})
public class Card implements Serializable {
    private Integer id;

    private String createDate;

    private String expirationDate;

    private Double discount;

    private Integer cusId;

    private Integer staId;

    private Customer customer;

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getStaId() {
        return staId;
    }

    public void setStaId(Integer staId) {
        this.staId = staId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", createDate='" + createDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", discount=" + discount +
                ", cusId=" + cusId +
                ", staId=" + staId +
                ", customer=" + customer +
                ", staff=" + staff +
                '}';
    }
}