module com.grp2.foodorderingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
	requires javafx.graphics;
	requires javafx.base;

    opens com.grp2.foodorderingsystem to javafx.fxml;
    exports com.grp2.foodorderingsystem;
}