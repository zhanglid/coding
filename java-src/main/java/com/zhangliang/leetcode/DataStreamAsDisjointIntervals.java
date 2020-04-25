package com.zhangliang.leetcode;
/*
Given a data stream input of non-negative integers 
a1, a2, ..., an, ..., summarize the numbers seen so far as 
a list of disjoint intervals.

For example, suppose the integers from the data stream are 
1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
 

Follow up:

What if there are lots of merges and the number of 
disjoint intervals are small compared to the data stream's size?
*/

import java.util.*;

public class DataStreamAsDisjointIntervals {
    static class SummaryRanges {
        List<int[]> intervals;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            this.intervals = new ArrayList<>();
        }

        public void addNum(int val) {
            if (this.intervals.isEmpty() || val > this.intervals.get(this.intervals.size() - 1)[1] + 1) {
                this.intervals.add(new int[] { val, val });
                return;
            }
            if (val == this.intervals.get(this.intervals.size() - 1)[1] + 1) {
                this.intervals.get(this.intervals.size() - 1)[1]++;
                return;
            }
            int index = 0;
            while (index < this.intervals.size() && this.intervals.get(index)[1] < val) {
                index++;
            }
            // touch previous
            if (index - 1 >= 0 && this.intervals.get(index - 1)[1] + 1 == val) {
                // merge two
                if (this.intervals.get(index)[0] == val + 1) {
                    this.intervals.get(index - 1)[1] = this.intervals.get(index)[1];
                    this.intervals.remove(index);
                } else {
                    // extends previous
                    this.intervals.get(index - 1)[1] = val;
                }
                return;
            }

            // in the middle
            if (this.intervals.get(index)[0] > val + 1) {
                this.intervals.add(index, new int[] { val, val });
                return;
            }
            this.intervals.get(index)[0] = Math.min(val, this.intervals.get(index)[0]);
        }

        public int[][] getIntervals() {
            return this.intervals.toArray(new int[0][2]);
        }
    }

    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); int[][] param_2 =
     * obj.getIntervals();
     */

}
