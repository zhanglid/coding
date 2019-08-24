package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PartitionEqualSubsetSumTest {
    @Test
    public void testCase() {
        PartitionEqualSubsetSum s = new PartitionEqualSubsetSum();
        boolean ans = s.canPartition(new int[] { 1, 5, 11, 5 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        PartitionEqualSubsetSum s = new PartitionEqualSubsetSum();
        boolean ans = s.canPartition(new int[] { 1, 2, 3, 5 });
        assertEquals(false, ans);
    }
}
