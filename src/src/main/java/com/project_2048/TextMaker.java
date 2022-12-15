package com.project_2048;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *  Text Maker is to create the text in the cell. It has the method of adder which is the main function of the game.
 */
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
     * @param input     number of 2 and 4 which is use to spawn in the cell.
     * @param xCell     x length of the text in the Cell
     * @param yCell     y length of the text in the Cell
     * @return text
     */
    public Text madeText(String input, double xCell, double yCell) {
        //??
        double length = GameScene.getLENGTH();

        double fontSize = (3 * length) / 7.0;

        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (0.5)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);
        return text;
    }

    /**
     * Swapping text happen. First input will swap with the second with the temporally number
     * @param first
     * @param second
     */
    public static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;

        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);
    }

}
