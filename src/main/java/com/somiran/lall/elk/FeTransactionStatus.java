package com.somiran.lall.elk;

public class FeTransactionStatus {

    @Override
    public String toString() {
        return "FeTransactionStatus [transactionId=" + transactionId + ", createDate=" + createDate + ", id=" + id
                + ", idType=" + idType + ", affectedDeviceCount=" + affectedDeviceCount + ", affectedAccountCount="
                + affectedAccountCount + ", successAccountCount=" + successAccountCount + ", successDeviceCount="
                + successDeviceCount + ", failedAccountCount=" + failedAccountCount + ", failedDeviceCount="
                + failedDeviceCount + ", pendingAccountCount=" + pendingAccountCount + ", pendingDeviceCount="
                + pendingDeviceCount + ", data=" + data + "]";
    }

    private String transactionId;
    private String createDate;
    private String id;
    private String idType;
    private int affectedDeviceCount;
    private int affectedAccountCount;
    private int successAccountCount;
    private int successDeviceCount;

    private int failedAccountCount;
    private int failedDeviceCount;

    private int pendingAccountCount;
    private int pendingDeviceCount;

    private String data;

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

    public int getSuccessAccountCount() {
        return successAccountCount;
    }

    public void setSuccessAccountCount(int successAccountCount) {
        this.successAccountCount = successAccountCount;
    }

    public int getSuccessDeviceCount() {
        return successDeviceCount;
    }

    public void setSuccessDeviceCount(int successDeviceCount) {
        this.successDeviceCount = successDeviceCount;
    }

    public int getFailedAccountCount() {
        return failedAccountCount;
    }

    public void setFailedAccountCount(int failedAccountCount) {
        this.failedAccountCount = failedAccountCount;
    }

    public int getFailedDeviceCount() {
        return failedDeviceCount;
    }

    public void setFailedDeviceCount(int failedDeviceCount) {
        this.failedDeviceCount = failedDeviceCount;
    }

    public int getPendingAccountCount() {
        return pendingAccountCount;
    }

    public void setPendingAccountCount(int pendingAccountCount) {
        this.pendingAccountCount = pendingAccountCount;
    }

    public int getPendingDeviceCount() {
        return pendingDeviceCount;
    }

    public void setPendingDeviceCount(int pendingDeviceCount) {
        this.pendingDeviceCount = pendingDeviceCount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    

}
