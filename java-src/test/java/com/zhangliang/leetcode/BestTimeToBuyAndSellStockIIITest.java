package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BestTimeToBuyAndSellStockIIITest {

    @Test
    public void testCase() {
        BestTimeToBuyAndSellStockIII s = new BestTimeToBuyAndSellStockIII();
        int ans = s.maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 });
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        BestTimeToBuyAndSellStockIII s = new BestTimeToBuyAndSellStockIII();
        int ans = s.maxProfit(new int[] { 1, 2, 3, 4, 5 });
        assertEquals(4, ans);
    }

    @Test
    public void testCase3() {
        BestTimeToBuyAndSellStockIII s = new BestTimeToBuyAndSellStockIII();
        int ans = s.maxProfit(new int[] { 7, 6, 4, 3, 1 });
        assertEquals(0, ans);
    }
}
