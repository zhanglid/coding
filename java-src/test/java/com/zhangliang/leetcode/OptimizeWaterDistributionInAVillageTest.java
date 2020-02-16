package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class OptimizeWaterDistributionInAVillageTest {

    @Test
    public void testCase() {
        OptimizeWaterDistributionInAVillage s = new OptimizeWaterDistributionInAVillage();
        int ans = s.minCostToSupplyWater(3, new int[] { 1, 2, 2 }, new int[][] { { 1, 2, 1 }, { 2, 3, 1 } });
        assertEquals(3, ans);
    }
}
