package com.project_2048;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EndGameController implements initializable {

    @FXML
    private Button highScore;

    @FXML
    private Label myScores;

    @FXML
    private TextField Username;

    private static String username;

    private Stage stage;
    private Parent root;
    private Scene scene;

    public static String getUsername(){
        return username;
    }

    @FXML
    public void nextScene(javafx.event.ActionEvent event) throws IOException {
        username = Username.getText();
        System.out.println(username);
        root = FXMLLoader.load(getClass().getResource("ScoreBoard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    public void initialize(){
        int num = (int) GameScene.getScore();
        String a = String.valueOf(num);
        myScores.setText(a);
    }





}
