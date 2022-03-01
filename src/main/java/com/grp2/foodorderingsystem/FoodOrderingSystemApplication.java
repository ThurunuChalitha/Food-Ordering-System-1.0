package com.grp2.foodorderingsystem;

import com.grp2.foodorderingsystem.Service.SortingManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodOrderingSystemApplication extends Application {

//    @FXML
//    public ListView sortedListId;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FoodOrderingSystemApplication.class.getResource("sortedOrderListView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 350);
        stage.setMaximized(true);
        stage.setTitle("Food Ordering System!");
//        stage.setScene(scene);

//        ListView listView = new ListView();

//        listView.getItems().add("Item 1");
//        listView.getItems().add("Item 2");
//        listView.getItems().add("Item 3");
//
//        HBox hbox = new HBox(listView);

//        sortedListId = new ListView();
//        SortingManager sortingManager = new SortingManager();
//        ObservableList<String> items = FXCollections.observableArrayList();
//        for (Integer item : sortingManager.weightingListOfOrders()) {
//            items.add(String.valueOf(item));
//        }
//        sortedListId.add("Item 1");
//        sortedListId.getItems().add("Item 2");
//        sortedListId.getItems().add("Item 3");
//        sortedListId.setItems(items);
//        sortedListId.refresh();
//        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");

//        Scene scene = new Scene(sortedListId, 300, 120);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}