package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class IntersectionOfTwoArraysIITest {

    private void assertCorrect(int[] expected, int[] ans) {
        Arrays.sort(expected);
        Arrays.sort(ans);
        assertArrayEquals(expected, ans);
    }

    @Test
    public void testCase() {
        IntersectionOfTwoArraysII s = new IntersectionOfTwoArraysII();
        int[] ans = s.intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 });
        assertCorrect(new int[] { 2, 2 }, ans);
    }

    @Test
    public void testCase2() {
        IntersectionOfTwoArraysII s = new IntersectionOfTwoArraysII();
        int[] ans = s.intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
        assertCorrect(new int[] { 4, 9 }, ans);
    }
}
