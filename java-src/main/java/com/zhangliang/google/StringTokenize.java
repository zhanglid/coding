package com.zhangliang.google;
/*
  coding "It is 'very good'". 要求tokenize成["It", "is", "very good"]. 就是单引号里面的不变 单引号外面的按space分开
  followup：给你1000台机器 一个file有petabytes大 只有一行 按照上面的规则tokenize
*/

import java.util.*;

public class StringTokenize {
  public String[] tokenize(String s) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);
      if (x == ' ') {
        continue;
      }
      int j = i + 1;
      while (j < s.length() && s.charAt(j) != (x == '\'' ? x : ' ')) {
        j++;
      }
      if (x == '\'') {
        res.add(s.substring(i + 1, j));
      } else {
        res.add(s.substring(i, j));
      }
      i = j;
    }

    return res.toArray(new String[0]);
  }
}
