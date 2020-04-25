package com.zhangliang.leetcode;
/*
Given an array consists of non-negative integers, your task is to count 
the number of triplets chosen from the array that can make triangles if 
we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].
*/

import java.util.*;

public class ValidTriangleNumber {
    private int binaryFind(int[] nums, int start, int end, int target) {
        int l = start;
        int r = end;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[l] > target) {
            return l;
        }
        return r;
    }

    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int l = 0; l < nums.length; l++) {
            if (nums[l] == 0) {
                continue;
            }
            for (int r = nums.length - 1; r > l + 1; r--) {
                int a = nums[l];
                int c = nums[r];
                int bMin = c - a;
                int searchResult = binaryFind(nums, l + 1, r, bMin);
                result += r - searchResult;
            }
        }
        return result;
    }
}
