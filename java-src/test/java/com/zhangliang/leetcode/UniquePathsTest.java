package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UniquePathsTest {

    @Test
    public void testCase() {
        UniquePaths s = new UniquePaths();
        int ans = s.uniquePaths(3, 2);
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        UniquePaths s = new UniquePaths();
        int ans = s.uniquePaths(7, 3);
        assertEquals(28, ans);
    }
}
