package com.zhangliang.leetcode;
/*
Given an array w of positive integers, where w[i] describes the weight of 
index i, write a function pickIndex which randomly picks an index in 
proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.

Example 1:
Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:
Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. 
Solution's constructor has one argument, the array w. pickIndex has no 
arguments. Arguments are always wrapped with a list, even if there 
aren't any.
*/

import java.util.*;

public class RandomPickWithWeight {
    static class Solution {
        private int[] stages;
        private Random rand = new Random();
        private int max;

        public Solution(int[] w) {
            stages = new int[w.length];
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                stages[i] = sum;
            }
            max = sum;
        }

        public int pickIndex() {
            int value = rand.nextInt(max);
            int index = Arrays.binarySearch(stages, value);
            if (index < 0) {
                index = -index - 1;
            } else {
                // Attention: If we found the value, we should use the next index.
                index++;
            }
            return index;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such: Solution obj =
     * new Solution(w); int param_1 = obj.pickIndex();
     */
}
