package com.zhangliang.laioffer;
/*

Given an array A[N] with all positive integers from [1...N]. 
How to get an array B[N] such that B[i] represents how many elements A[j] (j > i) in array A[] that are smaller than A[i]. 
For example, given A[N]={4, 1, 3, 2}, we should get B[N]={3, 0, 1, 0}. Requirement: Time = O(nlogn). 

  Assumptions: 
    positive
    in range [1...N]

  Approach: 
    Merge sort.
    During merge
    Add count of elements from right that has been merged to the count for the current left element.

  DataStructure: 

  Complexity: 
      Time: O(nlogn)
      Space: O(n)
*/

public class LargerCountRight {
  private void merge(int[][] pairs, int i, int mid, int j, int[] counts) {
    int[][] temp = new int[j - i + 1][2];
    int l = i;
    int r = mid + 1;
    int t = 0;
    while (l <= mid || r < j) {
      if (l <= mid && (r > j || pairs[l][0] < pairs[r][0])) {
        temp[t++] = pairs[l];
        counts[pairs[l][1]] += r - mid - 1;
        l++;
      } else {
        temp[t++] = pairs[r];
        r++;
      }
    }

    // Copy back
    for (int k = 0; k < temp.length; k++) {
      pairs[i + k] = temp[k];
    }
  }

  private void sort(int[][] pairs, int i, int j, int[] counts) {
    if (i == j) {
      return;
    }
    int mid = i + (j - i) / 2;
    sort(pairs, i, mid, counts);
    sort(pairs, mid + 1, j, counts);
    merge(pairs, i, mid, j, counts);
  }

  public int[] count(int[] nums) {
    int[] counts = new int[nums.length];
    int[][] pairs = new int[nums.length][2];

    for (int i = 0; i < nums.length; i++) {
      pairs[i] = new int[] { nums[i], i };
    }
    sort(pairs, 0, pairs.length - 1, counts);
    return counts;
  }
}
