package com.grp2.foodorderingsystem.Model;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

public class Order implements Serializable {

    private int orderNo;
    private int tableNo;
    private List<Food> foodList;
    private Double totalBill;
    private int approximateTime;
    private Double discount;
    private int totalWeight;
    private Timestamp createdTimestamp;
    private String createdBy;
    private boolean isProcessing;

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public int getApproximateTime() {
        return approximateTime;
    }

    public void setApproximateTime(int approximateTime) {
        this.approximateTime = approximateTime;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void setProcessing(boolean processing) {
        isProcessing = processing;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", tableNo=" + tableNo +
                ", foodList=" + foodList +
                ", totalBill=" + totalBill +
                ", approximateTime=" + approximateTime +
                ", discount=" + discount +
                ", totalWeight=" + totalWeight +
                ", createdTimestamp=" + createdTimestamp +
                ", createdBy='" + createdBy + '\'' +
                ", isProcessing=" + isProcessing +
                '}';
    }
}
