package com.zhangliang.google;
/*
  就是给一个list的numbers，长度是n，找出最长的sublist, 在这个sublist中，没有差值是大于d的两个数。
*/

import java.util.*;

public class LongestSubarrayWithDifferenceLessThanK {
  public int solve(int[] arr, int k) {
    int res = 0;
    if (arr.length < 1 || k < 0) {
      return res;
    }
    Deque<Integer> maxDeque = new LinkedList<>();
    Deque<Integer> minDeque = new LinkedList<>();

    int l = 0;
    for (int i = 0; i < arr.length; i++) {
      while (!maxDeque.isEmpty() && maxDeque.peek() < arr[i]) {
        maxDeque.pollLast();
      }
      maxDeque.offerLast(arr[i]);

      while (!minDeque.isEmpty() && minDeque.peek() > arr[i]) {
        minDeque.pollLast();
      }
      minDeque.offerLast(arr[i]);

      while (maxDeque.peekFirst() - minDeque.peekFirst() > k) {
        int lv = arr[l++];
        if (minDeque.peekFirst() == lv) {
          minDeque.pollFirst();
        }
        if (maxDeque.peekFirst() == lv) {
          maxDeque.pollFirst();
        }
      }

      res = Math.max(i - l + 1, res);
    }

    return res;
  }
}
