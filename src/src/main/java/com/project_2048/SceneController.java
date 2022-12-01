package com.project_2048;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Scanner;

import static javafx.scene.paint.Color.rgb;


public class SceneController implements initializable{
    private Stage stage;
    static final int WIDTH = 900;
    static final int HEIGHT = 900;

    //Game scheme
    private Group gameRoot = new Group();
    private Scene gameScene;

    private static Scanner input= new Scanner(System.in);//account


    Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, rgb(250, 20, 100, 0.2));

    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myColorPicker;

    public SetGetColour changeColor() {
        Color Colour = myColorPicker.getValue();

        SetGetColour mycolour = new SetGetColour();
        mycolour.setMyColour(Colour);
        BackgroundFill background_fill = new BackgroundFill(Colour, null, null);
        myPane.setBackground(new Background(background_fill));
        return mycolour;
    }



    //submit button
    public void switchToScene1(javafx.event.ActionEvent event) {

        SetGetColour back;
        back = changeColor();
        String colour = back.getMyColour();

        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();

        Group gameRoot = new Group();
        setGameRoot(gameRoot);

        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Paint.valueOf(colour));


        setGameScene(gameScene);


        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);


        stage.setScene(gameScene);
        stage.show();
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    class SetGetColour{
        private String myColour;
        public void setMyColour(Color myColour){
            this.myColour = String.valueOf(myColour);
        }

        String getMyColour() {
            return myColour;
        }

    }
}