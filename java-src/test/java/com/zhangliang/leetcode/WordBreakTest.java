package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class WordBreakTest {

    @Test
    public void testCase() {
        WordBreak s = new WordBreak();
        boolean ans = s.wordBreak("leetcode", Arrays.asList("leet", "code"));
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        WordBreak s = new WordBreak();
        boolean ans = s.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        WordBreak s = new WordBreak();
        boolean ans = s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        assertEquals(false, ans);
    }

}
