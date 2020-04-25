package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ParallelCoursesTest {

    @Test
    public void testCase() {
        ParallelCourses s = new ParallelCourses();
        int ans = s.minimumSemesters(3, new int[][] { { 1, 3 }, { 2, 3 } });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        ParallelCourses s = new ParallelCourses();
        int ans = s.minimumSemesters(3, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } });
        assertEquals(-1, ans);
    }
}
