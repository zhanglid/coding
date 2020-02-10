package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConfusingNumberIITest {

    @Test
    public void testCase() {
        ConfusingNumberII s = new ConfusingNumberII();
        int ans = s.confusingNumberII(20);
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        ConfusingNumberII s = new ConfusingNumberII();
        int ans = s.confusingNumberII(100);
        assertEquals(19, ans);
    }

    @Test
    public void errCase() {
        ConfusingNumberII s = new ConfusingNumberII();
        int ans = s.confusingNumberII(1000000000);
        assertEquals(19, ans);
    }
}
