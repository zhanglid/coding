package com.zhangliang.google;
/*
 warm up： 给一个字符串其中如果重复字符连续出现 3+ 次那么就是stretch letter了 
 把多余的letter去掉。。这个string 就是一个stretch word

  eg：helllllooo  -> helloo
  第二题是给一个stretch word 和一个indictionary() function， 
  判断这个stretch letter是不是可以从dictionary 中某一个word 生成, 
  dictionary 里的单词一定不是stretch的
  本质就是求stretch word的所有possibility 然后调用indictionary

  eg helllllooo -> hello, helo,heloo,helloo
  backtracking。。。楼主用了recursive 的写法。。不过小哥哥想要iterative的写法
  但是最后讨论完time，space complex 一样就没写了。。时间也到了

  给一个word(string)，比如 "hello" 单词里只要没有连续三个重复字母就算valid word, 
  比如 "heelloo"合法， "hellooo"不合法，写一个method来判断Input string是否合法。
  follow up是再给一个 boolean isIndictionary(String word)，如果之前的input string不合法，
  最少删几个字母可以让它变成一个indictionary的word, 比如"heeelloo"得删3个

  https://leetcode.com/problems/expressive-words/
*/

import java.util.*;

public class StretchWord {
  public String shrank(String word) {
    StringBuilder sb = new StringBuilder();
    int lCnt = 0;
    for (int i = 0; i < word.length(); i++) {
      char x = word.charAt(i);
      if (i > 0 && word.charAt(i - 1) == x && lCnt >= 2) {
        lCnt++;
        continue;
      }
      sb.append(x);
      if (i > 0 && word.charAt(i - 1) != x) {
        lCnt = 1;
      } else {
        lCnt++;
      }
    }
    return sb.toString();
  }

  private boolean dfs(int index, String word, String path, int lCnt, Set<String> dict) {
    if (index >= word.length()) {
      return dict.contains(path);
    }
    char x = word.charAt(index);

    if (dfs(index + 1, word, path + x, index > 0 && word.charAt(index - 1) != x ? 1 : (lCnt + 1), dict)) {
      return true;
    }
    // Can remove the current char
    if (lCnt >= 2 && word.charAt(index - 1) == x) {
      if (dfs(index + 1, word, path, lCnt + 1, dict)) {
        return true;
      }
    }
    return false;
  }

  private boolean canBuild(String word, String target) {
    int i = 0;
    int j = 0;
    while (i < word.length() && j < target.length()) {
      char a = word.charAt(i);
      char b = target.charAt(j);
      if (a != b) {
        return false;
      }
      int ri = i;
      while (ri < word.length() && word.charAt(ri) == a) {
        ri++;
      }

      int rj = j;
      while (rj < target.length() && target.charAt(rj) == b) {
        rj++;
      }

      if (ri - i > rj - j) {
        return false;
      }

      i = ri;
      j = rj;
    }

    return true;
  }

  // eg helllllooo -> hello, helo,heloo,helloo
  public boolean inDict(String target, String[] dict) {
    for (String word : dict) {
      if (canBuild(word, target)) {
        return true;
      }
    }
    return false;
  }
}
