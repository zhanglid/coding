package com.zhangliang.leetcode;
/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.

*/

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int bulketWidth = Math.max(1, (max - min) / nums.length + 1);

        int[] bulketMin = new int[nums.length];
        int[] bulketMax = new int[nums.length];

        for (int i = 0; i < bulketMax.length; i++) {
            bulketMax[i] = -1;
        }

        for (int i = 0; i < bulketMin.length; i++) {
            bulketMin[i] = -1;
        }

        for (int num : nums) {
            int bulketIndex = (num - min) / bulketWidth;
            if (bulketIndex == nums.length) {
                bulketIndex--;
            }
            int curMin = bulketMin[bulketIndex];
            bulketMin[bulketIndex] = curMin < 0 ? num : Math.min(curMin, num);
            bulketMax[bulketIndex] = Math.max(bulketMax[bulketIndex], num);
        }

        int ans = bulketMax[0] - bulketMin[0];
        int prevMax = bulketMax[1];
        for (int i = 1; i < bulketMax.length; i++) {
            int curMin = bulketMin[i];
            int curMax = bulketMax[i];

            if (curMin == -1) {
                continue;
            }
            ans = Math.max(ans, curMin - prevMax);
            prevMax = curMax;
        }

        return ans;
    }
}
