package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestSubarrayWithDifferenceLessThanKTest {

    @Test
    public void testCase() {
        LongestSubarrayWithDifferenceLessThanK s = new LongestSubarrayWithDifferenceLessThanK();
        int ans = s.solve(new int[] { 1, 9, 10, 11, 3, 5, 7 }, 2);
        assertEquals(3, ans);
    }
}
