package com.tencent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"handler"})
public class Staff implements Serializable {
    private Integer id;

    private String staffCode;

    private String staffName;

    private String staffSex;

    private String staffAddress;

    private String staffUsername;

    private String staffPassword;

    private String staffPhone;

    private int staffPermission;

    private String startWorktime;

    private String endWorktime;

    private Integer idDelete;

    private String deleteTime;

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
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

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public int getStaffPermission() {
        return staffPermission;
    }

    public void setStaffPermission(int staffPermission) {
        this.staffPermission = staffPermission;
    }

    public String getStartWorktime() {
        return startWorktime;
    }

    public void setStartWorktime(String startWorktime) {
        this.startWorktime = startWorktime;
    }

    public String getEndWorktime() {
        return endWorktime;
    }

    public void setEndWorktime(String endWorktime) {
        this.endWorktime = endWorktime;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", staffCode='" + staffCode + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffSex='" + staffSex + '\'' +
                ", staffAddress='" + staffAddress + '\'' +
                ", staffUsername='" + staffUsername + '\'' +
                ", staffPassword='" + staffPassword + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffPermission='" + staffPermission + '\'' +
                ", startWorktime='" + startWorktime + '\'' +
                ", endWorktime='" + endWorktime + '\'' +
                '}';
    }
}