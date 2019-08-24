package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MonotonicArrayTest {

    @Test
    public void testCase() {
        MonotonicArray s = new MonotonicArray();
        boolean ans = s.isMonotonic(new int[] { 1, 2, 2, 3 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        MonotonicArray s = new MonotonicArray();
        boolean ans = s.isMonotonic(new int[] { 6, 5, 4, 4 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        MonotonicArray s = new MonotonicArray();
        boolean ans = s.isMonotonic(new int[] { 1, 3, 2 });
        assertEquals(false, ans);
    }

    @Test
    public void testCase4() {
        MonotonicArray s = new MonotonicArray();
        boolean ans = s.isMonotonic(new int[] { 1, 2, 4, 5 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase5() {
        MonotonicArray s = new MonotonicArray();
        boolean ans = s.isMonotonic(new int[] { 1, 1, 1 });
        assertEquals(true, ans);
    }
}
