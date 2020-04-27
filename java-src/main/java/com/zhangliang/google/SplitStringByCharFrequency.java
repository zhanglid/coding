package com.zhangliang.google;
/*
  第一题是 给一个String，只有lowercase letter，要求返回split数，
  一个有效的split可以使左边和右边的same unique character的数量相同
  比如 "aabaab"，可以将其分成 "aab" 和 "aab"。也可以分成"aaba" 和 "ab"。
*/

import java.util.*;

public class SplitStringByCharFrequency {
  public int split(String word) {
    int n = word.length();
    int[] uniqRight = new int[n];
    int[] counts = new int[26];
    int charCnt = 0;
    for (int i = n - 1; i >= 0; i--) {
      char x = word.charAt(i);
      counts[x - 'a']++;
      uniqRight[i] = charCnt;
      if (counts[x - 'a'] == 1) {
        charCnt++;
      }
    }
    Arrays.fill(counts, 0);
    charCnt = 0;
    int res = 0;
    for (int i = 0; i < n; i++) {
      char x = word.charAt(i);
      counts[x - 'a']++;
      if (counts[x - 'a'] == 1) {
        charCnt++;
      }
      if (charCnt == uniqRight[i]) {
        res++;
      }
    }
    return res;
  }
}
