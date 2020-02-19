package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class WordPatternIITest {

    @Test
    public void testCase() {
        WordPatternII s = new WordPatternII();
        boolean ans = s.wordPatternMatch("abab", "redblueredblue");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        WordPatternII s = new WordPatternII();
        boolean ans = s.wordPatternMatch("aaaa", "asdasdasdasd");
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        WordPatternII s = new WordPatternII();
        boolean ans = s.wordPatternMatch("aabb", "xyzabcxzyabc");
        assertEquals(false, ans);
    }
}
