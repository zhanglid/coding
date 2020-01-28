package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KthLargestElementInAnArrayTest {

    @Test
    public void testCase() {
        KthLargestElementInAnArray s = new KthLargestElementInAnArray();
        int ans = s.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
        assertEquals(5, ans);
    }

    @Test
    public void testCase2() {
        KthLargestElementInAnArray s = new KthLargestElementInAnArray();
        int ans = s.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4);
        assertEquals(4, ans);
    }
}
