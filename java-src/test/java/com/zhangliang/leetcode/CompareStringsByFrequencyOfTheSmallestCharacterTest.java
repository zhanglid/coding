package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class CompareStringsByFrequencyOfTheSmallestCharacterTest {

    // Input: queries = ["cbd"], words = ["zaaaz"]
    @Test
    public void testCase() {
        CompareStringsByFrequencyOfTheSmallestCharacter s = new CompareStringsByFrequencyOfTheSmallestCharacter();
        int[] ans = s.numSmallerByFrequency(new String[] { "cbd" }, new String[] { "zaaaz" });
        assertArrayEquals(new int[] { 1 }, ans);
    }

    // Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
    @Test
    public void testCase2() {
        CompareStringsByFrequencyOfTheSmallestCharacter s = new CompareStringsByFrequencyOfTheSmallestCharacter();
        int[] ans = s.numSmallerByFrequency(new String[] { "bbb", "cc" }, new String[] { "a", "aa", "aaa", "aaaa" });
        assertArrayEquals(new int[] { 1, 2 }, ans);
    }
}
