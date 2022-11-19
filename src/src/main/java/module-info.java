module com.project_2048 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.project_2048 to javafx.fxml;
    exports com.project_2048;
    exports com.project_2048.Board;
    opens com.project_2048.Board to javafx.fxml;
}