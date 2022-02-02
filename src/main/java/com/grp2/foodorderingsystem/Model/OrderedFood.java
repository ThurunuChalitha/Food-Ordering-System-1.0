package com.grp2.foodorderingsystem.Model;

public class OrderedFood extends Food{

    private int orderedFoodCount;

    public OrderedFood(String foodName, Double foodPrice, int itemCount, String foodCode, String foodType, int processTime,
                       int weight) {
        super(foodName, foodPrice, itemCount, foodCode, foodType, processTime, weight);
    }

    public int getOrderedFoodCount() {
        return orderedFoodCount;
    }

    public void setOrderedFoodCount(int orderedFoodCount) {
        this.orderedFoodCount = orderedFoodCount;
    }

    @Override
    public String toString() {
        return "OrderedFood{" +
                "orderedFoodCount=" + orderedFoodCount +
                "} " + super.toString();
    }
}
