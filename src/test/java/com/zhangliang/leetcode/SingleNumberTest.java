package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SingleNumberTest {

    @Test
    public void testCase() {
        SingleNumber s = new SingleNumber();
        int ans = s.singleNumber(new int[] { 2, 2, 1 });
        assertEquals(ans, 1);
    }

    @Test
    public void errCase() {
        SingleNumber s = new SingleNumber();
        int ans = s.singleNumber(new int[] { 4, 1, 2, 1, 2 });
        assertEquals(ans, 4);
    }
}
