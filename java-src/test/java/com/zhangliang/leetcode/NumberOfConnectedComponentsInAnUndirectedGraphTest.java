package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberOfConnectedComponentsInAnUndirectedGraphTest {

    @Test
    public void testCase() {
        NumberOfConnectedComponentsInAnUndirectedGraph s = new NumberOfConnectedComponentsInAnUndirectedGraph();
        int ans = s.countComponents(5, new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        NumberOfConnectedComponentsInAnUndirectedGraph s = new NumberOfConnectedComponentsInAnUndirectedGraph();
        int ans = s.countComponents(5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } });
        assertEquals(1, ans);
    }
}
