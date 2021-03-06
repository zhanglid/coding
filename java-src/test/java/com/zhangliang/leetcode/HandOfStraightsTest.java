package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HandOfStraightsTest {

    @Test
    public void testCase() {
        HandOfStraights.DPSolution s = new HandOfStraights.DPSolution();
        boolean ans = s.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        HandOfStraights.DPSolution s = new HandOfStraights.DPSolution();
        boolean ans = s.isNStraightHand(new int[] { 1, 2, 3, 4, 5 }, 4);
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        HandOfStraights.DPSolution s = new HandOfStraights.DPSolution();
        boolean ans = s.isNStraightHand(new int[] { 1, 2, 3, 4, 5, 6 }, 2);
        assertEquals(true, ans);
    }

    @Test
    public void errCase2() {
        HandOfStraights.DPSolution s = new HandOfStraights.DPSolution();
        boolean ans = s.isNStraightHand(new int[] { 5, 1 }, 1);
        assertEquals(true, ans);
    }

    @Test
    public void errCase3() {
        HandOfStraights.DPSolution s = new HandOfStraights.DPSolution();
        boolean ans = s.isNStraightHand(new int[] { 1, 1, 2, 2, 3, 3 }, 3);
        assertEquals(true, ans);
    }

    @Test
    public void errCase4() {
        HandOfStraights.DPSolution s = new HandOfStraights.DPSolution();
        boolean ans = s.isNStraightHand(new int[] { 2, 1 }, 2);
        assertEquals(true, ans);
    }
}
