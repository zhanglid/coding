package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class WordBreakIITest {

    @Test
    public void testCase() {
        WordBreakII s = new WordBreakII();
        List<String> ans = s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        String[] expected = new String[] { "cat sand dog", "cats and dog" };
        Arrays.sort(expected);
        Collections.sort(ans);
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

    @Test
    public void testCase2() {
        WordBreakII s = new WordBreakII();
        List<String> ans = s.wordBreak("pineapplepenapple",
                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        String[] expected = new String[] { "pine apple pen apple", "pineapple pen apple", "pine applepen apple" };
        Arrays.sort(expected);
        Collections.sort(ans);
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

    @Test
    public void testCase3() {
        WordBreakII s = new WordBreakII();
        List<String> ans = s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        String[] expected = new String[] {};
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

    @Test
    public void errCase() {
        WordBreakII s = new WordBreakII();
        List<String> ans = s.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                        "aaaaaaaaaa"));
        String[] expected = new String[] {};
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

    @Test
    public void errCase2() {
        WordBreakII s = new WordBreakII();
        List<String> ans = s.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
        String[] expected = new String[] { "aaa aaaa", "aaaa aaa" };
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }
}
