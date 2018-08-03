package com.zhangliang.algorithm;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testCase() {
        MergeSort s = new MergeSort();
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        s.sort(arr);
        assertArrayEquals(arr, new int[] { 5, 6, 7, 11, 12, 13 });
    }
}