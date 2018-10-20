package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ToggleMatrixToOneTest {

    @Test
    public void testCase() {
        ToggleMatrixToOne s = new ToggleMatrixToOne();
        boolean ans = s.solve(new int[][] { { 1, 0 }, { 0, 1 } });
        assertEquals(false, ans);
    }

    @Test
    public void testCase2() {
        ToggleMatrixToOne s = new ToggleMatrixToOne();
        boolean ans = s.solve(new int[][] { { 0, 0 }, { 1, 1 } });
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        ToggleMatrixToOne s = new ToggleMatrixToOne();
        boolean ans = s.solve(new int[][] { { 0, 1 }, { 1, 1 } });
        assertEquals(false, ans);
    }
}
