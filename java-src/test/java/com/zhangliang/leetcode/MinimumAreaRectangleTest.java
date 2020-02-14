package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinimumAreaRectangleTest {

    @Test
    public void testCase() {
        MinimumAreaRectangle s = new MinimumAreaRectangle();
        int ans = s.minAreaRect(new int[][] { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } });
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        MinimumAreaRectangle s = new MinimumAreaRectangle();
        int ans = s.minAreaRect(new int[][] { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 4, 1 }, { 4, 3 } });
        assertEquals(2, ans);
    }
}
