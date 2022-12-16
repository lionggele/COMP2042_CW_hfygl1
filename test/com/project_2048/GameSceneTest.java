package com.project_2048;

import org.junit.jupiter.api.Test;

import static com.project_2048.GameScene.n;
import static org.junit.jupiter.api.Assertions.*;

class GameSceneTest {

    @Test
    void getScore() {
        {assertEquals(0, GameScene.score);}
    }

    @Test
    void setN() {
        {assertEquals(4, n);}
    }

    @Test
    void getLENGTH() {
        {assertEquals(4, n);}
    }
}