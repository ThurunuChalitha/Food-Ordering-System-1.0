package com.grp2.foodorderingsystem.Model;

import java.io.Serializable;

public class Addons implements Serializable {

    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Addons{" +
                "itemName='" + itemName + '\'' +
                '}';
    }
}
