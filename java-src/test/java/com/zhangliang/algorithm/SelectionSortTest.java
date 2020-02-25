package com.zhangliang.algorithm;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void testCase() {
        SelectionSort s = new SelectionSort();
        int[] nums = new int[] { -3, 4, 7, -1 };
        s.sort(nums);
        assertArrayEquals(new int[] { -3, -1, 4, 7 }, nums);
    }
}
