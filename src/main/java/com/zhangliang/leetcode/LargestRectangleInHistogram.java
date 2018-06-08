package com.zhangliang.leetcode;
/*
Given n non-negative integers representing the histogram's bar height where the width of 
each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.
Example:

Input: [2,1,5,6,2,3]
Output: 10
*/

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }

        int[] lefts = new int[heights.length];
        int top = -1;
        for (int i = 0; i < heights.length; i++) {
            while (top != -1 && heights[top] >= heights[i]) {
                top = lefts[top];
            }
            lefts[i] = top;
            top = i;
        }

        int ans = 0;
        top = heights.length;
        int[] rights = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (top != heights.length && heights[top] >= heights[i]) {
                top = rights[top];
            }

            rights[i] = top;
            top = i;
            ans = Math.max(ans, heights[i] * (rights[i] - lefts[i] - 1));
        }

        return ans;
    }
}
