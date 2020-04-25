package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProfitableSchemesTest {

    @Test
    public void testCase() {
        ProfitableSchemes s = new ProfitableSchemes();
        int ans = s.profitableSchemes(5, 3, new int[] { 2, 2 }, new int[] { 2, 3 });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        ProfitableSchemes s = new ProfitableSchemes();
        int ans = s.profitableSchemes(10, 5, new int[] { 2, 3, 5 }, new int[] { 6, 7, 8 });
        assertEquals(7, ans);
    }
}
