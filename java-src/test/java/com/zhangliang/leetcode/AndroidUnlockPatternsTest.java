package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class AndroidUnlockPatternsTest {

    @Test
    public void testCase() {
        AndroidUnlockPatterns s = new AndroidUnlockPatterns();
        int ans = s.numberOfPatterns(1, 1);
        assertEquals(9, ans);
    }

    @Test
    public void errCase() {
        AndroidUnlockPatterns s = new AndroidUnlockPatterns();
        int ans = s.numberOfPatterns(2, 2);
        assertEquals(56, ans);
    }

    @Test
    public void errCase2() {
        AndroidUnlockPatterns s = new AndroidUnlockPatterns();
        int ans = s.numberOfPatterns(1, 2);
        assertEquals(65, ans);
    }
}
