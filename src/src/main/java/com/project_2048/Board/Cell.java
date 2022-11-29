package com.project_2048.Board;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Cell {
    public Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    public boolean getModify() {
        return modify;
    }


    /**
     * Cells, constructor is to create the 4 x 4 empty boxes.
     * @param x = width of the small individual box
     * @param y = height of the small individual box
     * @param scale =
     * @param root = stage and scene to get the root
     */

    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.root = root;
        // the getSingleInstance() will ensure there is only one object across the application available.
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    /**
     * setTextClass set the text(number) for the start of the game (randomise) )
      */

    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     * Change the appearance number in each of the box
     * @param cell
     * changing the cell by using the control in "GameScene.java"
     * it will update the numbering (value) of the cell and also the colour using the setcolourNumber()
     */

    public void changeCell(Cell cell) {
        //changing text
        TextMaker.changeTwoText(textClass, cell.getTextClass());

        root.getChildren().remove(cell.getTextClass()); // remove the changed position number
        root.getChildren().remove(textClass); // remove the original position number

        // set the new changed Number(test) when
        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }

        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }

        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     *
     * @param number , set the number towards the colour code.
     */
    public void setColorByNumber(int number) {
        switch (number) {
            case 0:
                rectangle.setFill(Color.rgb(227, 226, 226, 0.5));
                break;
            case 2:
                rectangle.setFill(Color.rgb(232, 255, 100, 0.5));
                break;
            case 4:
                rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
                break;
            case 8:
                rectangle.setFill(Color.rgb(232, 200, 44, 0.8));
                break;
            case 16:
                rectangle.setFill(Color.rgb(232, 170, 44, 0.8));
                break;
            case 32:
                rectangle.setFill(Color.rgb(180, 120, 44, 0.7));
                break;
            case 64:
                rectangle.setFill(Color.rgb(180, 100, 44, 0.7));
                break;
            case 128:
                rectangle.setFill(Color.rgb(180, 80, 44, 0.7));
                break;
            case 256:
                rectangle.setFill(Color.rgb(180, 60, 44, 0.8));
                break;
            case 512:
                rectangle.setFill(Color.rgb(180, 30, 44, 0.8));
                break;
            case 1024:
                rectangle.setFill(Color.rgb(250, 0, 44, 0.8));
                break;
            case 2048:
                rectangle.setFill(Color.rgb(250, 0, 0, 1));


        }
    }

    /**
     * addition happen over here. Add the 2 value which is valid to be added
     */
    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");  // to make sure the number become 0 and then the colour will be changed.
        root.getChildren().remove(textClass);

        // result of addition
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());

        //temp


    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    private Text getTextClass() {
        return textClass;
    }

}
