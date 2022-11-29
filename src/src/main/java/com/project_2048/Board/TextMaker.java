package com.project_2048.Board;

import com.project_2048.GameScene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {

    }

    /**
     *
     * @return
     */
    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     * creating the Text settings, the default value/number of each set cell , the font size, local it position and the colour of the Text.
     * @param input
     * @param xCell
     * @param yCell
     * @param root
     * @return
     */
    public Text madeText(String input, double xCell, double yCell, Group root) {
        //??
        double length = GameScene.getLENGTH();

        double fontSize = (3 * length) / 7.0;

        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);
        return text;
    }

    /**
     * Swapping text happen.
     * @param first
     * @param second
     */
    public static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        //?
        double tempNumber;

        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);



    }

}
