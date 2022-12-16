package com.project_2048.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *  This is the Controller to load the fxml, from Defeat.fxml to EndGame.fxml
 */

public class DefeatController {
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private long score;


    /**
     * This is a method button which to load the fxml and switch scene when the button clicked.
     * @param event
     * @throws IOException  If an input or output
     *                      exception occurred
     */
    @FXML
    void scoreButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/project_2048/FXML/EndGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}