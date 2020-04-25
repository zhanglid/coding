package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RandomPickWithWeightTest {
    @Test
    public void testCase() {
        RandomPickWithWeight.Solution s = new RandomPickWithWeight.Solution(new int[] { 1 });
        int ans = s.pickIndex();
        assertEquals(0, ans);
    }
}
