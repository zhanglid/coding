package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReorganizeStringTest {

    @Test
    public void testCase() {
        ReorganizeString s = new ReorganizeString();
        String ans = s.reorganizeString("aaab");
        assertEquals("", ans);
    }

    @Test
    public void testCase2() {
        ReorganizeString s = new ReorganizeString();
        String ans = s.reorganizeString("aab");
        assertEquals("aba", ans);
    }
}
