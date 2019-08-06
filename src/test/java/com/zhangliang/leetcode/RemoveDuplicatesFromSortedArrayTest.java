package com.zhangliang.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void testCase() {
        RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
        int[] input = new int[] { 1, 1, 2 };
        int ans = s.removeDuplicates(input);

        assertArrayEquals(new int[] { 1, 2 }, Arrays.copyOfRange(input, 0, ans));
    }

    @Test
    public void testCase2() {
        RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
        int[] input = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int ans = s.removeDuplicates(input);

        assertArrayEquals(new int[] { 0, 1, 2, 3, 4 }, Arrays.copyOfRange(input, 0, ans));
    }
}
