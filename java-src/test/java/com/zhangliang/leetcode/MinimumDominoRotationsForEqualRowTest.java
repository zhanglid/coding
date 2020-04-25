package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinimumDominoRotationsForEqualRowTest {

    @Test
    public void testCase() {
        MinimumDominoRotationsForEqualRow s = new MinimumDominoRotationsForEqualRow();
        int ans = s.minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        MinimumDominoRotationsForEqualRow s = new MinimumDominoRotationsForEqualRow();
        int ans = s.minDominoRotations(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 });
        assertEquals(-1, ans);
    }
}
