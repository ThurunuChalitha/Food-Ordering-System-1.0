package com.grp2.foodorderingsystem;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import com.grp2.foodorderingsystem.Model.Food;
import com.grp2.foodorderingsystem.Model.Order;
import com.grp2.foodorderingsystem.Model.OrderedFood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class UpdateOrderController implements Initializable {

	@FXML
	private ChoiceBox<String> updateOrderViewFoodNames;

	@FXML
	private ChoiceBox<Integer> updateOrderViewFoodQuantites;

	@FXML
	private ListView<String> updateOrderListFoodNames;

	@FXML
	private ListView<String> updateOrderListFoodQuantity;
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	private final String[] food = {"pizza","sushi","Pasta"};

	private Integer[] qFood = {1,2,3,4,5,6,7,8,9};

	private final Food pizza = new Food("pizza", 700.00, 30, "#001", "Sri Lankan",
			5, 5);

	private final Food sushi = new Food("sushi", 600.00, 20, "#002", "Chinese",
			10, 10);

	private final Food Pasta = new Food("Pasta", 550.00, 15, "#003", "Indian",
			8, 8);

	private Map<String, Food> foodMap = new HashMap<>();
	private final List<OrderedFood> orderFoodItems = new ArrayList<>();
	private Order order = new Order();
	private List<Order> orderList = new ArrayList<>();

	public void switchToHomeInterface(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("InsertScene.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	}

	@FXML
	public void switchToUpdateOrderInterface(Order order, Map<String, Food> foodMap) {
//		 Parent root = FXMLLoader.load(getClass().getResource("update-order.fxml"));
//		stage = new Stage();
////		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//		updateOrderListFoodNames.getItems().clear();
//		updateOrderListFoodQuantity.getItems().clear();

//		for (OrderedFood orderedFood : order.getFoodList()) {
//			updateOrderListFoodNames.getItems().addAll(orderedFood.getFoodName());
//			updateOrderListFoodQuantity.getItems().addAll(Integer.toString(orderedFood.getOrderedFoodCount()));
//		}
	}

	@FXML
	public void btnAddInUpdateOrder(ActionEvent event) {
		String selectedFoodName = updateOrderViewFoodNames.getValue();
		int selectedQ = updateOrderViewFoodQuantites.getValue();
		if (selectedFoodName == null || selectedQ == 0) {
			System.out.println("Error");
		} else {
			Food foodFromMap = foodMap.get(selectedFoodName);
			OrderedFood orderedFood = new OrderedFood(foodFromMap.getFoodName(), foodFromMap.getFoodPrice(), foodFromMap.getItemCount(),
					foodFromMap.getFoodCode(), foodFromMap.getFoodType(), foodFromMap.getProcessTime(), foodFromMap.getWeight());
			orderedFood.setOrderedFoodCount(selectedQ);
			orderFoodItems.add(orderedFood);

			updateOrderListFoodNames.getItems().addAll(selectedFoodName);
			updateOrderListFoodQuantity.getItems().addAll(Integer.toString(selectedQ));
		}
	}

//	@FXML
//	public void btnConfirmOrder(ActionEvent event) {
//		fsListView.getItems().clear();
//		qListView.getItems().clear();
//
//		Order foodOrder = new Order(i, 0, orderFoodItems, 0.0, 0, null,
//				System.currentTimeMillis(), null);
//
//		if (!orderFoodItems.isEmpty()) {
//			double totalBill = 0.0;
//			int approximateTime = 0;
//			List<OrderedFood> orderedFoodList = new ArrayList<>();
//			for (OrderedFood orderedFood : orderFoodItems) {
//				if (orderedFood != null) {
//					totalBill = totalBill + orderedFood.getFoodPrice() * orderedFood.getOrderedFoodCount();
//					if (orderedFood.getOrderedFoodCount() > 2) {
//						approximateTime = approximateTime + orderedFood.getProcessTime() * (orderedFood.getOrderedFoodCount() / 2);
//					} else {
//						approximateTime = approximateTime + orderedFood.getProcessTime();
//					}
//					orderedFoodList.add(orderedFood);
//				}
//			}
//
//			foodOrder.setFoodList(orderedFoodList);
//			foodOrder.setTotalBill(totalBill);
//			foodOrder.setApproximateTime(approximateTime);
//			foodOrder.setCreatedTimestamp(System.currentTimeMillis());
//			orderNumberWithOrderMap.put(i, foodOrder);
//
//			List<Order> viewList = sortingManager.addOrderToWeight(foodOrder);
//
//			if (viewList != null) {
//				oListView.getItems().clear();
//				for (Order order : viewList) {
//					oListView.getItems().addAll(Integer.toString(order.getOrderNo()));
//				}
//			}
//
//			bst.insert(foodOrder.getOrderNo());
//			orderNoList.add(i);
//			bst.printTree();
//
//			fsListView.getItems().clear();
//			i++;
//			orderFoodItems.clear();
//		} else {
//			System.out.println("Please select a food items");
//		}
//	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateOrderListFoodNames.getItems().addAll("pizza");
		updateOrderListFoodNames.getItems().addAll("sushi");
		updateOrderListFoodQuantity.getItems().addAll(Integer.toString(4));
		updateOrderListFoodQuantity.getItems().addAll(Integer.toString(2));

		updateOrderViewFoodNames.getItems().addAll(food);
		updateOrderViewFoodQuantites.getItems().addAll(qFood);
		updateOrderViewFoodNames.getSelectionModel().selectFirst();
		updateOrderViewFoodQuantites.getSelectionModel().selectFirst();

		foodMap.put("pizza", pizza);
		foodMap.put("sushi", sushi);
		foodMap.put("Pasta", Pasta);
	}
}
