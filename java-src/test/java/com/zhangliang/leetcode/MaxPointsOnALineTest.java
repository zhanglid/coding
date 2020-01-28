package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxPointsOnALineTest {

    @Test
    public void testCase() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } });
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } });
        assertEquals(4, ans);
    }

    @Test
    public void errCase() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(new int[][] { { -4, 1 }, { -7, 7 }, { -1, 5 }, { 9, -25 } });
        assertEquals(3, ans);
    }

    @Test
    public void errCase2() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(new int[][] { { 0, 0 }, { 0, 0 } });
        assertEquals(2, ans);
    }

    @Test
    public void errCase3() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(new int[][] { { 1, 1 }, { 1, 1 }, { 2, 2 }, { 2, 2 } });
        assertEquals(4, ans);
    }

    @Test
    public void errCase4() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(new int[][] { { 0, -12 }, { 5, 2 }, { 2, 5 }, { 0, -5 }, { 1, 5 }, { 2, -2 }, { 5, -4 },
                { 3, 4 }, { -2, 4 }, { -1, 4 }, { 0, -5 }, { 0, -8 }, { -2, -1 }, { 0, -11 }, { 0, -9 } });
        assertEquals(6, ans);
    }

    @Test
    public void errCase5() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(new int[][] { { 3, 10 }, { 0, 2 }, { 0, 2 }, { 3, 10 } });
        assertEquals(4, ans);
    }

    @Test
    public void errCase6() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(new int[][] { { 0, 0 } });
        assertEquals(1, ans);
    }
}
