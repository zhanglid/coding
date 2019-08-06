package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestSubstringWithAtMostKDistinctCharactersTest {

    @Test
    public void testCase() {
        LongestSubstringWithAtMostKDistinctCharacters s = new LongestSubstringWithAtMostKDistinctCharacters();
        int ans = s.lengthOfLongestSubstringKDistinct("eceba", 2);
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        LongestSubstringWithAtMostKDistinctCharacters s = new LongestSubstringWithAtMostKDistinctCharacters();
        int ans = s.lengthOfLongestSubstringKDistinct("aa", 1);
        assertEquals(2, ans);
    }
}
