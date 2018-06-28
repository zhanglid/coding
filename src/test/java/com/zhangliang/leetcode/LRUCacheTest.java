package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LRUCacheTest {

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
}
