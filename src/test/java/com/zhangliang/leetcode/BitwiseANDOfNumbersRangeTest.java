package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class BitwiseANDOfNumbersRangeTest {

    @Test
    public void testCase() {
        BitwiseANDOfNumbersRange s = new BitwiseANDOfNumbersRange();
        int ans = s.rangeBitwiseAnd(5, 7);
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        BitwiseANDOfNumbersRange s = new BitwiseANDOfNumbersRange();
        int ans = s.rangeBitwiseAnd(0, 1);
        assertEquals(0, ans);
    }
}
