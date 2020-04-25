package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DesignHashMapTest {

    @Test
    public void testCase() {
        DesignHashMap.MyHashMap hashMap = new DesignHashMap.MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        assertEquals(1, hashMap.get(1)); // returns 1
        assertEquals(-1, hashMap.get(3)); // returns -1 (not found)
        hashMap.put(2, 1); // update the existing value
        assertEquals(1, hashMap.get(2)); // returns 1
        hashMap.remove(2); // remove the mapping for 2
        assertEquals(-1, hashMap.get(2)); // returns -1 (not found)
    }
}
