package com.zhangliang.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.Test;

public class TopoSortTest {
    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    private boolean checkTopo(int[] order, int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        for (int i = 1; i < order.length; i++) {
            int a = order[i - 1];
            int b = order[i];
            if (graph.get(b).contains(a)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase() {
        TopoSort s = new TopoSort();
        int n = 6;
        int[][] edges = new int[][] { { 4, 0 }, { 5, 0 }, { 4, 1 }, { 3, 1 }, { 2, 3 }, { 5, 2 } };
        int[] ans = s.indegreeSort(n, edges);
        assertTrue(checkTopo(ans, n, edges));
    }

    @Test
    public void testCase2() {
        TopoSort s = new TopoSort();
        int n = 6;
        int[][] edges = new int[][] { { 4, 0 }, { 5, 0 }, { 4, 1 }, { 3, 1 }, { 2, 3 }, { 5, 2 } };
        int[] ans = s.dfsSort(n, edges);
        assertTrue(checkTopo(ans, n, edges));
    }

    @Test
    public void testCase3() {
        TopoSort s = new TopoSort();
        int n = 6;
        int[][] edges = new int[][] { { 4, 0 }, { 5, 0 }, { 4, 1 }, { 3, 1 }, { 2, 3 }, { 5, 2 } };
        int[] ans = s.dfsSortWithCircle(n, edges);
        assertTrue(checkTopo(ans, n, edges));
    }

    @Test
    public void testCase4() {
        TopoSort s = new TopoSort();
        int n = 6;
        int[][] edges = new int[][] { { 4, 0 }, { 5, 0 }, { 4, 1 }, { 3, 1 }, { 2, 3 }, { 5, 2 }, { 1, 2 } };
        int[] ans = s.dfsSortWithCircle(n, edges);
        assertEquals(null, ans);
    }
}
