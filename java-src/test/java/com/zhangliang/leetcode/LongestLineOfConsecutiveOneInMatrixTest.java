package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestLineOfConsecutiveOneInMatrixTest {

    @Test
    public void testCase() {
        LongestLineOfConsecutiveOneInMatrix s = new LongestLineOfConsecutiveOneInMatrix();
        int ans = s.longestLine(new int[][] { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } });
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        LongestLineOfConsecutiveOneInMatrix s = new LongestLineOfConsecutiveOneInMatrix();
        int ans = s.longestLine(new int[][] {});
        assertEquals(0, ans);
    }
}
