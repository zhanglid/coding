package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class CourseScheduleIITest {

    @Test
    public void testCase() {
        CourseScheduleII s = new CourseScheduleII();
        int[] ans = s.findOrder(2, new int[][] { { 1, 0 } });
        assertArrayEquals(new int[] { 0, 1 }, ans);
    }

    @Test
    public void testCase2() {
        CourseScheduleII s = new CourseScheduleII();
        int[] ans = s.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
        assertTrue(Arrays.toString(ans).equals("[0, 1, 2, 3]") || Arrays.toString(ans).equals("[0, 2, 1, 3]"));
    }

    // prerequisites没有numCourses
    @Test
    public void errCase() {
        CourseScheduleII s = new CourseScheduleII();
        int[] ans = s.findOrder(1, new int[][] {});
        assertArrayEquals(new int[] { 0 }, ans);
    }

    //
    @Test
    public void errCase2() {
        CourseScheduleII s = new CourseScheduleII();
        int[] ans = s.findOrder(2, new int[][] { { 0, 1 }, { 1, 0 } });
        assertArrayEquals(new int[] {}, ans);
    }
}
