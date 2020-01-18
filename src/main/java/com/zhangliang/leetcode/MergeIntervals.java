package com.zhangliang.leetcode;
/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });
        List<int[]> mergedIntervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (mergedIntervalList.isEmpty()) {
                mergedIntervalList.add(interval);
                continue;
            }
            int[] last = mergedIntervalList.get(mergedIntervalList.size() - 1);
            if (interval[0] <= last[1]) {
                last[1] = Math.max(last[1], interval[1]);
            } else {
                mergedIntervalList.add(interval);
            }
        }
        return mergedIntervalList.toArray(new int[0][2]);
    }
}
