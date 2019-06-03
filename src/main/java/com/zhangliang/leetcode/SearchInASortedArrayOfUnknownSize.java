package com.zhangliang.leetcode;
/*
Given an integer array sorted in ascending order, write a function to search target in nums.  
If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may 
only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at 
index k (0-indexed).

You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.
get will return 2147483647.

Example 1:

Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4


Example 2:

Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Note:

You may assume that all elements in the array are unique.
The value of each element in the array will be in the range [-9999, 9999].
*/

import com.zhangliang.utils.ArrayReader;

public class SearchInASortedArrayOfUnknownSize {
    private final static int INIT_SIZE = 10;
    private final static int MAX_SIZE = 10000;

    public int search(ArrayReader reader, int target) {
        int r = INIT_SIZE;
        // find right side;
        while (reader.get(r) < target && r != MAX_SIZE) {
            r = Math.min(2 * r, MAX_SIZE);
        }

        // binary search
        int l = 0;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (reader.get(mid) < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (reader.get(r) == target) {
            return r;
        }

        if (reader.get(l) == target) {
            return l;
        }

        return -1;
    }
}
