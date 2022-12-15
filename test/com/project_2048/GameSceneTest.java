package com.project_2048;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSceneTest {

    @Test
    void getScore() {
        {assertEquals(100, GameScene.score);}
    }

    @Test
    void setN() {
        {assertEquals(4, GameScene.n);}
    }

    @Test
    void getLENGTH() {
        {assertEquals(162, GameScene.n);}
    }
}