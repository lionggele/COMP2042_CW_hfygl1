package com.project_2048.Controller;

import com.project_2048.GameScene;
import javafx.application.Platform;
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

/**
 * This is an EndGame Controller is implemented with initialize() method. This allows the implementing class to perform any necessary post-processing on the content.
 * It provides the End Game controller with access to the resources that were used to load the document and the location that was used to resolve relative paths within the document.
 */
public class EndGameController implements initializable {

    static File f;
    static File files;
    @FXML
    private Button highScore;

    @FXML
    private Label myScores;

    @FXML
    private TextField Username;

    @FXML
    private TextArea mytextarea4;

    @FXML
    private TextArea mytextarea5;

    @FXML
    private TextArea mytextarea6;

    FileChooser filechooser = new FileChooser();
    public String highscore;
    private String score;

    File file4x4 = new File("HighScore4x4.txt");
    File file5x5 = new File("HighScore5x5.txt");
    File file6x6 = new File("HighScore6x6.txt");


    /**
     * This is a method button which to get the score from Game scene, change data type to string, get and add the username with the scor and load the file which is assigned to when the button clicked.
     * @param event
     */

    @FXML
    public void nextScene(ActionEvent event){
        int num = (int) GameScene.getScore();
        //getHighScore(num);
        score = String.valueOf(num);
        String username = Username.getText();
        highscore = username + ":" + score;

        File fs = getMyfile();

        if (fs.compareTo(file4x4) == 0){
            mytextarea4.appendText(highscore);

        } else if (fs.compareTo(file5x5) == 0){
            mytextarea5.appendText(highscore);

        } else if (fs.compareTo(file6x6) == 0){
            mytextarea6.appendText(highscore);

        }
    }

    /**
     * it is called to initialize a controller after its root element has been completely processed.
     */
    public void initialize(){
        int num = (int) GameScene.getScore();
        score = String.valueOf(num);
        myScores.setText(score);
        filechooser.setInitialDirectory(new File("D:\\Code 3 (Y2S1)\\Software Maintainance (COMP2042)\\Project\\src\\src\\main\\java\\com\\project_2048\\HighScore"));
        files = filechooser.showOpenDialog(new Stage());
        try {
            Scanner scanner = new Scanner(files);
            f = new File(files.getAbsolutePath().substring(files.getAbsolutePath().lastIndexOf("\\")+1));
            if (f.compareTo(file4x4) == 0){
                while (scanner.hasNextLine()) {
                    mytextarea4.appendText(scanner.nextLine() + "\n");

                }
            } else if (f.compareTo(file5x5) == 0){
                while (scanner.hasNextLine()) {
                    mytextarea5.appendText(scanner.nextLine() + "\n");
                }
            } else if (f.compareTo(file6x6) == 0){
                while (scanner.hasNextLine()) {
                    mytextarea6.appendText(scanner.nextLine() + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * the method is to save the data from what is load on the text area
     * @param event
     */
    @FXML
    void save(ActionEvent event) {
        if( f != null) {
            if (f.compareTo(file4x4) == 0) {
                saveData(files, mytextarea4.getText());
            } else if (f.compareTo(file5x5) == 0) {
                saveData(files, mytextarea5.getText());
            } else if (f.compareTo(file6x6) == 0) {
                saveData(files, mytextarea6.getText());
            }
        }

    }

    /**
     * this method is store what the highscore is to a file
     * @param file  read the file
     * @param highscore get the highscore which is asisgned and store it in the file
     */
    public void saveData(File file, String highscore) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(highscore);
            printWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method is to get the file name and path which is selected.
     * @return
     */

    public static File getMyfile(){
        return EndGameController.f;
    }

    /**
     *  This is the quite scene method
     * @param event
     */

    @FXML
    void quit(ActionEvent event) {
        Platform.exit();

    }


}
