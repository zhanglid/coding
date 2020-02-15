package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OpenTheLockTest {

    @Test
    public void testCase() {
        OpenTheLock s = new OpenTheLock();
        int ans = s.openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202");
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        OpenTheLock s = new OpenTheLock();
        int ans = s.openLock(new String[] { "8888" }, "0009");
        assertEquals(1, ans);
    }

    @Test
    public void testCase3() {
        OpenTheLock s = new OpenTheLock();
        int ans = s.openLock(new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, "8888");
        assertEquals(-1, ans);
    }

    @Test
    public void testCase4() {
        OpenTheLock s = new OpenTheLock();
        int ans = s.openLock(new String[] { "0000" }, "8888");
        assertEquals(-1, ans);
    }
}
