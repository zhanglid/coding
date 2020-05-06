package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberOfFallingTest {

    @Test
    public void testCase() {
        /**
         * 4 -> 3, 1, 0 | 3 -> 2, 1, 0 | 2 -> 1, 0 | 1 -> 0 |
         */
        NumberOfFalling s = new NumberOfFalling();
        int ans = s.solve(4, new int[] { 3 });
        assertEquals(2, ans);
    }
}
