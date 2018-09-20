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
Note:

A half open interval [left, right) denotes all real numbers left <= x < right.
0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
The total number of calls to addRange in a single test case is at most 1000.
The total number of calls to queryRange in a single test case is at most 5000.
The total number of calls to removeRange in a single test case is at most 1000.
*/

import java.util.LinkedList;
import java.util.List;

public class RangeModule {
    List<int[]> intervals = new LinkedList<>();

    private int binaryFindStart(int value) {
        int l = 0;
        int r = intervals.size();
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (intervals.get(mid)[0] <= value) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public RangeModule() {
        intervals = new LinkedList<>();
    }

    public void addRange(int left, int right) {
        if (intervals.isEmpty()) {
            intervals.add(new int[] { left, right });
            return;
        }
        int l = binaryFindStart(left);
        int r = binaryFindStart(right);

        if (intervals.get(l)[0] > right) {
            intervals.add(0, new int[] { left, right });
            return;
        }
        if (intervals.get(l)[1] >= left) {
            left = Math.min(intervals.get(l)[0], left);
        } else {
            l++;
        }

        if (intervals.get(r)[0] <= right) {
            right = Math.max(intervals.get(r)[1], right);
        } else {
            r--;
        }

        intervals.add(l, new int[] { left, right });

        for (int i = l; i <= r; i++) {
            intervals.remove(l + 1);
        }
    }

    public boolean queryRange(int left, int right) {
        if (intervals.isEmpty()) {
            return false;
        }
        int index = binaryFindStart(left);
        return intervals.get(index)[0] <= left && intervals.get(index)[1] >= right;
    }

    public void removeRange(int left, int right) {
        if (intervals.isEmpty()) {
            return;
        }

        int l = binaryFindStart(left);
        int r = binaryFindStart(right);

        if (intervals.get(l)[0] > right) {
            return;
        }

        if (l == r) {
            intervals.add(l, new int[] { intervals.get(l)[0], intervals.get(l)[1] });
            r++;
        }

        if (intervals.get(l)[1] >= left && intervals.get(l)[0] < left) {
            intervals.get(l)[1] = left;
        }
        if (intervals.get(l)[0] < left) {
            l++;
        }

        if (intervals.get(r)[0] <= right) {
            if (intervals.get(r)[1] > right) {
                intervals.get(r)[0] = right;
            }
        }
        if (intervals.get(r)[1] > right) {
            r--;
        }
        for (int i = l; i <= r; i++) {
            intervals.remove(l);
        }
    }
}
/**
 * Your RangeModule object will be instantiated and called as such: RangeModule
 * obj = new RangeModule(); obj.addRange(left,right); boolean param_2 =
 * obj.queryRange(left,right); obj.removeRange(left,right);
 */