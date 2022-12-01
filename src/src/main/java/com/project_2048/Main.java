package com.project_2048;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.security.cert.PolicyNode;
import java.util.Scanner;

import static javafx.scene.paint.Color.rgb;

public class Main extends Application {
    static final int WIDTH = 900;
    static final int HEIGHT = 900;

    //Game scheme
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, rgb(189, 177, 92));
    private static Scanner input= new Scanner(System.in);
    public PolicyNode accountRoot;

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    //Menu Scene
    private Group menuRoot = new Group();
    private Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
    public void setMenu(Scene menuScene) {this.menuScene = menuScene;}
    public void setMenuRoot(Group menuRoot) {
        this.menuRoot = menuRoot;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        /*

        Group menuRoot = new Group();
        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);

        Group accountRoot = new Group();
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));

        Group getAccountRoot = new Group();
        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
        */
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, rgb(250, 20, 100, 0.2));
        /*
        Group rankRoot = new Group();
        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
        */
        // Menu ( adding )

        BackgroundFill background_fill = new BackgroundFill(rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);

        // Menu ( adding )
        Rectangle backgroundOfMenu = new Rectangle(240, 120, rgb(120, 120, 120, 0.2));
        backgroundOfMenu.setX(WIDTH / 2 - 120);
        backgroundOfMenu.setY(180);
        menuRoot.getChildren().add(backgroundOfMenu);

        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, rgb(120, 20, 100, 0.2));
        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
        backgroundOfMenuForPlay.setY(180);

        //accountRoot.getChildren().add(backgroundOfMenuForPlay);


        //start screen
        /*
        Label label1= new Label("Game Scene ");
        Button button1= new Button("go to game ");

        button1.setOnAction(e -> primaryStage.setScene(gameScene));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        Scene scene1 = new Scene(layout1, 300, 250);

        */
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


        /*

         */

    public static void main(String[] args) {
        launch(args);
    }
}