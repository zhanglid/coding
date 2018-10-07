package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SlidingPuzzleTest {

    @Test
    public void testCase() {
        SlidingPuzzle s = new SlidingPuzzle();
        int ans = s.slidingPuzzle(new int[][] { { 1, 2, 3 }, { 4, 0, 5 } });
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        SlidingPuzzle s = new SlidingPuzzle();
        int ans = s.slidingPuzzle(new int[][] { { 1, 2, 3 }, { 5, 4, 0 } });
        assertEquals(-1, ans);
    }

    @Test
    public void testCase3() {
        SlidingPuzzle s = new SlidingPuzzle();
        int ans = s.slidingPuzzle(new int[][] { { 4, 1, 2 }, { 5, 0, 3 } });
        assertEquals(5, ans);
    }

    @Test
    public void testCase4() {
        SlidingPuzzle s = new SlidingPuzzle();
        int ans = s.slidingPuzzle(new int[][] { { 3, 2, 4 }, { 1, 5, 0 } });
        assertEquals(14, ans);
    }
}
