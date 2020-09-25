package com.zhangliang.facebook;
/*
You are given two arrays of integers a and b , which are both sorted 
in an ascending order and contain unique elements (i.e. no duplicates). 
You can take several (possibly zero) numbers from the array b and add 
them to a at any positions in any order. You want the array a to be an 
arithmetic progression after this. 

Your task is to find the maximal length of the resulting arithmetic progression 
represented by array a that can be achieved. If it is impossible to obtain an 
array forming an arithmetic progression, return -1 . 

Example 
• For a = [0, 4, 8, 16] and b = [0, 2, 6, 12, 14, 20] , the output should be 

maxArithmeticLength(a, b) = 6 . 

You can add b[3] = 12 and b[5] = 20 a and obtain array [0, 4, 8, 12, 16, 20] , 
which is an arithmetic progression of length 

*/

public class LongestArithmeticProgression {
  private int helper(int[] a, int[] b, int delta) {
    int res = 1;
    // for numbers in b smaller than a[0]
    int j = 0;
    while (j < b.length && b[j] <= a[0]) {
      j++;
    }
    int cur = a[0];
    for (int t = j - 1; t >= 0; t--) {
      if (b[t] == cur - delta) {
        res++;
        cur = b[t];
      }
    }

    // for numbers in b larger than a[0]
    int i = 1;
    cur = a[0];

    while (i < a.length || j < b.length) {
      // a can match
      if (i < a.length && a[i] == cur + delta) {
        cur = a[i];
        res++;
        i++;
        continue;
      }

      // discard useless small numbers in b
      while (j < b.length && b[j] < cur + delta) {
        j++;
      }

      // b cannot match
      if (j >= b.length || b[j] != cur + delta) {
        break;
      }

      // b can match
      cur = b[j];
      res++;
      j++;
    }

    if (i < a.length) {
      return -1;
    }

    return res;
  }

  /**
   * 
   * @param a length > 0, unique, sorted
   * @param b length > 0, unique, sorted
   * @return int
   */
  public int maxArithmeticLength(int[] a, int[] b) {
    int res = -1;

    // try each possible delta
    for (int i = 0; i < b.length; i++) {
      res = Math.max(res, helper(a, b, Math.abs(b[i] - a[0])));
    }
    if (a.length > 1) {
      res = Math.max(res, helper(a, b, a[1] - a[0]));
    }
    return res;
  }
}
