package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CanPlaceFlowersTest {

    @Test
    public void testCase() {
        CanPlaceFlowers s = new CanPlaceFlowers();
        boolean ans = s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        CanPlaceFlowers s = new CanPlaceFlowers();
        boolean ans = s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2);
        assertEquals(false, ans);
    }
}
