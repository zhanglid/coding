package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TwoSumIIITest {

    @Test
    public void testCase() {
        TwoSumIII s = new TwoSumIII();
        s.add(1);
        s.add(3);
        s.add(5);
        assertEquals(true, s.find(4));
        assertEquals(false, s.find(7));
    }

    @Test
    public void testCase2() {
        TwoSumIII s = new TwoSumIII();
        s.add(3);
        s.add(1);
        s.add(2);
        assertEquals(true, s.find(3));
        assertEquals(false, s.find(6));
    }
}
