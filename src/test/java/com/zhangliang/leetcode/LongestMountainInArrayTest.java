package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class LongestMountainInArrayTest {

    @Test
    public void testCase() {
        LongestMountainInArray s = new LongestMountainInArray();
        int ans = s.longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 });
        assertEquals(5, ans);
    }

    @Test
    public void errCase() {
        LongestMountainInArray s = new LongestMountainInArray();
        int ans = s.longestMountain(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
        assertEquals(0, ans);
    }
}
