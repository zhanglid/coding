package com.zhangliang.algorithm;
/*
 Quick sort algorithm
*/

public class QuickSort {
  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  private int partition(int[] nums, int i, int j) {
    int l = i + 1;
    int r = j;
    while (l <= r) {
      if (nums[l] >= nums[i]) {
        swap(nums, l, r--);
      } else {
        l++;
      }
    }

    swap(nums, i, r);
    return r;
  }

  private void sortUtil(int[] nums, int i, int j) {
    if (i >= j) {
      return;
    }
    int mi = partition(nums, i, j);
    sortUtil(nums, i, mi);
    sortUtil(nums, mi + 1, j);
  }

  public void sort(int[] nums) {
    sortUtil(nums, 0, nums.length - 1);
  }
}
