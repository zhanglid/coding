package com.zhangliang.google;
/*
  Given an unsorted array, find the c closest elements to k
  找到和k最接近的c个值
  using quick select
*/

public class QuickSelectTopK {
  private void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  private int partition(int[] arr, int startIndex, int size, int c) {
    int pivot = arr[startIndex];
    int l = startIndex + 1;
    for (int i = startIndex + 1; i < startIndex + size; i++) {
      if (Math.abs(arr[i] - c) - Math.abs(pivot - c) <= 0) {
        swap(arr, i, l++);
      }
    }
    l--;
    swap(arr, startIndex, l);
    return l;
  }

  private int quickTopKthUtil(int[] arr, int startIndex, int size, int target, int k) {
    int r = partition(arr, startIndex, size, target);
    if (r - startIndex == k - 1) {
      return arr[r];
    } else if (r - startIndex > k - 1) {
      return quickTopKthUtil(arr, startIndex, r - startIndex, target, k);
    } else {
      return quickTopKthUtil(arr, r + 1, size - (r - startIndex + 1), target, k - (r - startIndex + 1));
    }
  }

  public int quickTopKth(int[] arr, int target, int k) {
    return quickTopKthUtil(arr, 0, arr.length, target, k);
  }
}
