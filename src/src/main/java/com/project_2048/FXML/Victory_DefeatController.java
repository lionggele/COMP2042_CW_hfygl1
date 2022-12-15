package com.project_2048.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Victory_DefeatController {
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private long score;


    public void initizalize(){



    }



    @FXML
    public void scoreButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/project_2048/FXML/EndGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}