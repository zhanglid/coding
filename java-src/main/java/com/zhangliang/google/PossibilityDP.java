package com.zhangliang.google;
/*
  问n个球放进k个bucket使得所有bucket都非空，有几种方法。
  我给了一个计算公式，面试官问我的公式做了什么假设。
                               (n, k) 
                  /          |       |            \
      (n - 1, k - 1)(1), (n - 2, k - 1)(2), (n - 3, k - 1)(3)... until n >= k - 1
      
      (n, k) for n == k
      (n, k) k == 1
  想了想发现是球和bucket都不是distinguishable。
  他又问我如果球是distinguishable，或者bucket是distinguishable，
  或者两者都是，分别要怎么计算。然后再让我选一种实现打印所有放法。
  follow up是怎么样进行性能优化。
*/

public class PossibilityDP {
  public int solve(int n, int k) {
    if (n < k) {
      return 0;
    }
    if (n == k || k == 1) {
      return 1;
    }

    int res = 0;
    int last = 1;
    while (n - last >= k - 1) {
      res += solve(n - last, k - 1);
      last++;
    }
    return res;
  }
}
