package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void testCase() {
        FindFirstAndLastPositionOfElementInSortedArray s = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] ans = s.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
        assertArrayEquals(new int[] { 3, 4 }, ans);
    }

    @Test
    public void testCase2() {
        FindFirstAndLastPositionOfElementInSortedArray s = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] ans = s.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6);
        assertArrayEquals(new int[] { -1, -1 }, ans);
    }
}
