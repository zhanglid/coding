package com.zhangliang.algorithm;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class HeapSortTest {

    @Test
    public void testCase() {
        HeapSort s = new HeapSort();
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        s.sort(arr);
        assertArrayEquals(arr, new int[] { 5, 6, 7, 11, 12, 13 });
    }

    @Test
    public void testCase2() {
        HeapSort s = new HeapSort();
        int[] arr = { 5, 9, 7 };
        s.sort(arr);
        assertArrayEquals(arr, new int[] { 5, 7, 9 });
    }

}