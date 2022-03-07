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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField; 

public class InsertSceneController implements Initializable {

	private Stage stage;
	private Parent parent;
	private Scene scene;

	SortingManager sortingManager = new SortingManager();

	@FXML
	private ChoiceBox<String> fsComboBox;
	
	@FXML
	private ChoiceBox<Integer> qComboBox;
	
	@FXML
	private ListView<String> fsListView;

	@FXML
	private ListView<String> qListView;

	@FXML
	private ListView<String> searchListView;

	@FXML
	private ListView<String> searchListQuantityView;
	
	@FXML
	private TextField searchKey;
	
	@FXML
	private Button sbtn;

	@FXML
	private ListView<String> oListView;
	
	private final String[] food = {"pizza","pasta"};

	private Integer[] qFood = {1,2,3,4,5,6,7,8,9};

	private List<Integer> orderNoList = new ArrayList<>();

//	private List<String> food = new ArrayList<>();
	
	private int i = 1;

	private final Food pizza = new Food("pizza", 700.00, 30, "#001", "Sri Lankan",
			5, 5);

	private final Food sushi = new Food("sushi", 600.00, 20, "#002", "Chinese",
			10, 10);

	private final Food Pasta = new Food("Pasta", 550.00, 15, "#003", "Indian",
			8, 8);

	private Map<String, Food> foodMap = new HashMap<>();

	private final Map<Integer, Order> orderNumberWithOrderMap = new HashMap<>();

	RedBlackTree bst = new RedBlackTree();


	private final List<OrderedFood> orderFoodItems = new ArrayList<>();

	public InsertSceneController() {
	}

	public void displayName(String newfoodName){
		food[0] = newfoodName;
//		fsComboBox.getItems().addAll(food);
		System.out.println("++++++++++++++++++++++++++++++"+newfoodName);


	}

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
		searchListView.getItems().clear();
		searchListQuantityView.getItems().clear();
		if (searchKey.getText() != null || searchKey.getText() != " ") {
			BinarySearch binarySearch = new BinarySearch();
			int orderNo = binarySearch.searchOrder(orderNoList, searchKey.getText());

			for (OrderedFood orderedFood : orderNumberWithOrderMap.get(orderNo).getFoodList()) {
				searchListView.getItems().addAll(orderedFood.getFoodName());
				searchListQuantityView.getItems().addAll(Integer.toString(orderedFood.getOrderedFoodCount()));
			}
		} else {
			System.out.println("Please enter valid order number ");
		}
	}

	@FXML
	public void btnConfirmOrder(ActionEvent event) {
		fsListView.getItems().clear();
		qListView.getItems().clear();

		Order foodOrder = new Order(i, 0, orderFoodItems, 0.0, 0, null,
				System.currentTimeMillis(), null);

		if (!orderFoodItems.isEmpty()) {
			double totalBill = 0.0;
			int approximateTime = 0;
			List<OrderedFood> orderedFoodList = new ArrayList<>();
			for (OrderedFood orderedFood : orderFoodItems) {
				if (orderedFood != null) {
					totalBill = totalBill + orderedFood.getFoodPrice() * orderedFood.getOrderedFoodCount();
					if (orderedFood.getOrderedFoodCount() > 2) {
						approximateTime = approximateTime + orderedFood.getProcessTime() * (orderedFood.getOrderedFoodCount() / 2);
					} else {
						approximateTime = approximateTime + orderedFood.getProcessTime();
					}
					orderedFoodList.add(orderedFood);
				}
			}

			foodOrder.setFoodList(orderedFoodList);
			foodOrder.setTotalBill(totalBill);
			foodOrder.setApproximateTime(approximateTime);
			foodOrder.setCreatedTimestamp(System.currentTimeMillis());
			orderNumberWithOrderMap.put(i, foodOrder);

			List<Order> viewList = sortingManager.addOrderToWeight(foodOrder);

			if (viewList != null) {
				oListView.getItems().clear();
				for (Order order : viewList) {
					oListView.getItems().addAll(Integer.toString(order.getOrderNo()));
				}
			}

			bst.insert(foodOrder.getOrderNo());
			orderNoList.add(i);
			bst.printTree();

			fsListView.getItems().clear();
			i++;
			orderFoodItems.clear();
		} else {
			System.out.println("Please select a food items");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		foodMap.put("pizza", pizza);
		foodMap.put("sushi", sushi);
		foodMap.put("Pasta", Pasta);
		System.out.println("#########aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+food[0]);
		fsComboBox.getItems().addAll(food);
		qComboBox.getItems().addAll(qFood);
		qComboBox.getSelectionModel().selectFirst();
		fsComboBox.getSelectionModel().selectFirst();
	}
	
	public void switchToScene2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Order update");
		stage.show();
	}

	public void switchToScene3(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("newItemScene.fxml"));
		stage = new Stage();
//		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Add Item");
		stage.show();
	}

	@FXML
	public void btnDelete(ActionEvent actionEvent) {
		int selectedID =oListView.getSelectionModel().getSelectedIndex();
		oListView.getItems().remove(selectedID);
		bst.deleteNode(selectedID);
		System.out.println("************************");
		bst.printTree();

	}

    public void btnComplete(ActionEvent actionEvent) {
		int selectedIdComplete =oListView.getSelectionModel().getSelectedIndex();
		oListView.getItems().remove(selectedIdComplete);
	}
	


	public void insertNewFood(Food newFood){

	}
}
