package com.zhangliang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    Interval(int[] nums) {
        start = nums[0];
        end = nums[1];
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Interval)) {
            return false;
        }
        Interval other = (Interval) obj;
        return other.start == start && other.end == end;
    }

    public static List<Interval> getIntervalsList(int[][] intervals) {
        List<Interval> ans = new ArrayList<>();

        for (int[] iv : intervals) {
            ans.add(new Interval(iv));
        }

        return ans;
    }
}
