package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximalRectangleTest {

    @Test
    public void testCase() {
        MaximalRectangle s = new MaximalRectangle();
        char[][] input = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
        int ans = s.maximalRectangle(input);
        assertEquals(6, ans);
    }
}
