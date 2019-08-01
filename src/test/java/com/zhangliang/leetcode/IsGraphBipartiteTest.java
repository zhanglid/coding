package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IsGraphBipartiteTest {

    @Test
    public void testCase() {
        IsGraphBipartite s = new IsGraphBipartite();
        boolean ans = s.isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        IsGraphBipartite s = new IsGraphBipartite();
        boolean ans = s.isBipartite(new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } });
        assertEquals(false, ans);
    }
}
