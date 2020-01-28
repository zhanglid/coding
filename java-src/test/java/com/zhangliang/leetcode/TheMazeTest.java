package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TheMazeTest {

    @Test
    public void testCase() {
        TheMaze s = new TheMaze();
        boolean ans = s.hasPath(new int[][]{
            { 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0 },
            { 1, 1, 0, 1, 1 },
            { 0, 0, 0, 0, 0 },
        }, new int[]{0, 4}, new int[]{4, 4});
        assertEquals(true, ans);
    }
@Test
    public void testCase2() {
        TheMaze s = new TheMaze();
        boolean ans = s.hasPath(new int[][]{
            { 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0 },
            { 1, 1, 0, 1, 1 },
            { 0, 0, 0, 0, 0 },
        }, new int[]{0, 4}, new int[]{3, 2});
        assertEquals(false, ans);
    }
}
