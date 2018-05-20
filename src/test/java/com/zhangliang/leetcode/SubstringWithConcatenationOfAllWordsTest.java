package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class SubstringWithConcatenationOfAllWordsTest {

    @Test
    public void testCase() {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        Integer[] ans = s.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }).toArray(new Integer[0]);
        Arrays.sort(ans);
        assertArrayEquals(ans, new Integer[] { 0, 9 });
    }

    @Test
    public void testCase2() {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        Integer[] ans = s.findSubstring("wordgoodstudentgoodword", new String[] { "word", "student" })
                .toArray(new Integer[0]);
        Arrays.sort(ans);
        assertArrayEquals(ans, new Integer[] {});
    }

    @Test
    public void errCase() {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        Integer[] ans = s.findSubstring("aaaaaaaa", new String[] { "aa", "aa", "aa" }).toArray(new Integer[0]);
        Arrays.sort(ans);
        assertArrayEquals(ans, new Integer[] { 0, 1, 2 });
    }
}
