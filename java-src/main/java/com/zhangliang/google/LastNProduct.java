package com.zhangliang.google;
/*
  第一輪:   很 nice 的國人小哥
  寫一個class裡面有兩個method   add() and get()
  add(int num) : takes an integer
  get() : output the product of the last N numbers
  N is given, which can be the argument of the constructor
  For example:
  N is 3
  add(2)
  add(3)
  add(4)
  get() -> return 2 X 3 X 4 = 24
  add(5)
  get(3) -> return 3 X 4 X 5 = 60
  
  follow up: 可以做到兩個method 都是 O(1) 嗎?
*/

import java.util.*;

public class LastNProduct {
  private List<Integer> dp = new ArrayList<>();

  public void add(int number) {
    if (number == 0) {
      dp = new ArrayList<>();
    }
    if (dp.isEmpty()) {
      dp.add(number);
    } else {
      dp.add(dp.get(dp.size() - 1) * number);
    }
  }

  public int get(int size) {
    if (size > dp.size()) {
      return 0;
    }
    return dp.get(dp.size() - 1) / (size == dp.size() ? 1 : dp.get(dp.size() - size - 1));
  }
}
