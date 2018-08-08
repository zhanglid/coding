package com.zhangliang.leetcode;
/*
There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. 
In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower 
will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will 
be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also 
the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.

Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1
Note:
The given array will be in the range [1, 20000].
*/

import java.util.TreeSet;

public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || k < 0 || flowers.length < 1) {
            return -1;
        }

        TreeSet<Integer> ts = new TreeSet<>();
        int day = 1;
        for (int flower : flowers) {
            Integer right = ts.ceiling(flower);
            Integer left = ts.floor(flower);

            if (right != null && right - flower - 1 == k) {
                return day;
            }

            if (left != null && flower - left - 1 == k) {
                return day;
            }

            ts.add(flower);
            day++;
        }

        return -1;
    }
}
