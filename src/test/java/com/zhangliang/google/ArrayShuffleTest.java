package com.zhangliang.google;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ArrayShuffleTest {

    @Test
    public void testCase() {
        ArrayShuffle s = new ArrayShuffle();
        int[] arr1 = new int[] { 1, 2, 3, 4 };
        int[] arr2 = new int[] { 4, 2, 1, 3 };
        int[] arr3 = new int[] { 4, 3, 2, 1 };
        int[] arr4 = new int[] { 1, 3, 4, 2 };
        int[] ans = s.solve(arr1, arr2, arr3);
        assertArrayEquals(arr4, ans);
    }


    @Test
    public void testCase2() {
        ArrayShuffle s = new ArrayShuffle();
        int[] arr1 = new int[] { 1, 2, 3, 4 };
        int[] arr2 = new int[] { 4, 2, 1, 3 };
        int[] arr3 = new int[] { 4, 3, 2, 1 };
        int[] arr4 = new int[] { 1, 3, 4, 2 };
        int[] ans = s.solveWithDuplicate(arr1, arr2, arr3);
        assertArrayEquals(arr4, ans);
    }

}
