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
    class Interval implements Comparable<Interval> {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int compareTo(Interval that) {
            if (this.right != that.right) {
                return this.right - that.right;
            }
            return this.left - that.left;
        }
    }

    TreeSet<Interval> ts = new TreeSet<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        right--;
        SortedSet<Interval> tailSet = ts.tailSet(new Interval(0, left - 1));
        List<Interval> toRemove = new ArrayList<>();
        for (Interval interval : tailSet) {
            if (interval.left > right + 1) {
                break;
            }
            left = Math.min(left, interval.left);
            right = Math.max(right, interval.right);
            toRemove.add(interval);
        }
        for (Interval it : toRemove) {
            ts.remove(it);
        }
        ts.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        SortedSet<Interval> tailSet = ts.tailSet(new Interval(0, left));
        if (tailSet.isEmpty()) {
            return false;
        }
        Interval target = tailSet.first();
        return target.left <= left && target.right >= right - 1;
    }

    public void removeRange(int left, int right) {
        SortedSet<Interval> tailSet = ts.tailSet(new Interval(0, left));
        List<Interval> toAdd = new ArrayList<>();
        List<Interval> toRemove = new ArrayList<>();
        for (Interval interval : tailSet) {
            if (interval.left >= right) {
                break;
            }
            if (interval.left < left) {
                toAdd.add(new Interval(interval.left, left - 1));
            }
            if (interval.right >= right) {
                toAdd.add(new Interval(right, interval.right));
            }
            toRemove.add(interval);
        }
        for (Interval it : toRemove) {
            ts.remove(it);
        }
        for (Interval it : toAdd) {
            ts.add(it);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such: RangeModule
 * obj = new RangeModule(); obj.addRange(left,right); boolean param_2 =
 * obj.queryRange(left,right); obj.removeRange(left,right);
 */