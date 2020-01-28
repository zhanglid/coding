
package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PartitionToKEqualSumSubsetsTest {

    @Test
    public void testCase() {
        PartitionToKEqualSumSubsets s = new PartitionToKEqualSumSubsets();
        boolean ans = s.canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        PartitionToKEqualSumSubsets s = new PartitionToKEqualSumSubsets();
        boolean ans = s.canPartitionKSubsets(
                new int[] { 815, 625, 3889, 4471, 60, 494, 944, 1118, 4623, 497, 771, 679, 1240, 202, 601, 883 }, 3);
        assertEquals(true, ans);
    }
}
