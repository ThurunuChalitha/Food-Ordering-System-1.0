package com.grp2.foodorderingsystem;

import com.grp2.foodorderingsystem.Service.SortingManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SortedOrderListController implements Initializable {

//    @FXML
//    public ListView sortedListId;

    @FXML
    private ListView<String> sortedListId;

    @FXML
    private Label testId;

    public void setSortedListId(ListView sortedListId) {
//        this.sortedListId = sortedListId;
//        this.sortedListId.setItems(sortedListId);
    }


    @FXML
    public void onUpdateButtonClick(ActionEvent actionEvent) {
        sortedListId = new ListView();
        SortingManager sortingManager = new SortingManager();
        ObservableList<String> items = FXCollections.observableArrayList();
//        for (Integer item : sortingManager.weightingListOfOrders()) {
////            this.sortedListId.getItems().add(item);
//            items.add(String.valueOf(item));
//        }
//        sortedListId.add("Item 1");
//        sortedListId.getItems().add("Item 2");
//        sortedListId.getItems().add("Item 3");
        sortedListId.setItems(items);
        sortedListId.refresh();
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        testId.setText("SSSSSSSSSSSS");
//        this.sortedListId.setItems((ObservableList) sortingManager.weightingListOfOrders());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sortedListId = new ListView();

        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
//        list = new ListView<>();
        sortedListId.setItems(names);
    }
}
