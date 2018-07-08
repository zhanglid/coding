package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BestTimeToBuyAndSellStockIVTest {

    @Test
    public void testCase() {
        BestTimeToBuyAndSellStockIV s = new BestTimeToBuyAndSellStockIV();
        int ans = s.maxProfit(2, new int[] { 2, 4, 1 });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        BestTimeToBuyAndSellStockIV s = new BestTimeToBuyAndSellStockIV();
        int ans = s.maxProfit(2, new int[] { 3, 2, 6, 5, 0, 3 });
        assertEquals(7, ans);
    }

    @Test
    public void errCase() {
        BestTimeToBuyAndSellStockIV s = new BestTimeToBuyAndSellStockIV();
        int ans = s.maxProfit(2, new int[] { 3, 3, 5, 0, 0, 3, 1, 4 });
        assertEquals(6, ans);
    }
}
