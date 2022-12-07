package com.project_2048;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScoreBoardController {

    FileChooser filechooser = new FileChooser();
    private String highscore = "";
    @FXML
    private Button exitgame;

    @FXML
    private Label myScore4;

    @FXML
    private TextArea textarea4;

    @FXML
    private TextArea textarea5;



    public void saveData(File file, String content){
        try{
            PrintWriter printWriter = new PrintWriter(filechooser.getInitialDirectory());
            printWriter.write(content);
            printWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    public void initialize(){

        String username = EndGameController.getUsername();
        System.out.println(username);

        int num = (int) GameScene.getScore();
        //getHighScore(num);
        String a = String.valueOf(num);

        highscore = username + ":" + a;
        myScore4.setText(highscore);


        filechooser.setInitialDirectory(new File("D:\\Code 3 (Y2S1)\\Software Maintainance (COMP2042)\\Project\\src\\src\\main\\java\\com\\project_2048\\highscores.txt"));

        try{
            Scanner scanner = new Scanner(filechooser.getInitialDirectory());
            while(scanner.hasNextLine()){

                    textarea4.appendText(scanner.nextLine() + "\n");
                    textarea4.appendText(highscore);
                //}
            }
        } catch (FileNotFoundException e ){
            e.printStackTrace();
        }

        if(filechooser.getInitialDirectory() != null){
            saveData(filechooser.getInitialDirectory(),highscore);
        }



    }
/*
    int getHighScore(int num){
        return num;
    }
*/




}
