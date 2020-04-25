package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoldWordsInStringTest {

    @Test
    public void testCase() {
        BoldWordsInString s = new BoldWordsInString();
        String ans = s.boldWords(new String[] { "ab", "bc" }, "aabcd");
        assertEquals("a<b>abc</b>d", ans);
    }

    @Test
    public void errCase() {
        BoldWordsInString s = new BoldWordsInString();
        String ans = s.boldWords(new String[] { "ccb", "b", "d", "cba", "dc" }, "eeaadadadc");
        assertEquals("eeaa<b>d</b>a<b>d</b>a<b>dc</b>", ans);
    }
}
