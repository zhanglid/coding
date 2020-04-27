package com.zhangliang.google;
/*
Given a pattern containing only I’s and D’s. 
I for increasing and D for decreasing. Devise an algorithm to print 
the minimum number following that pattern. Digits from 1-9 and digits 
can’t repeat.

Examples:
   Input: D        Output: 21
   Input: I        Output: 12
   Input: DD       Output: 321
   Input: II       Output: 123
   Input: DIDI     Output: 21435
   Input: IIDDD    Output: 126543
   Input: DDIDDIID Output: 321654798 
*/

import java.util.*;

public class FormMinimumNumberFromGivenSequence {
  private void reverse(int[] digits, int i, int j) {
    while (i < j) {
      int t = digits[i];
      digits[i] = digits[j];
      digits[j] = t;
      i++;
      j--;
    }
  }

  public int getNum(String order) {
    int n = order.length();
    int[] digits = new int[n + 1];

    for (int i = 1; i <= n + 1; i++) {
      digits[i - 1] = i;
    }

    for (int i = 0; i < n; i++) {
      char x = order.charAt(i);
      if (x == 'I') {
        continue;
      }
      int j = i + 1;
      while (j < n && order.charAt(j) == 'D') {
        j++;
      }
      reverse(digits, i, Math.min(n, j));
      i = j - 1;
    }

    int res = 0;
    for (int d : digits) {
      res = res * 10 + d;
    }
    return res;
  }
}
