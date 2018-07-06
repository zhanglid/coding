package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximumGapTest {

    @Test
    public void testCase() {
        MaximumGap s = new MaximumGap();
        int ans = s.maximumGap(new int[] { 3, 6, 9, 1 });
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        MaximumGap s = new MaximumGap();
        int ans = s.maximumGap(new int[] { 10 });
        assertEquals(0, ans);
    }
}
