package com.zhangliang.facebook;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestArithmeticProgressionTest {

    @Test
    public void testCase() {
        LongestArithmeticProgression s = new LongestArithmeticProgression();
        int ans = s.maxArithmeticLength(new int[] { 0, 4, 8, 16 }, new int[] { 0, 2, 6, 12, 14, 20 });
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        LongestArithmeticProgression s = new LongestArithmeticProgression();
        int ans = s.maxArithmeticLength(new int[] { 0, 4, 8, 16 }, new int[] { 12 });
        assertEquals(5, ans);
    }

    @Test
    public void testCase3() {
        LongestArithmeticProgression s = new LongestArithmeticProgression();
        int ans = s.maxArithmeticLength(new int[] { 0, 4, 8, 16 }, new int[] { 2 });
        assertEquals(-1, ans);
    }

    @Test
    public void testCase4() {
        LongestArithmeticProgression s = new LongestArithmeticProgression();
        int ans = s.maxArithmeticLength(new int[] { 0, 4, 8, 16 }, new int[] { -4, 12 });
        assertEquals(6, ans);
    }

    @Test
    public void testCase5() {
        LongestArithmeticProgression s = new LongestArithmeticProgression();
        int ans = s.maxArithmeticLength(new int[] { 0, 4, 8 }, new int[] { -8, -4 });
        assertEquals(5, ans);
    }
}
