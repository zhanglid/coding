package com.zhangliang.google;
/*
  给一个 array ，给定一个 window length。
  要写两个 API，一个是 add number，另一个是求 window 里面数字去掉最高 5%然后去掉最低5%的平均值
*/

import java.util.*;

public class SlidingWindowSumWithoutSide {
  int[] sizes = new int[3];
  int size = 0;
  int[] currentSizes = new int[3];
  int[] sums = new int[3];

  TreeMap<Integer, Integer> leftTM = new TreeMap<>();
  TreeMap<Integer, Integer> middleTM = new TreeMap<>();
  TreeMap<Integer, Integer> rightTM = new TreeMap<>();

  List<TreeMap<Integer, Integer>> tms = new ArrayList<>();

  Queue<Integer> q = new LinkedList<>();

  public SlidingWindowSumWithoutSide(int size) {
    sizes[0] = size * 5 / 100;
    sizes[2] = sizes[0];
    sizes[1] = size - sizes[0] - sizes[1];
    for (int i = 0; i < tms.size(); i++) {
      tms.add(new TreeMap<Integer, Integer>());
    }
    this.size = size;
  }

  private void removeKeyFromGroup(int i, int outKey) {
    TreeMap<Integer, Integer> tm = tms.get(i);
    tm.put(outKey, tm.get(outKey) - 1);
    currentSizes[i]--;
    sums[i] -= outKey;
    if (tm.get(outKey) == 0) {
      tm.remove(outKey);
    }
  }

  private void addKeyToGroup(int i, int num) {
    TreeMap<Integer, Integer> tm = tms.get(i);
    tm.put(num, tm.getOrDefault(num, 0) + 1);
    currentSizes[i]++;
    sums[i] += num;
  }

  public void add(int num) {
    q.add(num);
    for (int i = 0; i < 3; i++) {
      TreeMap<Integer, Integer> tm = tms.get(i);
      if (tm.isEmpty() || num <= tm.lastKey()) {
        addKeyToGroup(i, num);
        break;
      }
    }
    if (q.size() > size) {
      int outKey = q.poll();
      for (int i = 0; i < 3; i++) {
        TreeMap<Integer, Integer> tm = tms.get(i);
        if (tm.containsKey(outKey)) {
          removeKeyFromGroup(i, outKey);
        }
      }
    }

    for(int i : new int[] {0, 2}) {
      if (currentSizes[i] < currentSizes[1] && ) {
        
      }
    }
  }

  public double getAvg() {

  }
}
