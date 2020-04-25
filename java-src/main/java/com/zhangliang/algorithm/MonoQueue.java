package com.zhangliang.algorithm;
/*
   Mono Queue
*/

import java.util.*;

public class MonoQueue {
  private int[] nums;
  private int[] range;

  TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
    public int compare(Integer a, Integer b) {
      int diff = nums[a] - nums[b];
      return diff == 0 ? a - b : diff;
    }
  });

  public MonoQueue(int[] nums, int[] range) {
    this.nums = nums;
    this.range = range;
    for (int i = range[0]; i <= range[1]; i++) {
      ts.add(i);
    }
  }

  public int getMax() {
    return nums[ts.last()];
  }

  public void expandLeft() {
    ts.add(--range[0]);
  }

  public void shrinkLeft() {
    ts.remove(range[0]++);
  }

  public void expandRight() {
    ts.add(++range[1]);
  }

  public void shrinkRight() {
    ts.remove(range[1]--);
  }
}
