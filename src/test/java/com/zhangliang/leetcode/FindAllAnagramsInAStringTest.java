package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class FindAllAnagramsInAStringTest {
    private void assertCorrect(List<Integer> expected, List<Integer> ans) {
        Collections.sort(expected);
        Collections.sort(ans);
        assertArrayEquals(expected.toArray(new Integer[0]), ans.toArray(new Integer[0]));
    }

    @Test
    public void testCase() {
        FindAllAnagramsInAString s = new FindAllAnagramsInAString();
        List<Integer> ans = s.findAnagrams("cbaebabacd", "abc");
        assertCorrect(Arrays.asList(0, 6), ans);
    }

    @Test
    public void testCase2() {
        FindAllAnagramsInAString s = new FindAllAnagramsInAString();
        List<Integer> ans = s.findAnagrams("abab", "ab");
        assertCorrect(Arrays.asList(0, 1, 2), ans);
    }

    @Test
    public void errCase() {
        FindAllAnagramsInAString s = new FindAllAnagramsInAString();
        List<Integer> ans = s.findAnagrams("", "a");
        assertCorrect(Arrays.asList(), ans);
    }
}
