package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;
import org.junit.Test;

public class TopKFrequentElementsTest {

    private void assertCorrect(int[] expected, List<Integer> ans) {
        int[] ansArray = new int[ans.size()];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i] = ans.get(i);
        }
        Arrays.sort(expected);
        Arrays.sort(ansArray);
        assertArrayEquals(expected, ansArray);
    }

    @Test
    public void testCase() {
        TopKFrequentElements s = new TopKFrequentElements();
        List<Integer> ans = s.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        assertCorrect(new int[] { 1, 2 }, ans);
    }

    @Test
    public void testCase2() {
        TopKFrequentElements s = new TopKFrequentElements();
        List<Integer> ans = s.topKFrequent(new int[] { 1 }, 1);
        assertCorrect(new int[] { 1 }, ans);
    }
}
