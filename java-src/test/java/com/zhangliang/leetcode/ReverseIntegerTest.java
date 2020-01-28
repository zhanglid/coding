package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReverseIntegerTest {

    @Test
    public void testCase() {
        ReverseInteger s = new ReverseInteger();
        int ans = s.reverse(123);
        assertEquals(321, ans);
    }

    @Test
    public void testCase2() {
        ReverseInteger s = new ReverseInteger();
        int ans = s.reverse(-123);
        assertEquals(-321, ans);
    }

    @Test
    public void testCase3() {
        ReverseInteger s = new ReverseInteger();
        int ans = s.reverse(120);
        assertEquals(21, ans);
    }

}
