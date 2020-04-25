package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HouseRobberTest {

    @Test
    public void testCase() {
        HouseRobber s = new HouseRobber();
        int ans = s.rob(new int[] { 1, 2, 3, 1 });
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        HouseRobber s = new HouseRobber();
        int ans = s.rob(new int[] { 2, 7, 9, 3, 1 });
        assertEquals(12, ans);
    }

    @Test
    public void errCase() {
        HouseRobber s = new HouseRobber();
        int ans = s.rob(new int[] {});
        assertEquals(0, ans);
    }
}
