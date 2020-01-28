package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CombinationSumTest {

    private String[] transform(List<List<Integer>> lists) {
        String[] strs = new String[lists.size()];

        for (int i = 0; i < lists.size(); i++) {
            strs[i] = lists.get(i).toString();
        }

        Arrays.sort(strs);
        return strs;
    }

    @Test
    public void testCase() {
        CombinationSum s = new CombinationSum();
        List<List<Integer>> ans = s.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        String[] expected = new String[] { "[7]", "[2, 2, 3]" };
        Arrays.sort(expected);
        assertArrayEquals(expected, transform(ans));
    }

    @Test
    public void testCase2() {
        CombinationSum s = new CombinationSum();
        List<List<Integer>> ans = s.combinationSum(new int[] { 2, 3, 5 }, 8);
        String[] expected = new String[] { "[2, 2, 2, 2]", "[2, 3, 3]", "[3, 5]" };
        Arrays.sort(expected);
        assertArrayEquals(expected, transform(ans));
    }
}
