package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PathWithMaximumGoldTest {

    @Test
    public void testCase() {
        PathWithMaximumGold s = new PathWithMaximumGold();
        int ans = s.getMaximumGold(new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } });
        assertEquals(24, ans);
    }

    @Test
    public void testCase2() {
        PathWithMaximumGold s = new PathWithMaximumGold();
        int ans = s.getMaximumGold(new int[][] { { 1, 0, 7 }, { 2, 0, 6 }, { 3, 4, 5 }, { 0, 3, 0 }, { 9, 0, 20 } });
        assertEquals(28, ans);
    }
}
