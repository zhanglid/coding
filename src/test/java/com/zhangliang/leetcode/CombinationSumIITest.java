package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CombinationSumIITest {

    private String[] getStrs(List<List<Integer>> lists) {
        String[] ans = new String[lists.size()];
        int cur = 0;
        for (List<Integer> list : lists) {
            ans[cur++] = list.toString();
        }
        return ans;
    }

    @Test
    public void testCase() {
        CombinationSumII s = new CombinationSumII();
        List<List<Integer>> output = s.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        String[] ans = getStrs(output);
        String[] expected = new String[] { "[1, 7]", "[1, 2, 5]", "[2, 6]", "[1, 1, 6]" };
        Arrays.sort(ans);
        Arrays.sort(expected);
        assertArrayEquals(expected, ans);
    }

    @Test
    public void testCase2() {
        CombinationSumII s = new CombinationSumII();
        List<List<Integer>> output = s.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5);
        String[] ans = getStrs(output);
        String[] expected = new String[] { "[1, 2, 2]", "[5]" };
        Arrays.sort(ans);
        Arrays.sort(expected);
        assertArrayEquals(expected, ans);
    }
}
