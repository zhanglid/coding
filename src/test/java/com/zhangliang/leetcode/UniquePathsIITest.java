package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UniquePathsIITest {

    @Test
    public void testCase() {
        UniquePathsII s = new UniquePathsII();
        int ans = s.uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } });
        assertEquals(2, ans);
    }

    @Test
    public void errCase() {
        UniquePathsII s = new UniquePathsII();
        int ans = s.uniquePathsWithObstacles(new int[][] { { 1 } });
        assertEquals(0, ans);
    }
}
