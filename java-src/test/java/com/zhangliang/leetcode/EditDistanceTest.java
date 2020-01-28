package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EditDistanceTest {

    @Test
    public void testCase() {
        EditDistance s = new EditDistance();
        int ans = s.minDistance("horse", "ros");
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        EditDistance s = new EditDistance();
        int ans = s.minDistance("intention", "execution");
        assertEquals(5, ans);
    }
}
