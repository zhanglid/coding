package com.zhangliang.leetcode;
/*
We are given a list schedule of employees, which represents the working time for each employee.
Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
Return the list of finite intervals representing common, positive-length free time for all employees, also 
in sorted order.

Example 1:

Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
 

Example 2:

Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
 

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or 
arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)

Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

Note:

schedule and schedule[i] are lists with lengths in range [1, 50].
0 <= schedule[i].start < schedule[i].end <= 10^8.
NOTE: input types have been changed on June 17, 2019. Please reset to default code definition to get new method 
signature.
*/

import java.util.*;

public class EmployeeFreeTime {
    class IntervalTarget {
        int index = 0;
        Interval interval;
        List<Interval> group;

        public IntervalTarget(List<Interval> group) {
            this.group = group;
            if (!group.isEmpty()) {
                interval = group.get(0);
            }
        }

        public void next() {
            index++;
            interval = group.get(index);
        }

        public boolean hasNext() {
            return index < group.size() - 1;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();
        PriorityQueue<IntervalTarget> pq = new PriorityQueue<>(new Comparator<IntervalTarget>() {
            public int compare(IntervalTarget a, IntervalTarget b) {
                return (a.interval != null ? a.interval.start : Integer.MIN_VALUE)
                        - (b.interval != null ? b.interval.start : Integer.MIN_VALUE);
            }
        });

        for (List<Interval> group : schedule) {
            pq.add(new IntervalTarget(group));
        }
        int lastTime = -1;
        while (!pq.isEmpty()) {
            IntervalTarget it = pq.poll();
            if (it.interval != null && it.interval.start > lastTime && lastTime != -1) {
                ans.add(new Interval(lastTime, it.interval.start));
            }
            lastTime = Math.max(lastTime, it.interval.end);
            if (it.hasNext()) {
                it.next();
                pq.add(it);
            }
        }

        return ans;
    }
}
