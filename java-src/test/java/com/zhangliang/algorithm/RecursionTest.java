package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import java.util.*;
import java.util.List;

import org.junit.Test;

public class RecursionTest {

    @Test
    public void testCase() {
        Recursion.Permutation s = new Recursion.Permutation();
        List<List<Integer>> ans = s.permute(new int[] { 1, 2, 3 });
        assertEquals(
                Arrays.deepToString(
                        new int[][] { { 1, 2, 3 }, { 1, 3, 2 }, { 2, 1, 3 }, { 2, 3, 1 }, { 3, 2, 1 }, { 3, 1, 2 } }),
                ans.toString());
    }
}
