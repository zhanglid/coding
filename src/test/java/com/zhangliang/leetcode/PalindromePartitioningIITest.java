package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PalindromePartitioningIITest {

    @Test
    public void testCase() {
        PalindromePartitioningII s = new PalindromePartitioningII();
        int ans = s.minCut("aab");
        assertEquals(1, ans);
    }

    @Test
    public void errCase() {
        PalindromePartitioningII s = new PalindromePartitioningII();
        int ans = s.minCut("efe");
        assertEquals(0, ans);
    }
}
