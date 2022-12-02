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


    private long score;

    private long tmpscore;

    @FXML
    void nextScene(ActionEvent event) {

    }

    public void setScore(long score) {
        this.score = score;
        System.out.println("Test1" + score);
    }


    public void initialize(){
        String a = String.valueOf(score);
        myScores.setText(a);
        System.out.println("Test3" + a);

    }





}
