package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
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

}
