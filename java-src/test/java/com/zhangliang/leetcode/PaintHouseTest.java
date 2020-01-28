package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PaintHouseTest {

    @Test
    public void testCase() {
        PaintHouse s = new PaintHouse();
        int ans = s.minCost(new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } });
        assertEquals(10, ans);
    }
}
