module com.example.time {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.time to javafx.fxml;
    exports com.example.time;
}