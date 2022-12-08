package com.project_2048;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

public class ScoreBoardController {

    FileChooser filechooser = new FileChooser();
    private String highscore = "";
    @FXML
    private Button exitgame;
    @FXML
    private Label myScore4;

}




/*
    public void iniialize(){

        String username = EndGameController.getUsername();
        System.out.println(username);

        int num = (int) GameScene.getScore();
        //getHighScore(num);
        String a = String.valueOf(num);

        highscore = username + ":" + a;
        myScore4.setText(highscore);


        filechooser.setInitialDirectory(new File("D:\\Code 3 (Y2S1)\\Software Maintainance (COMP2042)\\Project\\src\\src\\main\\java\\com\\project_2048\\highscores.txt"));

        try {
            Scanner scanner = new Scanner(filechooser.getInitialDirectory());
            while (scanner.hasNextLine()) {

                mytextarea4.appendText(scanner.nextLine() + "\n");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

 */

/*
    int getHighScore(int num){
        return num;
    }
*/

    //textarea4.appendText(highscore);
                    /*
                if(scanner.hasNextLine() == true){
                    if(num >Integer.parseInt(scanner.nextLine().split(":")[1])) {
                        //textarea4.clear();
                        System.out.println("num"+ num);
                        System.out.println("compared"+Integer.parseInt(scanner.nextLine().split(":")[1]));
                        textarea4.appendText("abc");
                    }

                }
                else {
                    //
                    }
                     */



