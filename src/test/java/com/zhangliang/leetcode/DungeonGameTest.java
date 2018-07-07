package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DungeonGameTest {

    @Test
    public void testCase() {
        DungeonGame s = new DungeonGame();
        int[][] input = new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
        int ans = s.calculateMinimumHP(input);
        assertEquals(7, ans);
    }

    @Test
    public void errCase() {
        DungeonGame s = new DungeonGame();
        int[][] input = new int[][] { { 100 } };
        int ans = s.calculateMinimumHP(input);
        assertEquals(1, ans);
    }

    @Test
    public void errCase2() {
        DungeonGame s = new DungeonGame();
        int[][] input = new int[][] { { 0, 0, 0 }, { 1, 1, -1 } };
        int ans = s.calculateMinimumHP(input);
        assertEquals(1, ans);
    }

    @Test
    public void errCase3() {
        DungeonGame s = new DungeonGame();
        int[][] input = new int[][] { 
            { 1, -3, 3 }, 
            { 0, -2, 0 }, 
            { -3, -3, -3 } 
        };
        int ans = s.calculateMinimumHP(input);
        assertEquals(3, ans);
    }
}
