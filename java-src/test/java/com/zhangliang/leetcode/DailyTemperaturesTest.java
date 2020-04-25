package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class DailyTemperaturesTest {

    @Test
    public void testCase() {
        DailyTemperatures s = new DailyTemperatures();
        int[] ans = s.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
        assertArrayEquals(new int[] { 1, 1, 4, 2, 1, 1, 0, 0 }, ans);
    }
}
