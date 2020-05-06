package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximumInnerProductOfKNumTest {

    @Test
    public void testCase() {
        MaximumInnerProductOfKNum s = new MaximumInnerProductOfKNum();
        int ans = s.maxSumFromTwoSides(new int[] { 1, 2, 3, 4, 5, 6, 7, 1 }, 2);
        assertEquals(8, ans);
    }

    @Test
    public void testCase2() {
        MaximumInnerProductOfKNum s = new MaximumInnerProductOfKNum();
        int ans = s.maxInnerProduct(new int[] { 1, 2, 3, 4, 5, 6, 7, 1 }, 2, new int[] { 1, 1 });
        assertEquals(13, ans);
    }
}
