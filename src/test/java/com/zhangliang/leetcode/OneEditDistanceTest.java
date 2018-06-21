package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class OneEditDistanceTest {

    @Test
    public void testCase() {
        OneEditDistance s = new OneEditDistance();
        boolean ans = s.isOneEditDistance("ab", "acb");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        OneEditDistance s = new OneEditDistance();
        boolean ans = s.isOneEditDistance("cab", "ad");
        assertEquals(false, ans);
    }

    @Test
    public void testCase3() {
        OneEditDistance s = new OneEditDistance();
        boolean ans = s.isOneEditDistance("1203", "1213");
        assertEquals(true, ans);
    }
}
