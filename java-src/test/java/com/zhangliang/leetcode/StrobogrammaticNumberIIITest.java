package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class StrobogrammaticNumberIIITest {

    @Test
    public void testCase() {
        StrobogrammaticNumberIII s = new StrobogrammaticNumberIII();
        int ans = s.strobogrammaticInRange("50", "100");
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        StrobogrammaticNumberIII s = new StrobogrammaticNumberIII();
        int ans = s.strobogrammaticInRange("0", "0");
        assertEquals(1, ans);
    }
}
