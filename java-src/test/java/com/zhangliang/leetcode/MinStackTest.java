package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinStackTest {

    @Test
    public void testCase() {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        assertEquals(-3, s.getMin());
        s.pop();
        assertEquals(0, s.top());
        assertEquals(-2, s.getMin());
    }
}
