package com.zhangliang.google;
/*
  @TODO: Google
  是给一个字符串只有1，0，count substring only contains 0.。。
  比如 10011000 就是0，0，00，0，0，0，00，00，000 返回9
  1. follow up是 给一个matrix count submatrix only contains 0.
  2. 2D 里面求array
*/

public class NumberOfAllZeros {
  public int countZero(String s) {
    int res = 0;
    int c = 0;
    for (char x : s.toCharArray()) {
      if (x == '0') {
        c++;
      } else {
        c = 0;
      }
      res += c;
    }
    return res;
  }

  public int countSubmatrixZero(int[][] grid) {
  }
}
