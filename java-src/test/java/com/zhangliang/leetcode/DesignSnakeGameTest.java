package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class DesignSnakeGameTest {

    @Test
    public void testCase() {
        DesignSnakeGame.SnakeGame s = new DesignSnakeGame.SnakeGame(3, 2, new int[][] { { 1, 2 }, { 0, 1 } });
        assertEquals(0, s.move("R"));
        assertEquals(0, s.move("D"));
        assertEquals(1, s.move("R"));
        assertEquals(1, s.move("U"));
        assertEquals(2, s.move("L"));
        assertEquals(-1, s.move("U"));
    }
}
