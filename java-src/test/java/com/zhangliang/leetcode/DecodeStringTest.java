package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DecodeStringTest {
    @Test
    public void testCase() {
        DecodeString s = new DecodeString();
        String ans = s.decodeString("3[a]2[bc]");
        assertEquals("aaabcbc", ans);
    }

    @Test
    public void testCase2() {
        DecodeString s = new DecodeString();
        String ans = s.decodeString("3[a2[c]]");
        assertEquals("accaccacc", ans);
    }

    @Test
    public void testCase3() {
        DecodeString s = new DecodeString();
        String ans = s.decodeString("2[abc]3[cd]ef");
        assertEquals("abcabccdcdcdef", ans);
    }
}
