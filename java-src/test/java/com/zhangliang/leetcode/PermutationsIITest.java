package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PermutationsIITest {

    private String[] transform(List<List<Integer>> list) {
        String[] ans = new String[list.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i).toString();
        }

        Arrays.sort(ans);
        return ans;
    }

    @Test
    public void testCase() {
        PermutationsII s = new PermutationsII();
        List<List<Integer>> ans = s.permuteUnique(new int[] { 1, 1, 2 });
        String[] expected = new String[] { "[1, 1, 2]", "[1, 2, 1]", "[2, 1, 1]" };
        Arrays.sort(expected);
        assertArrayEquals(expected, transform(ans));
    }
}
