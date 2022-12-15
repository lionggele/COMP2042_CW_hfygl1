package com.project_2048.Controller;

import com.project_2048.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;


public class SceneController implements initializable {


    private Parent root;
    private Scene scene;
    private Stage stage;
    static final int WIDTH = 900;
    static final int HEIGHT = 900;

    //Game scheme
    private Group gameRoot = new Group();
    private Scene gameScene;



    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myColorPicker;

    @FXML
    private CheckBox CheckBox1;

    @FXML
    private CheckBox CheckBox2;

    @FXML
    private CheckBox CheckBox3;

    @FXML
    private Label GridLabel;



    //submit button
    public void switchToScene1(javafx.event.ActionEvent event) {

        SetGetColour back;
        back = changeColor();
        String colour = back.getMyColour();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Paint.valueOf(colour));
        setGameScene(gameScene);
        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, stage);
        stage.setScene(gameScene);
        stage.show();
    }

    public SetGetColour changeColor() {
        Color Colour = myColorPicker.getValue();
        SetGetColour mycolour = new SetGetColour();
        mycolour.setMyColour(Colour);
        BackgroundFill background_fill = new BackgroundFill(Colour, null, null);
        myPane.setBackground(new Background(background_fill));
        return mycolour;
    }


    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }


    class SetGetColour {
        private String myColour;

        public void setMyColour(Color myColour) {
            this.myColour = String.valueOf(myColour);
        }

        String getMyColour() {
            return myColour;
        }

    }



    @FXML
    public void changeGrid4x4(javafx.event.ActionEvent event) {
        if (CheckBox1.isSelected()){
            GridLabel.setText("4x4");
            GameScene num = new GameScene();
            num.setN(4);

        }

    }

    @FXML
    public void changeGrid5x5(javafx.event.ActionEvent event){
        if (CheckBox2.isSelected()){
            GridLabel.setText("5x5");
            GameScene num = new GameScene();
            num.setN(5);
        }
    }

    @FXML
    void changeGrid6x6(ActionEvent event) {
        if (CheckBox3.isSelected()){
            GridLabel.setText("6x6");
            GameScene num = new GameScene();
            num.setN(6);

        }
    }

    @FXML
     public void tutorial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/project_2048/FXML/HowtoPlay.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }







}

