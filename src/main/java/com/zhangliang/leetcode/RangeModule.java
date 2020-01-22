package com.zhangliang.leetcode;
/*
A Range Module is a module that tracks ranges of numbers. Your task is to design 
and implement the following interfaces in an efficient manner.

addRange(int left, int right) Adds the half-open interval [left, right), tracking 
every real number in that interval. Adding an interval that partially overlaps 
with currently tracked numbers should add any numbers in the interval [left, right) 
that are not already tracked.
queryRange(int left, int right) Returns true if and only if every real number in 
the interval [left, right) is currently being tracked.
removeRange(int left, int right) Stops tracking every real number currently being 
tracked in the interval [left, right).

Example 1:
addRange(10, 20): null
removeRange(14, 16): null
queryRange(10, 14): true (Every number in [10, 14) is being tracked)
queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being 
tracked)
queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite 
the remove operation)

Note

A half open interval [left, right) denotes all real numbers left <= x < right.
0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
The total number of calls to addRange in a single test case is at most 1000.
The total number of calls to queryRange in a single test case is at most 5000.
The total number of calls to removeRange in a single test case is at most 1000.
*/

import java.util.*;

public class RangeModule {
    List<int[]> intervals = new ArrayList<>();

    public RangeModule() {
    }

    public void addRange(int left, int right) {
        right--;
        if (left > right) {
            return;
        }
        int[] interval = new int[] { left, right };
        if (intervals.isEmpty() || left > intervals.get(intervals.size() - 1)[1] + 1) {
            intervals.add(interval);
            return;
        }
        if (right < intervals.get(0)[0] - 1) {
            intervals.add(0, interval);
            return;
        }
        int i = 0;
        for (; i < intervals.size(); i++) {
            if (intervals.get(i)[1] >= left - 1) {
                // Attention: It is possible that two intervals do not have intersection.
                intervals.add(i, new int[] { left, right });
                i++;
                break;
            }
        }
        while (i < intervals.size() && intervals.get(i)[0] <= intervals.get(i - 1)[1] + 1) {
            intervals.get(i - 1)[1] = Math.max(intervals.get(i)[1], intervals.get(i - 1)[1]);
            intervals.get(i - 1)[0] = Math.min(intervals.get(i)[0], intervals.get(i - 1)[0]);
            intervals.remove(i);
        }
    }

    public boolean queryRange(int left, int right) {
        right--;
        if (intervals.isEmpty() || left > right) {
            return false;
        }
        int l = 0;
        int r = intervals.size() - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int[] interval = intervals.get(mid);
            if (interval[1] >= left) {
                r = mid;
            } else {
                l = mid;
            }
        }
        int index = intervals.get(l)[1] >= left ? l : r;
        int[] target = intervals.get(index);
        return left >= target[0] && right <= target[1];
    }

    public void removeRange(int left, int right) {
        right--;
        // Not a valid interval.
        if (left > right) {
            return;
        }
        // The interval is out of range.
        if (intervals.isEmpty() || right < intervals.get(0)[0] || left > intervals.get(intervals.size() - 1)[1]) {
            return;
        }
        int i = 0;
        for (; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (interval[1] >= left) {
                // Remove whole
                if (interval[0] >= left && interval[1] <= right) {
                    intervals.remove(i);
                    i--;
                    continue;
                }

                // Keep upper part
                // Attention: interval can have no intersection.
                if (interval[1] > right && left <= interval[0] && right >= interval[0]) {
                    interval[0] = right + 1;
                    break;
                }

                // Keep lower part
                if (interval[1] <= right && left > interval[0]) {
                    interval[1] = left - 1;
                    continue;
                }

                // Split into two parts
                if (left > interval[0] && right < interval[1]) {
                    intervals.add(i + 1, new int[] { right + 1, interval[1] });
                    interval[1] = left - 1;
                    break;
                }
            }
        }
    }
}
/**
 * Your RangeModule object will be instantiated and called as such: RangeModule
 * obj = new RangeModule(); obj.addRange(left,right); boolean param_2 =
 * obj.queryRange(left,right); obj.removeRange(left,right);
 */