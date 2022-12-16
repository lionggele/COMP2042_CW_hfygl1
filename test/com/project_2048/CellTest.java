package com.project_2048;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {
    @Test
    void getadded() {
        {assertEquals(false, Cell.getadded());}
    }

    @Test
    void getmoved() {
        {assertEquals(false, Cell.getmoved());}
    }
}