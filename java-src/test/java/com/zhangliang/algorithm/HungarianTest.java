package com.zhangliang.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class HungarianTest {

    @Test
    public void testCase() {
        Hungarian s = new Hungarian();
        int[][] graph = new int[][] { { 4, 6 }, { 4 }, { 4, 5 }, { 6, 7 }, { 0, 1, 2 }, { 2 }, { 0, 3 }, { 3 } };
        int[] ans = s.solve(8, graph);
        assertArrayEquals(new int[] { 6, 4, 5, 7, 1, 2, 0, 3 }, ans);
    }

    @Test
    public void testCase2() {
        Hungarian s = new Hungarian();
        int[][] graph = new int[][] { { 4, 6 }, { 4 }, { 4, 5 }, { 6, 7 }, { 0, 1, 2 }, { 2 }, { 0, 3 }, { 3 }, {} };
        int[] ans = s.solve(9, graph);
        assertArrayEquals(new int[] { 6, 4, 5, 7, 1, 2, 0, 3, -1 }, ans);
    }
}
