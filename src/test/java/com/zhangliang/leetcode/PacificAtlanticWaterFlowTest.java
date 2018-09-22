package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PacificAtlanticWaterFlowTest {

    @Test
    public void testCase() {
        PacificAtlanticWaterFlow s = new PacificAtlanticWaterFlow();
        List<int[]> ans = s.pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } });
        assertArrayEquals(ans.toArray(new int[0][]),
                new int[][] { { 0, 4 }, { 1, 3 }, { 1, 4 }, { 2, 2 }, { 3, 0 }, { 3, 1 }, { 4, 0 } });
    }
}
