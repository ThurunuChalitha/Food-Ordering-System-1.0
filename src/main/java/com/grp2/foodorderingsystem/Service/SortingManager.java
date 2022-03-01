package com.grp2.foodorderingsystem.Service;

import com.grp2.foodorderingsystem.Model.Order;
import com.grp2.foodorderingsystem.Model.OrderedFood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingManager {

    public static void main(String[] args) {
        SortingManager sortingManager = new SortingManager();
        sortingManager.weightingListOfOrders();
    }

    public List<Integer> weightingListOfOrders() {
        OrderedFood riceAndCurriesWithOrderedCount = new OrderedFood("riceAndCurries", 700.00, 30,
                "#001", "Sri Lankan", 5, 5);
        OrderedFood friedRiceWithOrderedCount = new OrderedFood("friedRice", 600.00, 20,
                "#002", "Chinese",10, 10);
        OrderedFood chickenKottuWithOrderedCount = new OrderedFood("chickenKottu", 550.00, 15,
                "#003", "Indian", 8, 8);
        chickenKottuWithOrderedCount.setOrderedFoodCount(2);
        friedRiceWithOrderedCount.setOrderedFoodCount(3);
        chickenKottuWithOrderedCount.setOrderedFoodCount(4);

        List<OrderedFood> orderedFoodList1 = List.of(riceAndCurriesWithOrderedCount);
        List<OrderedFood> orderedFoodList2 = Arrays.asList(riceAndCurriesWithOrderedCount, friedRiceWithOrderedCount);
        List<OrderedFood> orderedFoodList3 = Arrays.asList(riceAndCurriesWithOrderedCount, friedRiceWithOrderedCount, chickenKottuWithOrderedCount);
        List<OrderedFood> orderedFoodList4 = Arrays.asList(riceAndCurriesWithOrderedCount, chickenKottuWithOrderedCount);

        Order order1 = new Order(1, 1, orderedFoodList1, 1500.00, 15, 5.00, 1643796681, "Dushyantha");
        Order order2 = new Order(2, 2, orderedFoodList2, 3000.00, 20, 5.00, 1643796581, "Dushyantha");
        Order order3 = new Order(3, 3, orderedFoodList3, 5000.00, 20, 5.00, 1643796481, "Dushyantha");
        Order order4 = new Order(3, 3, orderedFoodList4, 6000.00, 25, 5.00, 1643796781, "Dushyantha");

        order1.setTotalWeight(100);
        order2.setTotalWeight(200);
        order3.setTotalWeight(50);
        order4.setTotalWeight(150);

        List<Order> ordersList = Arrays.asList(order1, order2, order3, order4);
        List<Integer> totalWeightList = new ArrayList<>();

        //normal start
        //if total weights are same then 1st comer should be first
        for (Order order : ordersList) {
            if (order != null) {
                if (order.getTotalWeight() != 0) {
                    totalWeightList.add(order.getTotalWeight());
                }
            }
        }

        radixSort(totalWeightList, totalWeightList.size());
        System.out.println("AAAAAAAAAAAAAAAAAAAAa " + totalWeightList);

        return totalWeightList;
    }

    void radixSort(List<Integer> totalWeightList, int n) {

        //get maximum item
        Integer max = Collections.max(totalWeightList);

        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(totalWeightList, n, place);
        }
    }

    // function to implement counting sort
    void countingSort(List<Integer> totalWeightList, int n, int place) {
        int[] output = new int[n+1];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(totalWeightList.get(i) / place) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(totalWeightList.get(i) / place) % 10] - 1] = totalWeightList.get(i);
            count[(totalWeightList.get(i) / place) % 10]--;
        }

        totalWeightList.removeAll(totalWeightList);
        for (int i = 0; i < n; i++) {
            totalWeightList.add(output[i]);
        }
    }
}
