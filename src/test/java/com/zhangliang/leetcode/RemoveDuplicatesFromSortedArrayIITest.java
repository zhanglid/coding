package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayIITest {

    @Test
    public void testCase() {
        RemoveDuplicatesFromSortedArrayII s = new RemoveDuplicatesFromSortedArrayII();
        int ans = s.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 });
        assertEquals(5, ans);
    }

    @Test
    public void testCase2() {
        RemoveDuplicatesFromSortedArrayII s = new RemoveDuplicatesFromSortedArrayII();
        int ans = s.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 });
        assertEquals(7, ans);
    }
}
