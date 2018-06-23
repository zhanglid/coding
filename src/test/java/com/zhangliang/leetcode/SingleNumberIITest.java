package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SingleNumberIITest {

    @Test
    public void testCase() {
        SingleNumberII s = new SingleNumberII();
        int ans = s.singleNumber(new int[] { 2, 2, 3, 2 });
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        SingleNumberII s = new SingleNumberII();
        int ans = s.singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 });
        assertEquals(99, ans);
    }
}
