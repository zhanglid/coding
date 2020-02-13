package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class NumberOfSubmatricesThatSumToTargetTest {

    @Test
    public void testCase() {
        NumberOfSubmatricesThatSumToTarget s = new NumberOfSubmatricesThatSumToTarget();
        int ans = s.numSubmatrixSumTarget(new int[][] { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } }, 0);
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        NumberOfSubmatricesThatSumToTarget s = new NumberOfSubmatricesThatSumToTarget();
        int ans = s.numSubmatrixSumTarget(new int[][] { { 1, -1 }, { -1, 1 } }, 0);
        assertEquals(5, ans);
    }
}
