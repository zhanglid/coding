package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClimbingStairsTest {

    @Test
    public void testCase() {
        ClimbingStairs s = new ClimbingStairs();
        int ans = s.climbStairs(2);
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        ClimbingStairs s = new ClimbingStairs();
        int ans = s.climbStairs(3);
        assertEquals(3, ans);
    }
}
