package com.grp2.foodorderingsystem;

import java.util.List;

public class BinarySearch {

    public int binarySearch(List<Integer> arr, int left, int right, int key) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == key) {
                return mid;
            }
            if (arr.get(mid) > key) {
                return binarySearch(arr, left, mid - 1, key);
            } else {
                return binarySearch(arr, mid + 1, right, key);
            }
        }
        return -1;
    }

    public int searchOrder(List<Integer> orderNumberList, String orderNumber) {
        int key = Integer.parseInt(orderNumber);
        int right = orderNumberList.size() - 1;
        return orderNumberList.get(binarySearch(orderNumberList, 0, right, key));
    }
}