package com.project_2048;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextMakerTest {

    @Test
    void getSingleInstance() {
        {assertEquals(null,TextMaker.getSingleInstance());}
    }
}