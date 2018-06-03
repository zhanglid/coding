package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SqrtXTest {

    @Test
    public void testCase() {
        SqrtX s = new SqrtX();
        int ans = s.mySqrt(4);
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        SqrtX s = new SqrtX();
        int ans = s.mySqrt(8);
        assertEquals(2, ans);
    }
}
