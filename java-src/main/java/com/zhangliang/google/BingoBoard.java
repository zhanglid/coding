package com.zhangliang.google;
/*
@TODO: Google
生成一个5*5的 bingo board，第一列值在1-15之间， 第二列16-30，。。board里不能有重复的数。

followup是要生成很多board，并且每两个board之间不能有相同的列。也很简单，先生产很多不重复的第一列，
然后第二列，。。。之后一个一个assemble就好。
*/

import java.util.*;

public class BingoBoard {

  private static final int N = 5;
  private static final int SIZE = 15;

  Random rand = new Random();

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  private void shuffle(int[] nums) {
    for (int i = nums.length - 1; i >= 0; i--) {
      int l = rand.nextInt(i + 1);
      swap(nums, l, i);
    }
  }

  private int[] randomCol(int offset) {
    int[] nums = new int[SIZE];
    for (int i = 0; i < SIZE; i++) {
      nums[i] = offset + i;
    }
    shuffle(nums);
    int[] res = new int[N];
    for (int i = 0; i < N; i++) {
      res[i] = nums[i];
    }
    return res;
  }

  public int[][] generate() {
    int[][] res = new int[N][N];
    for (int i = 0; i < res.length; i++) {
      int[] col = randomCol(i * 15 + 1);
      for (int j = 0; j < N; j++) {
        res[i][j] = col[j];
      }
    }

    return res;
  }
}
