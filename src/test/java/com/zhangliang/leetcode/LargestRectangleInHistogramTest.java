package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class LargestRectangleInHistogramTest {

    @Test
    public void testCase() {
        LargestRectangleInHistogram s = new LargestRectangleInHistogram();
        int ans = s.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 });
        assertEquals(10, ans);
    }
}
