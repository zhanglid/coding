package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidTriangleNumberTest {

    @Test
    public void testCase() {
        ValidTriangleNumber s = new ValidTriangleNumber();
        int ans = s.triangleNumber(new int[] { 2, 2, 3, 4 });
        assertEquals(3, ans);
    }

    @Test
    public void errCase() {
        ValidTriangleNumber s = new ValidTriangleNumber();
        int ans = s.triangleNumber(new int[] { 1, 1, 3, 4 });
        assertEquals(0, ans);
    }

    @Test
    public void errCase2() {
        ValidTriangleNumber s = new ValidTriangleNumber();
        int ans = s.triangleNumber(new int[] { 0, 1, 1, 1 });
        assertEquals(1, ans);
    }

    @Test
    public void errCase3() {
        ValidTriangleNumber s = new ValidTriangleNumber();
        int ans = s.triangleNumber(new int[] { 95, 81, 22, 28, 46, 46, 27, 86, 35, 96 });
        assertEquals(62, ans);
    }
}
