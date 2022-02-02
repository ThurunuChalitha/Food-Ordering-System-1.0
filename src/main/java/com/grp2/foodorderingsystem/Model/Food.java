package com.grp2.foodorderingsystem.Model;

import java.io.Serializable;
import java.util.List;

public class Food implements Serializable {

    private String foodName;
    private Double foodPrice;
    private int itemCount;
    private String foodCode;
    private String foodType;
    private boolean isAvailable;
    private int processTime;
    private int weight;
    private List<Addons> addonsList;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Addons> getAddonsList() {
        return addonsList;
    }

    public void setAddonsList(List<Addons> addonsList) {
        this.addonsList = addonsList;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", itemCount=" + itemCount +
                ", foodCode='" + foodCode + '\'' +
                ", foodType='" + foodType + '\'' +
                ", isAvailable=" + isAvailable +
                ", processTime=" + processTime +
                ", weight=" + weight +
                ", addonsList=" + addonsList +
                '}';
    }
}
