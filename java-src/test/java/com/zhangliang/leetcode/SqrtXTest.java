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

    @Test
    public void errCase() {
        SqrtX s = new SqrtX();
        int ans = s.mySqrt(2147395599);
        assertEquals(46339, ans);
    }

    @Test
    public void errCase2() {
        SqrtX s = new SqrtX();
        int ans = s.mySqrt(2147395600);
        assertEquals(46340, ans);
    }
}
