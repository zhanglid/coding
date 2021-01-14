package com.zhangliang.amazon;
/*
  Assumptions: 
  Approach: 
  DataStructure: 
  Complexity: 
      Time: 
      Space: 
  !Remeber to comment 
*/

import java.util.*;

public class StorageOptimization {
  public int helper(int n, List<Integer> l) {
    if (l.isEmpty()) {
      return 1;
    }
    int max = n > 0 ? 1 : 0;

    Collections.sort(l);
    int pre = l.get(0) - 1;
    int current = 1;
    for (int value : l) {
      if (value < 1) {
        continue;
      }
      if (value > n) {
        break;
      }
      if (value == pre + 1) {
        current += 1;
      } else {
        max = Math.max(current, max);
        current = 2;
      }
      pre = value;
    }
    max = Math.max(current, max);
    return max;
  }

  public int solve(int n, int m, List<Integer> h, List<Integer> v) {
    return helper(n, h) * helper(m, v);
  }
}
