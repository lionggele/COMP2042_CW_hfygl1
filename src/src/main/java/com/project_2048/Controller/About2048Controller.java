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
 * This Controller will load back to the main scene, from About2048.fxml to Scene2.fxml
 */
public class About2048Controller {
    private Parent root;
    private Scene scene;

    private Stage stage;

    /**
     * This is a method button which to load the fxml and switch scene when the button clicked.
     * @param event
     * @throws IOException @throws IOException If an input or output
     *                     exception occurred
     */

    @FXML
    void back(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("/com/project_2048/FXML/Scene2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
