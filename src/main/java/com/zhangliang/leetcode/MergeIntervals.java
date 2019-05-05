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
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) {
                    return a.start - b.start;
                } else {
                    return a.end - b.end;
                }
            }
        });

        List<Interval> result = new ArrayList<>();
        Interval last = intervals.get(0);
        result.add(last);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (last.end < cur.start) {
                result.add(cur);
                last = cur;
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }
        return result;
    }
}
