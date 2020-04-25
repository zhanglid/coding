package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RandomPickIndexTest {

    @Test
    public void testCase() {
        RandomPickIndex.Solution s = new RandomPickIndex.Solution(new int[] { 1, 2, 3, 3, 3 });
        int ans = s.pick(2);
        assertEquals(1, ans);
    }
}
