package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PaintHouseIITest {

    @Test
    public void testCase() {
        PaintHouseII s = new PaintHouseII();
        int ans = s.minCostII(new int[][] { { 1, 5, 3 }, { 2, 9, 4 } });
        assertEquals(5, ans);
    }

    @Test
    public void errCase() {
        PaintHouseII s = new PaintHouseII();
        int ans = s.minCostII(new int[][] { { 8 } });
        assertEquals(8, ans);
    }
}
