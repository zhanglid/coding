package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximumFrequencyStackTest {

    @Test
    public void testCase() {
        MaximumFrequencyStack.FreqStack s = new MaximumFrequencyStack.FreqStack();
        s.push(5);
        s.push(7);
        s.push(5);
        s.push(7);
        s.push(4);
        s.push(5);
        assertEquals(5, s.pop());
        assertEquals(7, s.pop());
        assertEquals(5, s.pop());
        assertEquals(4, s.pop());
    }
}
