package com.grp2.foodorderingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InsertScene.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("Food Ordering System!");
            primaryStage.setScene(scene);
            primaryStage.resizableProperty().setValue(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
