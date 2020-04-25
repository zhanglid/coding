package com.zhangliang.leetcode;
/*
Given a set of non-overlapping intervals, insert a new interval into the 
intervals (merge if necessary).

You may assume that the intervals were initially sorted according to 
their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], 
newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

*/

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        // empty
        if (intervals.length < 1) {
            mergedIntervals.add(newInterval);
        }
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0]) {
                if (intervals[i][0] > newInterval[1]) {
                    mergedIntervals.add(newInterval);
                    mergedIntervals.add(intervals[i]);
                } else {
                    mergedIntervals.add(new int[] { Math.min(intervals[i][0], newInterval[0]),
                            Math.max(newInterval[1], newInterval[1]) });
                }
                break;
            }
            mergedIntervals.add(intervals[i]);
        }

        for (; i < intervals.length; i++) {
            int[] last = mergedIntervals.get(mergedIntervals.size() - 1);
            if (last[1] >= intervals[i][0]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                mergedIntervals.add(intervals[i]);
            }
        }
        if (newInterval[0] > mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
            mergedIntervals.add(newInterval);
        }
        return mergedIntervals.toArray(new int[0][2]);
    }
}
