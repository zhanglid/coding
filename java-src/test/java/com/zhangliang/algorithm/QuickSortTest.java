package com.zhangliang.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void testCase() {
        QuickSort s = new QuickSort();
        int[] nums = new int[] { 3, 4, 2, 3, 1 };
        s.sort(nums);
        assertArrayEquals((new int[] { 1, 2, 3, 3, 4 }), nums);
    }
}
