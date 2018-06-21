package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestSubstringWithAtMostTwoDistinctCharactersTest {

    @Test
    public void testCase() {
        LongestSubstringWithAtMostTwoDistinctCharacters s = new LongestSubstringWithAtMostTwoDistinctCharacters();
        int ans = s.lengthOfLongestSubstringTwoDistinct("eceba");
        assertEquals(ans, 3);
    }

    @Test
    public void testCase2() {
        LongestSubstringWithAtMostTwoDistinctCharacters s = new LongestSubstringWithAtMostTwoDistinctCharacters();
        int ans = s.lengthOfLongestSubstringTwoDistinct("ccaabbb");
        assertEquals(ans, 5);
    }

    @Test
    public void errCase() {
        LongestSubstringWithAtMostTwoDistinctCharacters s = new LongestSubstringWithAtMostTwoDistinctCharacters();
        int ans = s.lengthOfLongestSubstringTwoDistinct(
                "abZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX");
        assertEquals(ans, 101);
    }
}
