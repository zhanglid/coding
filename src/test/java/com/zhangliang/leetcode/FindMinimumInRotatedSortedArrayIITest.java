package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayIITest {

    @Test
    public void testCase() {
        FindMinimumInRotatedSortedArrayII s = new FindMinimumInRotatedSortedArrayII();
        int ans = s.findMin(new int[] { 1, 3, 5 });
        assertEquals(ans, 1);
    }

    @Test
    public void testCase2() {
        FindMinimumInRotatedSortedArrayII s = new FindMinimumInRotatedSortedArrayII();
        int ans = s.findMin(new int[] { 2, 2, 2, 0, 1 });
        assertEquals(ans, 0);
    }
}
