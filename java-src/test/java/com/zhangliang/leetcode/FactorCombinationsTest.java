package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class FactorCombinationsTest {

    @Test
    public void testCase() {
        FactorCombinations s = new FactorCombinations();
        List<List<Integer>> ans = s.getFactors(1);
        assertEquals(Arrays.asList(), ans);
    }

    @Test
    public void testCase2() {
        FactorCombinations s = new FactorCombinations();
        List<List<Integer>> ans = s.getFactors(37);
        assertEquals(Arrays.asList(), ans);
    }

    @Test
    public void testCase3() {
        FactorCombinations s = new FactorCombinations();
        List<List<Integer>> ans = s.getFactors(12);
        assertEquals(Arrays.asList(Arrays.asList(2, 6), Arrays.asList(2, 2, 3), Arrays.asList(3, 4)), ans);
    }

    @Test
    public void testCase4() {
        FactorCombinations s = new FactorCombinations();
        List<List<Integer>> ans = s.getFactors(32);
        assertEquals(Arrays.asList(Arrays.asList(2, 16), Arrays.asList(2, 2, 8), Arrays.asList(2, 2, 2, 4),
                Arrays.asList(2, 2, 2, 2, 2), Arrays.asList(2, 4, 4), Arrays.asList(4, 8)), ans);
    }
}
