package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThresholdTest {

    @Test
    public void testCase() {
        MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold s = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
        int ans = s.maxSideLength(
                new int[][] { { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 } }, 4);
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold s = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
        int ans = s.maxSideLength(new int[][] { { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 },
                { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 } }, 1);
        assertEquals(0, ans);
    }

    @Test
    public void testCase3() {
        MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold s = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
        int ans = s.maxSideLength(new int[][] { { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } }, 6);
        assertEquals(3, ans);
    }

    @Test
    public void testCase4() {
        MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold s = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
        int ans = s.maxSideLength(
                new int[][] { { 18, 70 }, { 61, 1 }, { 25, 85 }, { 14, 40 }, { 11, 96 }, { 97, 96 }, { 63, 45 } },
                40184);
        assertEquals(2, ans);
    }
}
