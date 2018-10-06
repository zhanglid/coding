package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BusRoutesTest {

    @Test
    public void testCase() {
        BusRoutes s = new BusRoutes();
        int ans = s.numBusesToDestination(new int[][] { { 1, 2, 7 }, { 3, 6, 7 } }, 1, 6);
        assertEquals(2, ans);
    }

    @Test
    /*
        should return 1 if it can be reached in current bus
    */
    public void errCase() {
        BusRoutes s = new BusRoutes();
        int ans = s.numBusesToDestination(
                new int[][] { { 0, 4, 15 }, { 17, 20 }, { 4, 11, 14, 16, 23 }, { 1, 12, 15, 16 }, { 0, 6, 8, 10 } }, 10,
                0);
        assertEquals(1, ans);
    }
}
