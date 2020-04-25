package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CountPrimesTest {

    @Test
    public void testCase() {
        CountPrimes s = new CountPrimes();
        int ans = s.countPrimes(10);
        assertEquals(4, ans);
    }

    @Test
    public void errCase() {
        CountPrimes s = new CountPrimes();
        int ans = s.countPrimes(2);
        assertEquals(0, ans);
    }
}
