package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testCase() {
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        int ans = s.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        assertEquals(4, ans);
    }

    @Test
    public void errCase() {
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        int ans = s.lengthOfLIS(new int[] { 2, 2 });
        assertEquals(1, ans);
    }

    @Test
    public void errCase2() {
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        int ans = s.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 4 });
        assertEquals(3, ans);
    }
}
