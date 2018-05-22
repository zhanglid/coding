package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PermutationsTest {

    private List<String> getStrings(List<List<Integer>> lists) {
        List<String> ans = new ArrayList<>();
        for (List<Integer> list : lists) {
            ans.add(list.toString());
        }

        return ans;
    }

    @Test
    public void testCase() {
        Permutations s = new Permutations();
        List<List<Integer>> ans = s.permute(new int[] { 1, 2, 3 });
        String[] ansStrs = getStrings(ans).toArray(new String[0]);
        String[] expected = new String[] { "[1, 2, 3]", "[1, 3, 2]", "[2, 1, 3]", "[2, 3, 1]", "[3, 1, 2]", "[3, 2, 1]" };
        Arrays.sort(ansStrs);
        Arrays.sort(expected);
        assertArrayEquals(expected, ansStrs);
    }
}
