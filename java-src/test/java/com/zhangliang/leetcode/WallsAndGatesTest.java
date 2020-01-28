package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class WallsAndGatesTest {
    static private final int INF = Integer.MAX_VALUE;

    @Test
    public void testCase() {
        WallsAndGates s = new WallsAndGates();
        int[][] rooms = new int[][] { { INF, -1, 0, INF }, { INF, INF, INF, -1 }, { INF, -1, INF, -1 },
                { 0, -1, INF, INF } };
        s.wallsAndGates(rooms);
        assertArrayEquals(new int[][] { { 3, -1, 0, 1 }, { 2, 2, 1, -1 }, { 1, -1, 2, -1 }, { 0, -1, 3, 4 } }, rooms);
    }
}
