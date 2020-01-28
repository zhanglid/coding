package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DesignCircularQueueTest {

    @Test
    public void testCase() {
        DesignCircularQueue.MyCircularQueue s = new DesignCircularQueue.MyCircularQueue(3);
        assertEquals(true, s.enQueue(1));
        assertEquals(true, s.enQueue(2));
        assertEquals(true, s.enQueue(3));
        assertEquals(false, s.enQueue(4));
        assertEquals(3, s.Rear());
        assertEquals(true, s.isFull());
        assertEquals(true, s.deQueue());
        assertEquals(true, s.enQueue(4));
        assertEquals(4, s.Rear());
    }

    @Test
    public void testCase2() {
        DesignCircularQueue.MyCircularQueue s = new DesignCircularQueue.MyCircularQueue(6);
        assertEquals(true, s.enQueue(6));
        assertEquals(6, s.Rear());
        assertEquals(6, s.Rear());
        assertEquals(true, s.deQueue());
        assertEquals(true, s.enQueue(5));
        assertEquals(5, s.Rear());
        assertEquals(true, s.deQueue());
        assertEquals(-1, s.Front());
        assertEquals(false, s.deQueue());
        assertEquals(false, s.deQueue());
        assertEquals(false, s.deQueue());
    }
}
