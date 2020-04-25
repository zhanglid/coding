package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class FindKthSmallestPairDistanceTest {

    @Test
    public void testCase() {
        FindKthSmallestPairDistance s = new FindKthSmallestPairDistance();
        int ans = s.smallestDistancePair(new int[] { 1, 3, 1 }, 1);
        assertEquals(0, ans);
    }

    @Test
    public void errCase() {
        FindKthSmallestPairDistance s = new FindKthSmallestPairDistance();
        int ans = s.smallestDistancePair(new int[] { 1, 6, 1 }, 3);
        assertEquals(5, ans);
    }

    @Test
    public void errCase2() {
        FindKthSmallestPairDistance s = new FindKthSmallestPairDistance();
        int ans = s.smallestDistancePair(new int[] { 2, 2, 0, 1, 1, 0, 0, 1, 2, 0 }, 2);
        assertEquals(0, ans);
    }

    @Test
    public void errCase3() {
        FindKthSmallestPairDistance s = new FindKthSmallestPairDistance();
        int ans = s.smallestDistancePair(new int[] { 62, 100, 4 }, 2);
        assertEquals(58, ans);
    }

    @Test
    public void errCase4() {
        FindKthSmallestPairDistance s = new FindKthSmallestPairDistance();
        int ans = s.smallestDistancePair(new int[] { 9, 10, 7, 10, 6, 1, 5, 4, 9, 8 }, 18);
        assertEquals(2, ans);
    }

    @Test
    public void errCase5() {
        FindKthSmallestPairDistance s = new FindKthSmallestPairDistance();
        int ans = s.smallestDistancePair(new int[] { 38, 33, 57, 65, 13, 2, 86, 75, 4, 56 }, 29);
        assertEquals(43, ans);
    }
}
