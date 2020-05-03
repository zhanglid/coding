package com.zhangliang.algorithm;
/*
所以对于其中每个元素，被保留的概率都为 k / n
*/

import java.util.*;

public class ReservoirSampling {
  int[] nums;
  Random rand;

  public ReservoirSampling(int[] nums) {
    this.nums = nums;
    rand = new Random();
  }

  public int[] sample(int k) {
    int[] res = new int[k];
    int i = 0;
    for (; i < k && i < nums.length; i++) {
      res[i] = nums[i];
    }

    for (; i < nums.length; i++) {
      int r = rand.nextInt(i + 1);
      if (r < k) {
        res[r] = nums[i];
      }
    }

    return res;
  }
}
