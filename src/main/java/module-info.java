module com.cmp269.exercise4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cmp269.exercise4 to javafx.fxml;
    exports com.cmp269.exercise4;
}