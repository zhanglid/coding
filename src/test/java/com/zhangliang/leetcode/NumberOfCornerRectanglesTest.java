package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class NumberOfCornerRectanglesTest {

    @Test
    public void testCase() {
        NumberOfCornerRectangles s = new NumberOfCornerRectangles();
        int ans = s.countCornerRectangles(
                new int[][] { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } });
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        NumberOfCornerRectangles s = new NumberOfCornerRectangles();
        int ans = s.countCornerRectangles(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } });
        assertEquals(9, ans);
    }

    @Test
    public void testCase3() {
        NumberOfCornerRectangles s = new NumberOfCornerRectangles();
        int ans = s.countCornerRectangles(new int[][] { { 1, 1, 1, 1 } });
        assertEquals(0, ans);
    }
}
