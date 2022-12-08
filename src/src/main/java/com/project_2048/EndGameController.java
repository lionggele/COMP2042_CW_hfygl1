package com.project_2048;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EndGameController implements initializable {

    @FXML
    private Button highScore;

    @FXML
    private Label myScores;

    @FXML
    private TextField Username;
    /*
    private static String username;

    private Stage stage;
    private Parent root;
    private Scene scene;

    public static String getUsername(){
        return username;
    }*/
    //FileChooser filechooser = new FileChooser();
    @FXML
    private TextArea mytextarea4;

    @FXML
    private TextArea mytextarea5;

    @FXML
    private TextArea mytextarea6;

    FileChooser filechooser = new FileChooser();
    public String highscore;
    private String a;

    @FXML
    public void nextScene(ActionEvent event){
        int num = (int) GameScene.getScore();
        //getHighScore(num);
        String a = String.valueOf(num);
        String username = Username.getText();
        highscore = username + ":" + a;
        mytextarea4.appendText(highscore);


    }
    public void initialize(){
        int num = (int) GameScene.getScore();
        String a = String.valueOf(num);
        myScores.setText(a);

        filechooser.setInitialDirectory(new File("D:\\Code 3 (Y2S1)\\Software Maintainance (COMP2042)\\Project\\src\\src\\main\\java\\com\\project_2048\\HighScore"));
        File file = filechooser.showOpenDialog(new Stage());
        File selectedfile = file.getAbsoluteFile();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                mytextarea4.appendText(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void save(ActionEvent event) {
        File file = filechooser.showSaveDialog(new Stage());
        if (file != null) {
            saveData(file, highscore);
        }
    }

    public void saveData(File file, String highscore) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(highscore);
            printWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }







/*
    public void saveUsername(javafx.event.ActionEvent event) {
        File file = filechooser.showSaveDialog(new Stage());
        if (file != null) {
            saveData(file, highscore);
        }

    }

 */
}
