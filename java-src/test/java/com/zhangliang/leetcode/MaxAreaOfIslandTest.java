package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxAreaOfIslandTest {

    @Test
    public void testCase() {
        MaxAreaOfIsland s = new MaxAreaOfIsland();
        int ans = s.maxAreaOfIsland(
                new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                        { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } });
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        MaxAreaOfIsland s = new MaxAreaOfIsland();
        int ans = s.maxAreaOfIsland(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 } });
        assertEquals(0, ans);
    }

    @Test
    public void errCase() {
        MaxAreaOfIsland s = new MaxAreaOfIsland();
        int ans = s.maxAreaOfIsland(
                new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } });
        assertEquals(4, ans);
    }
}
