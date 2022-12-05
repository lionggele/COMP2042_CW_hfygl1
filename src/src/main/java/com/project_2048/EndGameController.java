package com.project_2048;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EndGameController implements initializable {

    @FXML
    private Button highScore;

    @FXML
    private Label myScores;



    @FXML
    void nextScene(ActionEvent event) {

    }

    public void initialize(){
        int num = (int) GameScene.getScore();
        String a = String.valueOf(num);
        myScores.setText(a);
    }
}
