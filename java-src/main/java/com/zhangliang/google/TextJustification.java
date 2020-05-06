package com.zhangliang.google;
/*
  给一个string，是一个包含很多单词的句子，单词之间用空格隔开。
  然后要把这个string放到一个宽度为width的page里，问需要多少行来填满这些单词。
  类似于leetcode 68，但是返回的是需要多少行
*/

public class TextJustification {
  public int numberOfRows(String s, int width) {
    String[] words = s.split(" ");
    int n = words.length;
    int[] dp = new int[n + 1];
    for (int i = 0; i < n; i++) {
      int w = words[i].length();
      dp[i + 1] = Integer.MAX_VALUE;
      for (int t = i; t >= 0 && w <= width; t--) {
        dp[i + 1] = Math.min(dp[i + 1], dp[t] + 1);
        if (t - 1 >= 0) {
          w += words[t - 1].length();
          w += 1;
        }
      }
    }

    return dp[n];
  }
}
