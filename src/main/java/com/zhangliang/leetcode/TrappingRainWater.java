package com.zhangliang.leetcode;
/*
Given n non-negative integers representing an elevation map where the width of 
each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos 
for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }

        int[] leftMaxes = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            leftMaxes[i] = max;
            max = Math.max(max, height[i]);
        }

        int ans = 0;
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            ans += Math.max(0, Math.min(max, leftMaxes[i]) - height[i]);
            max = Math.max(max, height[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater s = new TrappingRainWater();
        System.out.println(s.solve());
    }
}
