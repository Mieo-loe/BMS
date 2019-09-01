package com.tencent.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recycle {
    private Integer id;
    private String tableName;
    private Integer recordId;
    private String deleteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.deleteTime = dateFormat.format(deleteTime);
    }
}
