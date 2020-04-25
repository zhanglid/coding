package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FindAndReplaceInStringTest {

    @Test
    public void testCase() {
        FindAndReplaceInString s = new FindAndReplaceInString();
        String ans = s.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" },
                new String[] { "eee", "ffff" });
        assertEquals("eeebffff", ans);
    }

    @Test
    public void testCase2() {
        FindAndReplaceInString s = new FindAndReplaceInString();
        String ans = s.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" },
                new String[] { "eee", "ffff" });
        assertEquals("eeecd", ans);
    }
}
