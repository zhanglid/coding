package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class WordSearchIITest {

    @Test
    public void testCase() {
        WordSearchII s = new WordSearchII();
        List<String> ans = s.findWords(new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" });
        String[] expect = new String[] { "eat", "oath" };
        Arrays.sort(expect);
        Collections.sort(ans);
        assertArrayEquals(expect, ans.toArray());
    }

    @Test
    public void errCase() {
        WordSearchII s = new WordSearchII();
        List<String> ans = s.findWords(new char[][] { { 'a' } }, new String[] { "a" });
        String[] expect = new String[] { "a" };
        Arrays.sort(expect);
        Collections.sort(ans);
        assertArrayEquals(expect, ans.toArray());
    }

    @Test
    public void errCase2() {
        WordSearchII s = new WordSearchII();
        List<String> ans = s.findWords(new char[][] { { 'a', 'b' }, { 'a', 'a' } },
                new String[] { "aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba" });
        String[] expect = new String[] { "aaa", "aaab", "aaba", "aba", "baa" };
        Arrays.sort(expect);
        Collections.sort(ans);
        assertArrayEquals(expect, ans.toArray());
    }
}
