package com.grp2.foodorderingsystem;

import com.grp2.foodorderingsystem.Model.OrderedFood;
import com.grp2.foodorderingsystem.Service.SortingManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import com.grp2.foodorderingsystem.Model.Food;
import com.grp2.foodorderingsystem.Model.Order;
import com.grp2.foodorderingsystem.Service.RedBlackTree;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField; 

public class InsertSceneController implements Initializable {
	private Stage stage;
	private Parent parent;
	private Scene scene;
	@FXML
	private ChoiceBox<String> fsComboBox;
	
	@FXML
	private ChoiceBox<Integer> qComboBox;
	
	@FXML
	private ListView<String> fsListView;
	@FXML
	private ListView<String> qListView;
	
	@FXML
	private TextField searchKey;
	
	@FXML
	private Button sbtn;

	@FXML
	private ListView<String> oListView;
	
	private String[] food = {"pizza","sushi","Pasta"};
//	private String[] food = {"pizza","sushi","ramen","Noodles","Coffee","Pasta","Soda","Garlic bread",
//	"Donut"};
	private Integer[] qFood = {1,2,3,4,5,6,7,8,9};
	
	private int i = 1;
	private int searchId ;

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
	

	public void btnSearch(ActionEvent event) {
		searchId =  Integer.parseInt(searchKey.getText());
		System.out.println(searchId);
	}
	
	
	
	@FXML
	public void btnConfirmOrder(ActionEvent event) {

		String selectedFood = fsComboBox.getValue();
	
		foodOrder.setOrderNo(i);
		
//		oListView.getItems().addAll(Integer.toString(foodOrder.getOrderNo()));

		fsListView.getItems().clear();
		qListView.getItems().clear();


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
			searchId =  Integer.parseInt(searchKey.getText());
			System.out.println(searchId);
		} else {
			System.out.println("Please select a food items");
		}

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
	
	public void switchToScene2(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		 stage = new Stage();
//		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.setTitle("Order update");
		  stage.show();
	}
	
}
