package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BullsAndCowsTest {

    @Test
    public void testCase() {
        BullsAndCows s = new BullsAndCows();
        String ans = s.getHint("1807", "7810");
        assertEquals("1A3B", ans);
    }

    @Test
    public void testCase2() {
        BullsAndCows s = new BullsAndCows();
        String ans = s.getHint("1123", "0111");
        assertEquals("1A1B", ans);
    }
}
