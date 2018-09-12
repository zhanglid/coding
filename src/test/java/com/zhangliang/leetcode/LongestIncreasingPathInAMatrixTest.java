package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class LongestIncreasingPathInAMatrixTest {

    @Test
    public void testCase() {
        LongestIncreasingPathInAMatrix s = new LongestIncreasingPathInAMatrix();
        int ans = s.longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } });
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        LongestIncreasingPathInAMatrix s = new LongestIncreasingPathInAMatrix();
        int ans = s.longestIncreasingPath(new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } });
        assertEquals(4, ans);
    }

}
