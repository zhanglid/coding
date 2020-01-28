package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidPerfectSquareTest {

    @Test
    public void testCase() {
        ValidPerfectSquare s = new ValidPerfectSquare();
        boolean ans = s.isPerfectSquare(16);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ValidPerfectSquare s = new ValidPerfectSquare();
        boolean ans = s.isPerfectSquare(14);
        assertEquals(false, ans);
    }
}
