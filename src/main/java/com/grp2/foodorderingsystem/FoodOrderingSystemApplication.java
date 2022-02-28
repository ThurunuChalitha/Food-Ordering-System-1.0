package com.grp2.foodorderingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodOrderingSystemApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FoodOrderingSystemApplication.class.getResource("sortedOrderListView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 350);
        stage.setMaximized(true);
        stage.setTitle("Food Ordering System!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}