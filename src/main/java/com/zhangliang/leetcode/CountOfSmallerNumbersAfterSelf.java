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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {

    private void add(int[] array, int index, int delta) {
        int bitIndex = index + 1;

        while(bitIndex < array.length) {
            array[bitIndex] += delta;
            bitIndex += bitIndex & -bitIndex;
        }
    }

    private int get(int[] array, int end) {
        int bitIndex = end + 1;
        int sum = 0;
        while(bitIndex > 0) {
            sum += array[bitIndex];
            bitIndex -= bitIndex & -bitIndex;
        }

        return sum;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(count.keySet());
        Collections.sort(keys);
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
             rankMap.put(keys.get(i), i);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rankMap.get(nums[i]);
        }

        int[] array = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(0, get(array, nums[i] - 1));
            add(array, nums[i], 1);
        }

        return ans;
    }
}
