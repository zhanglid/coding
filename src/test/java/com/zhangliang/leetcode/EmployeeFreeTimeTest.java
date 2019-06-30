package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class EmployeeFreeTimeTest {

    private List<List<Interval>> buildIntervals(int[][][] intervalGroups) {
        List<List<Interval>> intervalGroupList = new ArrayList<>();
        for (int[][] intervals : intervalGroups) {
            List<Interval> group = new ArrayList<>();
            for (int[] interval : intervals) {
                group.add(new Interval(interval));
            }
            intervalGroupList.add(group);
        }
        return intervalGroupList;
    }

    private void assertCorrect(int[][] expected, List<Interval> others) {
        assertTrue("Expect to have same length", expected.length == others.size());
        Interval[] expectedIntervals = new Interval[expected.length];
        for (int i = 0; i < expected.length; i++) {
            expectedIntervals[i] = new Interval(expected[i][0], expected[i][1]);
        }
        assertArrayEquals(expectedIntervals, others.toArray(new Interval[0]));
    }

    @Test
    public void testCase() {
        EmployeeFreeTime s = new EmployeeFreeTime();
        List<Interval> ans = s.employeeFreeTime(
                buildIntervals(new int[][][] { { { 1, 2 }, { 5, 6 } }, { { 1, 3 } }, { { 4, 10 } } }));

        assertCorrect(new int[][] { { 3, 4 } }, ans);
    }

    @Test
    public void testCase2() {
        EmployeeFreeTime s = new EmployeeFreeTime();
        List<Interval> ans = s.employeeFreeTime(
                buildIntervals(new int[][][] { { { 1, 3 }, { 6, 7 } }, { { 2, 4 } }, { { 2, 5 }, { 9, 12 } } }));

        assertCorrect(new int[][] { { 5, 6 }, { 7, 9 } }, ans);
    }

    @Test
    public void testCase3() {
        EmployeeFreeTime s = new EmployeeFreeTime();
        List<Interval> ans = s.employeeFreeTime(
                buildIntervals(new int[][][] { { { 1, 2 }, { 5, 6 } }, { { 1, 3 } }, { { 4, 10 } } }));

        assertCorrect(new int[][] { { 3, 4 } }, ans);
    }
}
