package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ShortestDistanceFromAllBuildingsTest {

    @Test
    public void testCase() {
        ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
        int ans = s.shortestDistance(new int[][] { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } });
        assertEquals(7, ans);
    }

    @Test
    public void errCase() {
        ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
        int ans = s.shortestDistance(new int[][] { { 1, 2, 0 } });
        assertEquals(-1, ans);
    }

    @Test
    public void errCase2() {
        ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
        int ans = s.shortestDistance(new int[][] { { 0, 2, 1 }, { 1, 0, 2 }, { 0, 1, 0 } });
        assertEquals(-1, ans);
    }

    @Test
    public void errCase3() {
        ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
        int ans = s.shortestDistance(new int[][] { { 1, 1 }, { 0, 1 } });
        assertEquals(-1, ans);
    }
}
