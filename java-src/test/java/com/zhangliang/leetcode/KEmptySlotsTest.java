package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KEmptySlotsTest {

    @Test
    public void testCase() {
        KEmptySlots s = new KEmptySlots();
        int ans = s.kEmptySlots(new int[] { 1, 3, 2 }, 1);
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        KEmptySlots s = new KEmptySlots();
        int ans = s.kEmptySlots(new int[] { 1, 2, 3 }, 1);
        assertEquals(-1, ans);
    }

    @Test
    public void errCase() {
        KEmptySlots s = new KEmptySlots();
        int ans = s.kEmptySlots(new int[] { 17666, 11897, 7123, 16781, 11277, 11427, 5097, 5956, 8975, 3888, 7709,
                10913, 1739, 17639, 8625, 3033, 2505, 8483, 2816, 3717, 16300, 3246, 7580, 3963, 2726, 19822, 3633,
                13246, 13405, 14076, 8825, 19527, 429, 1131, 6004, 16266, 6784, 5111, 3025, 18468, 16299, 14359, 19268,
                16122, 17384, 17834, 11086, 7577, 8289, 14654, 5353, 4245, 838, 2738, 16879, 3325, 3377, 9149 }, 0);
        assertEquals(41, ans);
    }

    @Test
    public void errCase2() {
        KEmptySlots s = new KEmptySlots();
        int ans = s.kEmptySlots(new int[] { 6, 5, 8, 9, 7, 1, 10, 2, 3, 4 }, 2);
        assertEquals(8, ans);
    }

    @Test
    public void errCase3() {
        KEmptySlots s = new KEmptySlots();
        int ans = s.kEmptySlots(new int[] { 3, 9, 2, 8, 1, 6, 10, 5, 4, 7 }, 1);
        assertEquals(6, ans);
    }
}
