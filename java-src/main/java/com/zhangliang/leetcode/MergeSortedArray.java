package com.zhangliang.leetcode;
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into 
nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n 
respectively.
You may assume that nums1 has enough space (size that is greater or 
equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int t = nums1.length - 1; t - n >= 0; t--) {
            nums1[t] = nums1[t - n];
        }
        int i = n;
        int j = 0;
        int index = 0;
        while (j < nums2.length) {
            if (i < nums1.length && nums1[i] < nums2[j]) {
                nums1[index++] = nums1[i++];
            } else {
                nums1[index++] = nums2[j++];
            }
        }
    }
}
