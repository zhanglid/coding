package com.zhangliang.leetcode;
/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        if ((len1 + len2) % 2 == 0) {
            int rank1 = (len1 + len2) / 2;
            int rank2 = rank1 + 1;
            int mid1 = findTopKthInTwoArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, rank1);
            int mid2 = findTopKthInTwoArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, rank2);

            return ((double)mid1 + mid2) / 2;
        }

        return findTopKthInTwoArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (len1 + len2) / 2 + 1);
    }

    private int findTopKthInTwoArrays(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        if (start1 >= nums1.length) {
            return nums2[k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int halfKIndex = k / 2 - 1;
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (halfKIndex >= len1) {
            return findTopKthInTwoArrays(nums1, start1, end1, nums2, start2 + halfKIndex + 1, end2, k - halfKIndex - 1);
        }

        if (halfKIndex >= len2) {
            return findTopKthInTwoArrays(nums1, start1 + halfKIndex + 1, end1, nums2, start2, end2, k - halfKIndex - 1);
        }

        int value1 = nums1[halfKIndex];
        int value2 = nums2[halfKIndex];

        if (value1 > value2) {
            return findTopKthInTwoArrays(nums1, start1, start1 + halfKIndex, nums2, start2 + halfKIndex + 1, end2, k - halfKIndex - 1);
        }

        if (value2 > value1) {
            return findTopKthInTwoArrays(nums1, start1 + halfKIndex + 1, end1, nums2, start2, start2 + halfKIndex, k - halfKIndex - 1);
        }

        if (k - 2 * halfKIndex - 2 == 0) {
            return value1;
        }

        return findTopKthInTwoArrays(nums1, start1 + halfKIndex + 1, end1, nums2, start2 + halfKIndex + 1, end2, k - 2 * halfKIndex - 2);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays s = new MedianOfTwoSortedArrays();
        System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2}));
    }
}