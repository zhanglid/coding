package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExpressiveWordsTest {

    @Test
    public void testCase() {
        ExpressiveWords s = new ExpressiveWords();
        int ans = s.expressiveWords("heeellooo", new String[] { "hello", "hi", "helo" });
        assertEquals(1, ans);
    }
}
