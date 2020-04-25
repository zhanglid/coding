package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ShortestUnsortedContinuousSubarrayTest {

    @Test
    public void testCase() {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        int ans = s.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 });
        assertEquals(5, ans);
    }

    @Test
    public void errCase() {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        int ans = s.findUnsortedSubarray(new int[] { 1, 2, 3, 4 });
        assertEquals(0, ans);
    }

    @Test
    public void errCase2() {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        int ans = s.findUnsortedSubarray(new int[] { 2, 1 });
        assertEquals(2, ans);
    }

    @Test
    public void errCase3() {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        int ans = s.findUnsortedSubarray(new int[] { 1, 3, 2 });
        assertEquals(2, ans);
    }

}
