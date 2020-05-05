package com.zhangliang.algorithm;

import java.util.*;

public class RandomShuffle {
  private Random rand = new Random();

  private void swap(int[] values, int i, int j) {
    int t = values[i];
    values[i] = values[j];
    values[j] = t;
  }

  public void shuffle(int[] values) {
    int n = values.length;

    for (int i = n - 1; i >= 0; i--) {
      int r = rand.nextInt(i + 1);
      swap(values, i, r);
    }

  }
}
