package com.zhangliang.leetcode;
/*
A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its 
bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles 
that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Notes:

Both rectangles rec1 and rec2 are lists of 4 integers.
All coordinates in rectangles will be between -10^9 and 10^9.

*/

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int left = Math.min(rec1[0], rec2[0]);
        int right = Math.max(rec1[2], rec2[2]);
        int top = Math.max(rec1[3], rec2[3]);
        int bottom = Math.min(rec1[1], rec2[1]);

        int length = right - left;
        int height = top - bottom;

        int len1 = rec1[2] - rec1[0];
        int len2 = rec2[2] - rec2[0];

        int height1 = rec1[3] - rec1[1];
        int height2 = rec2[3] - rec2[1];

        return (len1 + len2 > length) && (height1 + height2 > height);
    }
}
