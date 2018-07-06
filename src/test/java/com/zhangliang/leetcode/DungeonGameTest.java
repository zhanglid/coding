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
}
