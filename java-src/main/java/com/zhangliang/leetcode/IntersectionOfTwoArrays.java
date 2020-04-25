package com.zhangliang.leetcode;
/*
Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:
Each element in the result must be unique.
The result can be in any order.
*/

import java.util.*;

public class IntersectionOfTwoArrays {
    private int[] toIntArray(Set<Integer> set) {
        int index = 0;
        int[] ans = new int[set.size()];
        for (Integer num : set) {
            ans[index++] = num;
        }
        return ans;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }
        return toIntArray(intersectionSet);
    }
}
