package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RectangleOverlapTest {

    @Test
    public void testCase() {
        RectangleOverlap s = new RectangleOverlap();
        boolean ans = s.isRectangleOverlap(new int[] { 0, 0, 2, 2 }, new int[] { 1, 1, 3, 3 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        RectangleOverlap s = new RectangleOverlap();
        boolean ans = s.isRectangleOverlap(new int[] { 0, 0, 1, 1 }, new int[] { 1, 0, 2, 1 });
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        RectangleOverlap s = new RectangleOverlap();
        boolean ans = s.isRectangleOverlap(new int[] { 5, 15, 8, 18 }, new int[] { 0, 3, 7, 9 });
        assertEquals(false, ans);
    }
}
