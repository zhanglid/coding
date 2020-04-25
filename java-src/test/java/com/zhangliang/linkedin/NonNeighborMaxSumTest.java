package com.zhangliang.linkedin;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NonNeighborMaxSumTest {

    @Test
    public void testCase() {
        NonNeighborMaxSum s = new NonNeighborMaxSum();
        int ans = s.maxSum(new int[] { 3, 4, 5, 6, 7 });
        assertEquals(15, ans);
    }

    @Test
    public void testCase2() {
        NonNeighborMaxSum s = new NonNeighborMaxSum();
        int ans = s.maxSum(new int[] { -1, -2, -3 });
        assertEquals(-1, ans);
    }

    @Test
    public void testCase3() {
        NonNeighborMaxSum s = new NonNeighborMaxSum();
        int ans = s.maxSum(new int[] { -1, 2 });
        assertEquals(2, ans);
    }
}
