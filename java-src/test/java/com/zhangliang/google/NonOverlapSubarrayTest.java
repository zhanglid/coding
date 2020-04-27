package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NonOverlapSubarrayTest {

    @Test
    public void testCase() {
        NonOverlapSubarray s = new NonOverlapSubarray();
        int ans = s.getMinSize(new int[] { 2, 4, 1, 2, 3, 4, 5, 1 }, 6);
        assertEquals(4, ans);
    }
}
