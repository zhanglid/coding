package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ImplementStrStrTest {

    @Test
    public void testCase() {
        ImplementStrStr s = new ImplementStrStr();
        int ans = s.strStr("hello", "ll");
        assertEquals(ans, 2);
    }

    @Test
    public void testCase2() {
        ImplementStrStr s = new ImplementStrStr();
        int ans = s.strStr("aaaaa", "bba");
        assertEquals(ans, -1);
    }
}
