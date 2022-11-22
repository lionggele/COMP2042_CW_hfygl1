package com.project_2048;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

import static javafx.fxml.FXMLLoader.load;

public class SceneController implements initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;


    static final int WIDTH = 900;
    static final int HEIGHT = 900;

    //Game scheme
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    private static Scanner input= new Scanner(System.in);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }
    Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));



    @FXML
    TextField nameTextField;

    private Label label;


    @FXML
    private ComboBox<String> myComboBox;


    private ObservableList<String> list = FXCollections.observableArrayList("red", "blue","yellow");

    @Override
    public void initialize(URL url, ResourceBundle resources){
        System.out.println("Choice");
        myComboBox.setItems(list);
    }
    @FXML
    public void chooseColour(){
        System.out.println("Choice");
        String s = myComboBox.getSelectionModel().getSelectedItem().toString();
        System.out.println("Choice"+ s );
        label.setText(myComboBox.getValue());
    }


    //submit button
    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));

        setGameScene(gameScene);
        stage.setScene(gameScene);

        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);

        stage.setScene(gameScene);
        stage.show();

    }






/*
    //choice box
    @FXML
    public void initialize(){
        ObservableList<String> options = FXCollections.observableArrayList("Full","Half","Empty");
        myLabel.textProperty().bind(myComboBox.getSelectionModel().selectedItemProperty());
        myComboBox.setItems(options);

    }

    public void chooseColour(ActionEvent event) throws IOException  {

        String s=myComboBox.getSelectionModel().getSelectedItem();
        System.out.println("Choice: "+s);



    }

 */













/*

    public void login(ActionEvent event) throws IOException {

        String username = nameTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
        root = loader.load();
        Scene3Controller scene3Controller = loader.getController();
        scene3Controller.displayName(username);
}
         */



}