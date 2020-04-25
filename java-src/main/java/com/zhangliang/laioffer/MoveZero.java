package com.zhangliang.laioffer;
/*
(2.1) Array Shuffling 1: Given an array with integers, 
move all "0s" to the right-end of the array

  Assumptions: 
    integer array consists of 1, 0
  Approach: 
    quick sort partition, swap 0 with r.
  DataStructure: 
  Complexity: 
      Time: o(n ^ 2)
      Space: O(1)
*/

public class MoveZero {
  public void moveZero(int[] nums) {
    int l = 0; // All elements to the left of l (not include l) is greater than 0.
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[l++] = nums[i];
      }
    }

    while (l < nums.length) {
      nums[l++] = 0;
    }
  }
}
