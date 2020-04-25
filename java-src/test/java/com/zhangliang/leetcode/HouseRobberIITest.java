package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HouseRobberIITest {

    @Test
    public void testCase() {
        HouseRobberII s = new HouseRobberII();
        int ans = s.rob(new int[] { 2, 3, 2 });
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        HouseRobberII s = new HouseRobberII();
        int ans = s.rob(new int[] { 1, 2, 3, 1 });
        assertEquals(4, ans);
    }

    @Test
    public void errCase() {
        HouseRobberII s = new HouseRobberII();
        int ans = s.rob(new int[] { 1 });
        assertEquals(1, ans);
    }

    @Test
    public void errCase2() {
        HouseRobberII s = new HouseRobberII();
        int ans = s.rob(new int[] { 1, 2 });
        assertEquals(2, ans);
    }
    @Test
    public void errCase3() {
        HouseRobberII s = new HouseRobberII();
        int ans = s.rob(new int[] {});
        assertEquals(0, ans);
    }

}
