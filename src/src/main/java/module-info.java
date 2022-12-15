module com.project_2048 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.junit.jupiter.api;

    opens com.project_2048 to javafx.fxml;
    exports com.project_2048;
    exports com.project_2048.FXML;
    opens com.project_2048.FXML to javafx.fxml;
    exports com.project_2048.Controller;
    opens com.project_2048.Controller to javafx.fxml;
}