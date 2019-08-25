package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class InsertDeleteGetRandomO1Test {

    @Test
    public void testCase() {
        InsertDeleteGetRandomO1.RandomizedSet s = new InsertDeleteGetRandomO1.RandomizedSet();
        assertEquals(true, s.insert(1));
        assertEquals(false, s.remove(2));
        assertEquals(true, s.insert(2));
        int val = s.getRandom();
        assertTrue(1 == val || 2 == val);
        assertEquals(true, s.remove(1));
        assertEquals(false, s.insert(2));
        assertEquals(2, s.getRandom());
    }
}
