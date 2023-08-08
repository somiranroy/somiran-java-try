package com.somiran.lall.elk;

public class FeObjectTransactionStatus {
    
    private String transactionId;
    private String createDate;
    private String id;
    private String idType;
    private String status;
    
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "FeObjectTransactionStatus [transactionId=" + transactionId + ", createDate=" + createDate + ", id=" + id
                + ", idType=" + idType + ", status=" + status + "]";
    }
    
    
}
