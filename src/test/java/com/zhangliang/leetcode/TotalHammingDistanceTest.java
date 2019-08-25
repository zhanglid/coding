package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TotalHammingDistanceTest {

    @Test
    public void testCase() {
        TotalHammingDistance s = new TotalHammingDistance();
        int ans = s.totalHammingDistance(new int[] { 4, 14, 2 });
        assertEquals(6, ans);
    }
}
