package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class BestTimeToBuyAndSellStockIITest {

    @Test
    public void testCase() {
        BestTimeToBuyAndSellStockII s = new BestTimeToBuyAndSellStockII();
        int ans = s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        assertEquals(7, ans);
    }

    @Test
    public void testCase2() {
        BestTimeToBuyAndSellStockII s = new BestTimeToBuyAndSellStockII();
        int ans = s.maxProfit(new int[] { 1, 2, 3, 4, 5 });
        assertEquals(4, ans);
    }

    @Test
    public void testCase3() {
        BestTimeToBuyAndSellStockII s = new BestTimeToBuyAndSellStockII();
        int ans = s.maxProfit(new int[] { 7, 6, 4, 3, 1 });
        assertEquals(0, ans);
    }

}
