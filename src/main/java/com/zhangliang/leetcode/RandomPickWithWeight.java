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

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {
    static class Solution {
        private TreeMap<Integer, Integer> values = new TreeMap<>();
        private int sum;
        private Random random;

        public Solution(int[] w) {
            for (int i = 0; i < w.length; i++) {
                values.put(sum, i);
                sum += w[i];
            }
            random = new Random();
        }

        public int pickIndex() {
            int rnd = random.nextInt(sum);
            return values.floorEntry(rnd).getValue();
        }
    }
}
