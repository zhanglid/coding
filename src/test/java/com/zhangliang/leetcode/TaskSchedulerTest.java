package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TaskSchedulerTest {

    @Test
    public void testCase() {
        TaskScheduler s = new TaskScheduler();
        int ans = s.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2);
        assertEquals(8, ans);
    }

    @Test
    public void testCase2() {
        TaskScheduler s = new TaskScheduler();
        // ABCADEAFGA__A__A
        int ans = s.leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2);
        assertEquals(16, ans);
    }
}
