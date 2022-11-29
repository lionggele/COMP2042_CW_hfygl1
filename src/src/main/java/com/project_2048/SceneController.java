package com.project_2048;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

import static javafx.scene.paint.Color.rgb;


public class SceneController implements initializable{
/*
    @FXML
    private ComboBox myComboBox;

    @FXML
    private Label label;


    public void initialize(){
        ObservableList<String> list = FXCollections.observableArrayList("JavaFX","SceneBuilder","Laravel","Python");
        myComboBox.setItems(list);
        myComboBox.setValue("Select Colour");


    }

 */





    private Stage stage;
    static final int WIDTH = 900;
    static final int HEIGHT = 900;

    //Game scheme
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, rgb(189, 177, 92));
    private static Scanner input= new Scanner(System.in);//account
    private Color myColour;
    public SceneController() {
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }
    Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, rgb(250, 20, 100, 0.2));


    @FXML
    TextField nameTextField;

    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myColorPicker;
    BackgroundFill background_fill = new BackgroundFill(rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill);

    public void changeColor() {
        Color myColor = myColorPicker.getValue();
        //myColor.setmyColour(myColor);
        BackgroundFill background_fill = new BackgroundFill(myColor, null, null);
        myPane.setBackground(new Background(background_fill));
    }
/*
    public void setmyColour(Color myColour){
        this.myColour = myColour;
    }

    public Color getmyColour() {
        return myColour;
    }



 */





    //submit button
    public void switchToScene1(javafx.event.ActionEvent event) throws IOException {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();

        Group gameRoot = new Group();
        setGameRoot(gameRoot);

        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, background_fill.getFill());


        setGameScene(gameScene);


        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);


        stage.setScene(gameScene);
        stage.show();
    }



    //private ObservableList<String> list = FXCollections.observableArrayList("red", "blue","yellow");
    /*
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
     */



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