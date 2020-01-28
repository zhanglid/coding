package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GraphValidTreeTest {

    @Test
    public void testCase() {
        GraphValidTree s = new GraphValidTree();
        boolean ans = s.validTree(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        GraphValidTree s = new GraphValidTree();
        boolean ans = s.validTree(5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } });
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        GraphValidTree s = new GraphValidTree();
        boolean ans = s.validTree(4, new int[][] { { 0, 1 }, { 2, 3 } });
        assertEquals(false, ans);
    }
}
