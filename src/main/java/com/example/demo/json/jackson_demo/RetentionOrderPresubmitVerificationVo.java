package com.example.demo.json.jackson_demo;


import java.io.Serializable;
import java.util.Map;

public class RetentionOrderPresubmitVerificationVo implements Serializable {
    private String rentOrderId;
    private long userId;
    private long totalRetentionFee;
    private long totalRentRefund;
    private Map<Long, Long> entityId_ToyId_Map;
    //private Map<Long, Long> entityId_RentPrice_Map;

    @Override
    public String toString() {
        return "RetentionOrderPresubmitVerificationVo{" +
                "rentOrderId='" + rentOrderId + '\'' +
                ", userId=" + userId +
                ", totalRetentionFee=" + totalRetentionFee +
                ", totalRentRefund=" + totalRentRefund +
                ", entityId_ToyId_Map=" + entityId_ToyId_Map +
                '}';
    }

    public String getRentOrderId() {
        return rentOrderId;
    }

    public void setRentOrderId(String rentOrderId) {
        this.rentOrderId = rentOrderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTotalRetentionFee() {
        return totalRetentionFee;
    }

    public void setTotalRetentionFee(long totalRetentionFee) {
        this.totalRetentionFee = totalRetentionFee;
    }

    public long getTotalRentRefund() {
        return totalRentRefund;
    }

    public void setTotalRentRefund(long totalRentRefund) {
        this.totalRentRefund = totalRentRefund;
    }

    public Map<Long, Long> getEntityId_ToyId_Map() {
        return entityId_ToyId_Map;
    }

    public void setEntityId_ToyId_Map(Map<Long, Long> entityId_ToyId_Map) {
        this.entityId_ToyId_Map = entityId_ToyId_Map;
    }
}
