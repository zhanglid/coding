package com.zhangliang.algorithm;
/*
  Assumptions: 
  Approach: 
    Recursion.
  DataStructure: 
  Complexity: 
      Time: O(n^2) 
      Space: O(1)
*/

public class QuickSort {
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private int partition(int[] nums, int i, int j) {
    int r = j;
    for (int l = i + 1; l <= r; l++) {
      if (nums[l] > nums[i]) {
        swap(nums, l--, r--);
      }
    }
    swap(nums, i, r);
    return r;
  }

  private void sort(int[] nums, int i, int j) {
    if (i >= j) {
      return;
    }
    int mid = partition(nums, i, j);
    sort(nums, i, mid - 1);
    sort(nums, mid + 1, j);
  }

  public void sort(int[] nums) {
    sort(nums, 0, nums.length - 1);
  }
}
