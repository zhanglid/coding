package com.zhangliang.leetcode;
/*
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements
 are subset of nums2. Find all the next greater numbers for nums1's elements in the 
 corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its 
right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it 
    in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second 
    array is 3.
    For number 2 in the first array, there is no next greater number for it in the 
    second array, so output -1.

Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second 
    array is 3.
    For number 4 in the first array, there is no next greater number for it in the 
    second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // assume the nums1 is subset of nums2

        // if we get empty input, we will return empty array
        if (nums1 == null || nums2 == null || nums1.length < 1) {
            return new int[0];
        }

        // use stack to store unresovled number and go throught the nums2
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums2) {
            while (!stack.isEmpty() && stack.peek() < x) {
                map.put(stack.pop(), x);
            }
            stack.push(x);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
