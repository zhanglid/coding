package com.zhangliang.leetcode;
/*
You are given an integer array nums and you have to return a new counts array. The counts array has the 
property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
*/

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    class Num {
        int value;
        int index;
        int count;

        public Num(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private void merge(Num[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Num[] left = new Num[n1];
        Num[] right = new Num[n2];

        for (int i = 0; i < left.length; i++) {
            left[i] = nums[l + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[m + i + 1];
        }

        int i = 0, j = 0;
        int k = l;
        int count = 0;

        while (i < n1 && j < n2) {
            if (left[i].value <= right[j].value) {
                left[i].count += count;
                nums[k++] = left[i];
                i++;
            } else {
                count++;
                nums[k++] = right[j];
                j++;
            }
        }

        while (i < n1) {
            left[i].count += count;
            nums[k++] = left[i];
            i++;
        }

        while (j < n2) {
            nums[k++] = right[j];
            j++;
        }

    }

    private void helper(Num[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            helper(nums, l, m);
            helper(nums, m + 1, r);

            merge(nums, l, m, r);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Num[] pNums = new Num[nums.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pNums[i] = new Num(nums[i], i);
            result.add(0);
        }
        helper(pNums, 0, nums.length - 1);
        for (Num num : pNums) {
            result.set(num.index, num.count);
        }
        return result;
    }
}
