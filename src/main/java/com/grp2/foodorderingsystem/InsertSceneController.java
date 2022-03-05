package com.grp2.foodorderingsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

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
	
	private int i = 0;
	
	RedBlackTree bst = new RedBlackTree();
	Order foodOrder = new Order(0, 0, null, null, 0, null, 0, null);

	ArrayList<String> orderItem = new ArrayList<String>();
	Map<String,ArrayList> map = new HashMap<>();
	
	@FXML
	public void btnAdd(ActionEvent event) {
		
		String selectedFood = fsComboBox.getValue();
		int selectedQ = qComboBox.getValue();
		
		if(selectedFood == null ) {
			System.out.println("Error");
		}
		else {
			orderItem.add(selectedFood);
			fsListView.getItems().addAll(selectedFood);
			qListView.getItems().addAll(Integer.toString(selectedQ));
			map.put(Integer.toString(i), orderItem);	
		}
	}
	
	@FXML
	public void btnConfirmOrder(ActionEvent event) {
		String selectedFood = fsComboBox.getValue();
	
		foodOrder.setOrderNo(i);
		oListView.getItems().addAll(Integer.toString(foodOrder.getOrderNo()));
		
		bst.insert(foodOrder.getOrderNo());
		bst.printTree();
//		System.out.print();
		fsListView.getItems().clear();
		qListView.getItems().clear();
//		orderItem.clear();
		i++;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		fsComboBox.getItems().addAll(food);
		qComboBox.getItems().addAll(qFood);
		qComboBox.getSelectionModel().selectFirst();
		fsComboBox.getSelectionModel().selectFirst();
	}
	
}
