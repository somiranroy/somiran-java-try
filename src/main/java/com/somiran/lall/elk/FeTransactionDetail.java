package com.somiran.lall.elk;

public class FeTransactionDetail {
    
    private String transactionId;
    private String createDate;
    private String id;
    private String idType;
    private int affectedDeviceCount;
    private int affectedAccountCount;
    private String data;
    
    private String component;
    
    
    public String getComponent() {
        return component;
    }
    public void setComponent(String component) {
        this.component = component;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdType() {
        return idType;
    }
    public void setIdType(String idType) {
        this.idType = idType;
    }
    public int getAffectedDeviceCount() {
        return affectedDeviceCount;
    }
    public void setAffectedDeviceCount(int affectedDeviceCount) {
        this.affectedDeviceCount = affectedDeviceCount;
    }
    public int getAffectedAccountCount() {
        return affectedAccountCount;
    }
    public void setAffectedAccountCount(int affectedAccountCount) {
        this.affectedAccountCount = affectedAccountCount;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "FeTransactionDetail [transactionId=" + transactionId + ", createDate=" + createDate + ", id=" + id
                + ", idType=" + idType + ", affectedDeviceCount=" + affectedDeviceCount + ", affectedAccountCount="
                + affectedAccountCount + ", data=" + data + ", component=" + component + "]";
    }
    
    

}
