package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinGameSizeTest {

    @Test
    public void testCase() {
        MinGameSize s = new MinGameSize();
        int[][] input = new int[][] { { 0, 270, 60, 20 }, { 0, 0, 35, 90 }, { 0, 0, 0, 100 }, { 0, 0, 0, 0 }, };
        int ans = s.getMinSize(4, input);
        assertEquals(35, ans);
    }
}
