package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SlidingWindowSumWithoutSideTest {

    @Test
    public void testCase() {
        SlidingWindowSumWithoutSide s = new SlidingWindowSumWithoutSide();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
