package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CompareVersionNumbersTest {

    @Test
    public void testCase() {
        CompareVersionNumbers s = new CompareVersionNumbers();
        int ans = s.compareVersion("0.1", "1.1");
        assertEquals(-1, ans);
    }

    @Test
    public void testCase2() {
        CompareVersionNumbers s = new CompareVersionNumbers();
        int ans = s.compareVersion("1.0.1", "1");
        assertEquals(1, ans);
    }

    @Test
    public void testCase3() {
        CompareVersionNumbers s = new CompareVersionNumbers();
        int ans = s.compareVersion("7.5.2.4", "7.5.3");
        assertEquals(-1, ans);
    }
}
