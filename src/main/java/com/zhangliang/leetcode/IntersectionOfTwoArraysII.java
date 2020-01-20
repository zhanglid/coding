package com.zhangliang.leetcode;
/*
Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in 
both arrays. The result can be in any order.

Follow up:
What if the given array is already sorted? How would you optimize your 
algorithm? - Compare and merge.
What if nums1's size is small compared to nums2's size? Which algorithm 
is better? - Look up and store nums1 in mem.
What if elements of nums2 are stored on disk, and the memory is limited 
such that you cannot load all elements into the memory at once?
- Split the nums2 into each chunk. Calc the intersection of each chunk with
 the nums1 and store the index of intersected elements in nums1. Merge each result,
 keep unique index. MapReducer can be used to help this.
*/

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int num : nums1) {
            dict.put(num, dict.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (dict.containsKey(num)) {
                result.add(num);
                dict.put(num, dict.get(num) - 1);
                if (dict.get(num) == 0) {
                    dict.remove(num);
                }
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
