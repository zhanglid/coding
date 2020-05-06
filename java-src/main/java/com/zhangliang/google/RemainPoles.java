package com.zhangliang.google;
/*
  假设给了一堆不同高度的电线杆，现在要在这些电线杆上面放一根电线，绕在他们上面后拉直，问哪些杆子会被碰到。注意两个电线杆子中间如果哪根杆子高度不够，可能就不会被碰到。
  比如：
      |  
      |  
      |  
      |  
  | | |  
  | | | |
  | | | |
  0 1 2 3

  -> 0 2 3

  只有第一根，第三根和最后一根柱子会被电线碰到。注意input是对应index上电线杆的高度，return array/list 包含被碰到的电线杆index
*/

import java.util.*;

public class RemainPoles {
  public int[] solve(int[] arr) {
    if (arr.length < 1) {
      return new int[0];
    }
    // [index, delta]
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[] { 0, Integer.MAX_VALUE });
    for (int i = 1; i < arr.length; i++) {
      int[] pole = new int[] { i, arr[i] - arr[i - 1] };
      while (!stack.isEmpty() && stack.peek()[1] < pole[1]) {
        stack.pop();
      }
      stack.push(pole);
    }
    int[] res = new int[stack.size()];
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = stack.pop()[0];
    }
    return res;
  }
}
