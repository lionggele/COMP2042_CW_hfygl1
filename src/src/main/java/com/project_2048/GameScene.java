package com.project_2048;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;


/**
 * Game Scene is the main method which consist the logic of the game.
 */
public class GameScene {

    private static final int HEIGHT = 700;

    // the grid ( 4x4 )
    public static int n = 4;
    private final static int distanceBetweenCells = 10;
    //calculating the length
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;

    // only can have one textMaker class that can have only one object (an instance of the class) at a time.
    private final TextMaker textMaker = TextMaker.getSingleInstance();

    // Cells Array
    private static Cell[][] cells = new Cell[n][n];
    private Group root;

    // Variable for the score
    static long score;

    // boolean to check whether the Cell is moved
    private boolean ismoveable = true;


    /**
     * get the score from the game scene and then display it at the end game.fxml
      */
    public static long getScore(){
        return score;
    }

    /**
     * setN let the user choose the mode of the game , it can be 6x6 , but the cell will be getting smaller but proportional
     * @param number the number columns and rows that the player will choose to play
     */


    public static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    /**
     * Get the length of the Cell to use it in another method
     * @return length
     */
    public static double getLENGTH() {
        return LENGTH;
    }


    /**
     * randomly generalize the number at a random cell. but it will only spawn Cell with the number of 2 and 4
     *
     * @param
     * @param turn
     */
    private void randomFillNumber(int turn) {

        Cell[][] emptyCells = new Cell[n][n];
        int a = 0;
        int b = 0;
        int aForBound=0,bForBound=0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n-1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        b = 0;
                        a++;
                        if(a==n)
                            break outer;
                    }
                }
            }
        }


        Text text;
        Random random = new Random();
        boolean putTwo = true;
        if (random.nextInt() % 2 == 0)
            putTwo = false;
        int xCell, yCell;
        xCell = random.nextInt(aForBound+1);
        yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY());
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY());
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }


    /**
     * Core of the movement
     * @param i
     * @param j
     * @param direct  4 direction left ,right, up and down
     * @return
     */

    private int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        coordinate = j;
        if (direct == 'r') {
            for (int k = j + 1; k <= n - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= n - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }

    /**
     * method to the cell to left
     */

    private void moveLeft() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                moveHorizontally(i, j, passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }


    /**
     * method to the cell to right
     */

    private void moveRight() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                moveHorizontally(i, j, passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     * method to the cell to Up
     */

    private void moveUp() {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                moveVertically(i, j, passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);

            }
        }

    }

    /**
     * method to the cell to Down
     */

    private void moveDown() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                moveVertically(i, j, passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }
    }


    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            if ((cells[i][des + sign].getNumber() == cells[i][j].getNumber()) && !cells[i][des + sign].getModify() && (cells[i][des + sign].getNumber() != 0)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  check whether additional happen horizontally
     * @param i
     * @param j
     * @param des
     * @param sign
     */

    private void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }
    /**
     *  check whether additional happen vertically
     * @param i
     * @param j
     * @param des
     * @param sign
     */

    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }

    /**
     *  When there are 2 same number, the cells will move, returns true.
     * @param i
     * @param j
     * @return
     */

    private boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    /**
     * When there are not same number , it will return false and would not move.
     * @return
     */

    private boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Check the number of empty cell and also whether we already reached the end of the game til the additional of 2048
     */

    private int haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 2048 )
                    return 0;
                if (cells[i][j].getNumber() == 0)
                    return 1;

            }
        }
        return -1;
    }


    /**
     * sum up the score in every round
     */
    private void sumCellNumbersToScore() {
            score += Cell.scores;
            Cell.scores = 0;


    }

    /**
     *  Create the scene for the 2048 GameScene
     * @param gameScene
     * @param root
     * @param primaryStage
     */

    public void game(Scene gameScene, Group root, Stage primaryStage) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");

        //randomize of the generation.
        randomFillNumber(1);
        randomFillNumber(1);

        //Controls of the game
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> {
            Platform.runLater(() -> {
                int haveEmptyCell;
                boolean doesNotMove;
                if (key.getCode() == KeyCode.DOWN) {
                    GameScene.this.moveDown();
                } else if (key.getCode() == KeyCode.UP) {
                    GameScene.this.moveUp();
                } else if (key.getCode() == KeyCode.LEFT) {
                    GameScene.this.moveLeft();
                } else if (key.getCode() == KeyCode.RIGHT) {
                    GameScene.this.moveRight();
                } else {
                    ismoveable = false;
                    System.out.println("error");
                }
                GameScene.this.sumCellNumbersToScore();
                scoreText.setText(score + "");
                haveEmptyCell = GameScene.this.haveEmptyCell();

                /**
                 * check whether there are any empty cell in the game. 0: there is the Cell Reached 2048, and it will show Victory scene. -1: Game over and there is no any empty cell in the game, it will show Defeat scene. 1: game continue every round because there is empty scene which have a random spawn of cell.
                 */
                if (haveEmptyCell == 0){
                    try {
                        Pane pane = FXMLLoader.load(getClass().getResource("FXML/Victory.fxml"));
                        primaryStage.setScene(new Scene(pane));
                        primaryStage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (haveEmptyCell == -1) {
                    if (GameScene.this.canNotMove()) {
                        try {
                            Pane pane = FXMLLoader.load(getClass().getResource("FXML/Defeat.fxml"));
                            primaryStage.setScene(new Scene(pane));
                            primaryStage.show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(score);
                    }
                } else if (haveEmptyCell == 1 && ismoveable == true){
                    GameScene.this.randomFillNumber(2);
                    Cell.scores = 0;
                }
                }
            );
        });
    }
}





