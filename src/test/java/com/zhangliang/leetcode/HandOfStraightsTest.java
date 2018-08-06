package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HandOfStraightsTest {

    @Test
    public void testCase() {
        HandOfStraights s = new HandOfStraights();
        boolean ans = s.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        HandOfStraights s = new HandOfStraights();
        boolean ans = s.isNStraightHand(new int[] { 1, 2, 3, 4, 5 }, 4);
        assertEquals(false, ans);
    }

}
