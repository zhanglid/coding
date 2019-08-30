package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class TopKFrequentWordsTest {
    @Test
    public void testCase() {
        TopKFrequentWords s = new TopKFrequentWords();
        List<String> ans = s.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2);
        assertArrayEquals(new String[] { "i", "love" }, ans.toArray(new String[0]));
    }

    @Test
    public void testCase2() {
        TopKFrequentWords s = new TopKFrequentWords();
        List<String> ans = s.topKFrequent(
                new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4);
        assertArrayEquals(new String[] { "the", "is", "sunny", "day" }, ans.toArray(new String[0]));
    }
}
