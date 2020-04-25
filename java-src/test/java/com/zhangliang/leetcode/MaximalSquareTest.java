package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximalSquareTest {

    @Test
    public void testCase() {
        MaximalSquare s = new MaximalSquare();
        int ans = s.maximalSquare(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } });
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        MaximalSquare s = new MaximalSquare();
        int ans = s.maximalSquare(new char[][] { 
            { '1', '0', '1', '0' }, 
            { '1', '0', '1', '1' }, 
            { '1', '0', '1', '1' },
            { '1', '1', '1', '1' } });
        assertEquals(4, ans);
    }
}
