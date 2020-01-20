package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CourseScheduleTest {

    @Test
    public void testCase() {
        CourseSchedule s = new CourseSchedule();
        boolean ans = s.canFinish(2, new int[][] { { 1, 0 } });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        CourseSchedule s = new CourseSchedule();
        boolean ans = s.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } });
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        CourseSchedule s = new CourseSchedule();
        boolean ans = s.canFinish(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
        assertEquals(true, ans);
    }

}
