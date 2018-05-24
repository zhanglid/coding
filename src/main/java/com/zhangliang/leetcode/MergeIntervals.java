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
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals == null) {
            return ans;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                int diff = a.start - b.start;
                if (diff == 0) {
                    return a.end - b.end;
                }
                return diff;
            }
        });

        for (Interval interval : intervals) {
            if (ans.isEmpty() || ans.get(ans.size() - 1).end < interval.start) {
                ans.add(interval);
                continue;
            }

            ans.get(ans.size() - 1).end = interval.end;
        }

        return ans;
    }
}
