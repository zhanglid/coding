package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {

    @Test
    public void testCase() {
        BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
        int ans = s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        assertEquals(5, ans);
    }

    @Test
    public void testCase2() {
        BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
        int ans = s.maxProfit(new int[] { 7, 6, 4, 3, 1 });
        assertEquals(0, ans);
    }
}
