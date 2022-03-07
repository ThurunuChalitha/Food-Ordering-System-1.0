package com.grp2.foodorderingsystem;

import com.grp2.foodorderingsystem.Model.Food;
import com.grp2.foodorderingsystem.Model.OrderedFood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class newItemSceneController implements Initializable {

    private Parent root;

    @FXML
    private TextField newFoodName;

    @FXML
    private TextField newFoodCode;

    @FXML
    private TextField newFoodCount;

    @FXML
    private TextField unitPrice;

    @FXML
    private TextField processTime;

    @FXML
    private ChoiceBox<String> cmbFoodType;

    private final String[] foodType = {"Sri Lankan","Indian","Chinese"};

    @FXML
    public void btnAddNewItem(ActionEvent event) throws IOException {
        if(newFoodName.getText() != null || newFoodCode.getText() != null || unitPrice.getText() != null) {
            Food addNewItem = new Food(newFoodName.getText(), Double.parseDouble(unitPrice.getText()),
                    Integer.parseInt(newFoodCount.getText()),
                    newFoodCode.getText(), cmbFoodType.getValue(), Integer.parseInt(processTime.getText()),
                    Integer.parseInt(processTime.getText()));
            System.out.println("Item saved");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("InsertScene.fxml"));
            root = loader.load();

            InsertSceneController insertSceneController = loader.getController();
            insertSceneController.displayName(newFoodName.getText());
            insertSceneController.insertNewFood(addNewItem);

        }
        else {
            System.out.println("Please enter valid details");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        cmbFoodType.getItems().addAll(foodType);
        cmbFoodType.getSelectionModel().selectFirst();
    }


}
