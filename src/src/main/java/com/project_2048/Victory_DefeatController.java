package com.project_2048;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Victory_DefeatController {

    @FXML
    private Button score;

    @FXML
    void scoreButton(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}