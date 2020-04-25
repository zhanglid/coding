package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FirstMissingPositiveTest {

    @Test
    public void testCase() {
        FirstMissingPositive s = new FirstMissingPositive();
        int ans = s.firstMissingPositive(new int[] { 1, 2, 0 });
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        FirstMissingPositive s = new FirstMissingPositive();
        int ans = s.firstMissingPositive(new int[] { 3, 4, -1, 1 });
        assertEquals(2, ans);
    }

    @Test
    public void testCase3() {
        FirstMissingPositive s = new FirstMissingPositive();
        int ans = s.firstMissingPositive(new int[] { 7, 8, 9, 11, 12 });
        assertEquals(1, ans);
    }
}
