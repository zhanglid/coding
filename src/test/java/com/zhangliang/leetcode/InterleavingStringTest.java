package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InterleavingStringTest {

    @Test
    public void testCase() {
        InterleavingString s = new InterleavingString();
        boolean ans = s.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        InterleavingString s = new InterleavingString();
        boolean ans = s.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        assertEquals(false, ans);
    }
}
