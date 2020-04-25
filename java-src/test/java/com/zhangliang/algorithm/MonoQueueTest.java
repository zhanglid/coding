package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MonoQueueTest {

    @Test
    public void testCase() {
        MonoQueue s = new MonoQueue(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2 });
        int ans = s.getMax();
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        MonoQueue s = new MonoQueue(new int[] { 1, 5, 3, 4, 5 }, new int[] { 1, 2 });
        int ans = s.getMax();
        assertEquals(5, ans);
    }

    @Test
    public void testCase3() {
        MonoQueue s = new MonoQueue(new int[] { 3, 1, 2, 3, 6, 4 }, new int[] { 1, 2 });
        assertEquals(2, s.getMax());
        s.expandRight(); // [1, 3]
        assertEquals(3, s.getMax());
        s.expandRight(); // [1, 4]
        s.expandRight(); // [1, 5]
        assertEquals(6, s.getMax());
        s.shrinkLeft(); // [2, 5]
        s.shrinkLeft(); // [3, 5]
        s.shrinkLeft(); // [4, 5]
        s.shrinkLeft(); // [5, 5]
        assertEquals(4, s.getMax());
    }
}
