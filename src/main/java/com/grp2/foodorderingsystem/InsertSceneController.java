package com.grp2.foodorderingsystem;

import com.grp2.foodorderingsystem.Model.OrderedFood;
import com.grp2.foodorderingsystem.Service.SortingManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.*;

import com.grp2.foodorderingsystem.Model.Food;
import com.grp2.foodorderingsystem.Model.Order;
import com.grp2.foodorderingsystem.Service.RedBlackTree;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

public class InsertSceneController implements Initializable {
	
	@FXML
	private ChoiceBox<String> fsComboBox;
	
	@FXML
	private ChoiceBox<Integer> qComboBox;
	
	@FXML
	private ListView<String> fsListView;
	@FXML
	private ListView<String> qListView;

	@FXML
	private ListView<String> oListView;
	
	private String[] food = {"pizza","sushi","ramen","Noodles","Coffee","Pasta","Soda","Garlic bread",
			"Donut"};
	private Integer[] qFood = {1,2,3,4,5,6,7,8,9};
	
	private int i = 1;

	private final Food pizza = new Food("pizza", 700.00, 30, "#001", "Sri Lankan",
			5, 5);

	private final Food sushi = new Food("sushi", 600.00, 20, "#002", "Chinese",
			10, 10);

	private final Food Pasta = new Food("Pasta", 550.00, 15, "#003", "Indian",
			8, 8);

	private Map<String, Food> foodMap = new HashMap<>();
	
	RedBlackTree bst = new RedBlackTree();
	Order foodOrder = new Order(0, 0, null, null, 0, null, 0, null);

	List<OrderedFood> orderFoodItems = new ArrayList<>();
	
	@FXML
	public void btnAdd(ActionEvent event) {
		String selectedFoodName = fsComboBox.getValue();
		int selectedQ = qComboBox.getValue();
		if (selectedFoodName == null || selectedQ == 0) {
			System.out.println("Error");
		} else {
			Food foodFromMap = foodMap.get(selectedFoodName);
			OrderedFood orderedFood = new OrderedFood(foodFromMap.getFoodName(), foodFromMap.getFoodPrice(), foodFromMap.getItemCount(),
					foodFromMap.getFoodCode(), foodFromMap.getFoodType(), foodFromMap.getProcessTime(), foodFromMap.getWeight());
			orderedFood.setOrderedFoodCount(selectedQ);
			orderFoodItems.add(orderedFood);

			fsListView.getItems().addAll(selectedFoodName);
			qListView.getItems().addAll(Integer.toString(selectedQ));
		}
	}
	
	@FXML
	public void btnConfirmOrder(ActionEvent event) {
//<<<<<<< HEAD
		String selectedFood = fsComboBox.getValue();
	
		foodOrder.setOrderNo(i);
		oListView.getItems().addAll(Integer.toString(foodOrder.getOrderNo()));
		
		bst.insert(foodOrder.getOrderNo());
		bst.printTree();
//		System.out.print();
		fsListView.getItems().clear();
		qListView.getItems().clear();
//		orderItem.clear();
//		i++;
//=======
		if (!orderFoodItems.isEmpty()) {
			double totalBill = 0.0;
			int approximateTime = 0;
			for (OrderedFood orderedFood : orderFoodItems) {
				if (orderedFood != null) {
					totalBill = totalBill + orderedFood.getFoodPrice() * orderedFood.getOrderedFoodCount();
					approximateTime = approximateTime + orderedFood.getProcessTime();
				}
			}
			foodOrder.setOrderNo(i);
			foodOrder.setFoodList(orderFoodItems);
			foodOrder.setTotalBill(totalBill);
			foodOrder.setApproximateTime(approximateTime);
			foodOrder.setCreatedTimestamp(System.currentTimeMillis());

			SortingManager sortingManager = new SortingManager();
			List<Order> viewList = sortingManager.addOrderToWeight(foodOrder);

			if (viewList != null) {
				for (Order order : viewList) {
					oListView.getItems().addAll(Integer.toString(order.getOrderNo()));
				}
			}

//		oListView.getItems().addAll(Integer.toString(foodOrder.getOrderNo()));

			bst.insert(foodOrder.getOrderNo());
			bst.printTree();

			fsListView.getItems().clear();
			orderFoodItems.clear();
			i++;
		} else {
			System.out.println("Please select the food items");
		}
//>>>>>>> a542a199bb3e66cdcb808f286e1ab74177d8fd6d
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		foodMap.put("pizza", pizza);
		foodMap.put("sushi", sushi);
		foodMap.put("Pasta", Pasta);

		fsComboBox.getItems().addAll(food);
		qComboBox.getItems().addAll(qFood);
		qComboBox.getSelectionModel().selectFirst();
		fsComboBox.getSelectionModel().selectFirst();
	}
	
}
