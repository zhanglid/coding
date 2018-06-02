package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class NQueensTest {

    private void arrayStringifySort(String[][] strss) {
        Arrays.sort(strss, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return Arrays.toString(a).compareTo(Arrays.toString(b));
            }
        });
    }

    private String[][] getStringArray(List<List<String>> data) {
        String[][] ans = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            ans[i] = data.get(i).toArray(new String[0]);
        }
        return ans;
    }

    @Test
    public void testCase() {
        NQueens s = new NQueens();
        List<List<String>> ans = s.solveNQueens(4);
        String[][] expected = { { ".Q..", "...Q", "Q...", "..Q." }, { "..Q.", "Q...", "...Q", ".Q.." } };
        String[][] ansArray = getStringArray(ans);
        arrayStringifySort(expected);
        arrayStringifySort(ansArray);
        assertArrayEquals(expected, ansArray);
    }
}
