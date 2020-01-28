package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SingleElementInASortedArrayTest {
    @Test
    public void testCase() {
        SingleElementInASortedArray s = new SingleElementInASortedArray();
        int ans = s.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        SingleElementInASortedArray s = new SingleElementInASortedArray();
        int ans = s.singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 });
        assertEquals(10, ans);
    }

    @Test
    public void errCase() {
        SingleElementInASortedArray s = new SingleElementInASortedArray();
        int ans = s.singleNonDuplicate(new int[] { 1, 1, 2, 2, 3 });
        assertEquals(3, ans);
    }
}
