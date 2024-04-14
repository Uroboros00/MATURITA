module com.example.buttonhelloworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.buttonhelloworld to javafx.fxml;
    exports com.example.buttonhelloworld;
}