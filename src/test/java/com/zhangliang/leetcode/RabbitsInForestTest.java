package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RabbitsInForestTest {

    @Test
    public void testCase() {
        RabbitsInForest s = new RabbitsInForest();
        int ans = s.numRabbits(new int[] { 1, 1, 2 });
        assertEquals(5, ans);
    }

    @Test
    public void testCase2() {
        RabbitsInForest s = new RabbitsInForest();
        int ans = s.numRabbits(new int[] { 10, 10, 10 });
        assertEquals(11, ans);
    }

    @Test
    public void testCase3() {
        RabbitsInForest s = new RabbitsInForest();
        int ans = s.numRabbits(new int[] {});
        assertEquals(0, ans);
    }
}
