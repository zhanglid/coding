package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TheMazeIITest {

   @Test
    public void testCase() {
        TheMazeII s = new TheMazeII();
        int ans = s.shortestDistance(
            new int[][] {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 }
            },
            new int[]{0, 4},
            new int[]{4, 4}
        );
        assertEquals(12, ans);
    }

    @Test
    public void testCase2() {
        TheMazeII s = new TheMazeII();
        int ans = s.shortestDistance(
            new int[][] {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 }
            },
            new int[]{0, 4},
            new int[]{3, 2}
        );
        assertEquals(-1, ans);
    }
}
