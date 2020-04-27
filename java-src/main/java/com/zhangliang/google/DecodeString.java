package com.zhangliang.google;
/*
  Decode string:
  ab(bcd){2}e-> abbcdbcde
  ab(c(de){2}){2}f -> abcdedecdedef
*/

import java.util.*;

public class DecodeString {
  public String decode(String input) {
    Stack<String> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char x = input.charAt(i);
      if (x == '(') {
        stack.push(sb.toString());
        sb = new StringBuilder();
      } else if (x == ')') {
        int j = i + 2;
        while (j < input.length() && Character.isDigit(input.charAt(j))) {
          j++;
        }
        int cnt = Integer.parseInt(input.substring(i + 2, j));
        String token = sb.toString();
        sb = new StringBuilder(stack.isEmpty() ? "" : stack.pop());
        while (cnt-- > 0) {
          sb.append(token);
        }
        i = j;
      } else {
        sb.append(x);
      }
    }
    return sb.toString();
  }
}
