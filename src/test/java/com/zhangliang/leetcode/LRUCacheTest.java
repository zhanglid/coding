package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LRUCacheTest {

    private Integer[] runCase(String[] cmds, int[][] values) {
        LRUCache s = null;
        Integer[] results = new Integer[cmds.length];
        for (int i = 0; i < cmds.length; i++) {
            String cmd = cmds[i];
            int[] value = values[i];
            Integer output = null;
            switch (cmd) {
            case "LRUCache":
                s = new LRUCache(value[0]);
                break;
            case "put":
                s.put(value[0], value[1]);
                break;
            case "get":
                output = s.get(value[0]);
                break;
            default:
            }
            results[i] = output;
        }

        return results;
    }

    @Test
    public void testCase() {
        LRUCache s = new LRUCache(2);
        s.put(1, 1);
        s.put(1, 1);
        s.put(2, 2);
        int a1 = s.get(1); // returns 1
        s.put(3, 3); // evicts key 2
        int a2 = s.get(2); // returns -1 (not found)
        s.put(4, 4); // evicts key 1
        int a3 = s.get(1); // returns -1 (not found)
        int a4 = s.get(3); // returns 3
        int a5 = s.get(4); // returns 4
        assertEquals(1, a1);
        assertEquals(-1, a2);
        assertEquals(-1, a3);
        assertEquals(3, a4);
        assertEquals(4, a5);
    }

    @Test
    public void errCase() {
        LRUCache s = new LRUCache(1);
        s.put(2, 1);
        int a1 = s.get(2);
        s.put(3, 2);
        int a2 = s.get(2);
        int a3 = s.get(3);
        assertEquals(1, a1);
        assertEquals(-1, a2);
        assertEquals(2, a3);
    }

    @Test
    public void errCase2() {
        LRUCache s = new LRUCache(2);
        int a1 = s.get(2);
        s.put(2, 6);
        int a2 = s.get(1);
        s.put(1, 5);
        s.put(1, 2);
        int a3 = s.get(1);
        int a4 = s.get(2);
        assertEquals(-1, a1);
        assertEquals(-1, a2);
        assertEquals(2, a3);
        assertEquals(6, a4);
    }

    @Test
    public void errCase3() {
        Integer[] result = runCase(new String[] { "LRUCache", "put", "put", "put", "put", "get", "get" },
                new int[][] { { 2 }, { 2, 1 }, { 1, 1 }, { 2, 3 }, { 4, 1 }, { 1 }, { 2 } });

        assertArrayEquals(new Integer[] { null, null, null, null, null, -1, 3 }, result);
    }

    @Test
    public void errCase4() {
        Integer[] result = runCase(new String[] { "LRUCache", "put", "put", "put", "put", "get", "put", "get" },
                new int[][] { { 2 }, { 1, 1 }, { 2, 2 }, { 1, 3 }, { 1, 6 }, { 2 }, { 3, 3 }, { 2 } });

        assertArrayEquals(new Integer[] { null, null, null, null, null, 2, null, 2 }, result);
    }
}
