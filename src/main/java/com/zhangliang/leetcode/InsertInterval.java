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
    private boolean hasIntersection(int[] a, int[] b) {
        return a[1] >= b[0] && a[0] <= b[1];
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean hasInserted = false;
        for (int[] interval : intervals) {
            if (hasIntersection(interval, newInterval)) {
                interval[0] = Math.min(interval[0], newInterval[0]);
                interval[1] = Math.max(interval[1], newInterval[1]);
                hasInserted = true;
            }
            if (!result.isEmpty() && hasIntersection(interval, result.get(result.size() - 1))) {
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            } else {
                if (!hasInserted && interval[0] > newInterval[1]) {
                    result.add(newInterval);
                    hasInserted = true;
                }
                result.add(interval);
            }
        }
        if (!hasInserted) {
            result.add(newInterval);
        }

        return result.toArray(new int[0][2]);
    }
}
