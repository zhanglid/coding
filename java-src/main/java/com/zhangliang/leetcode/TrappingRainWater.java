package com.zhangliang.leetcode;
/*
Given n non-negative integers representing an elevation map where the width of 
each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos 
for contributing this image!
       1
   1xxx11x1
 1x11x111111
Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int val : height) {
            if (stack.peek() <= val) {
                stack.push(val);
            }
        }
        int rightMax = 0;
        int ans = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            ans += Math.max(0, Math.min(stack.peek(), rightMax) - height[i]);
            rightMax = Math.max(rightMax, height[i]);
            if (stack.peek() == height[i]) {
                stack.pop();
            }
        }
        return ans;
    }
}
