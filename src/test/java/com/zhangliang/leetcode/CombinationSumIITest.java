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

    @Test
    public void errCase3() {
        CombinationSumII s = new CombinationSumII();
        List<List<Integer>> output = s.combinationSum2(new int[] { 14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9,
                9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16,
                8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12 }, 27);
        String[] ans = getStrs(output);
        String[] expected = new String[] { "[10, 17]", "[11, 16]", "[13, 14]", "[27]", "[6, 10, 11]", "[6, 21]", "[6, 6, 7, 8]", "[6, 7, 14]", "[6, 8, 13]", "[6, 9, 12]", "[7, 20]", "[7, 8, 12]", "[7, 9, 11]", "[8, 8, 11]", "[8, 9, 10]", "[9, 18]", "[9, 9, 9]" };
        Arrays.sort(ans);
        Arrays.sort(expected);
        assertArrayEquals(expected, ans);
    }

}
