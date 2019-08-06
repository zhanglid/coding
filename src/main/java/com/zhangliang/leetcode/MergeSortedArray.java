package com.zhangliang.leetcode;
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as 
one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to 
m + n) to hold 
additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || m < 0 || n < 0) {
            return;
        }
        // Move num1 offset of n
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        int i1 = n;
        int i2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (i2 >= n || (i1 < m + n) && nums2[i2] > nums1[i1]) {
                nums1[i] = nums1[i1++];
            } else {
                nums1[i] = nums2[i2++];
            }
        }
    }
}
