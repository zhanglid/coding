package com.zhangliang.leetcode;
/*
A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.
*/

import java.util.*;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        if (transactions.length == 0) {
          return 0;
        }
        Map<Integer, Integer> balance = new HashMap<>();
        for (int[] transaction : transactions) {
          int a = transaction[0];
          int b = transaction[1];
          int amount = transaction[2];
          if (!balance.containsKey(a)) {
            balance.put(a, 0);
          }
          if (!balance.containsKey(b)) {
            balance.put(b, 0);
          }
          balance.put(a, balance.get(a) - amount);
          balance.put(b, balance.get(b) + amount);
        }
        List<Integer> inList = new ArrayList<>();
        List<Integer> outList = new ArrayList<>();
        for (Integer key : balance.keySet()) {
          int amount = balance.get(key);
          if (amount < 0) {
            outList.add(-amount);
          }
          else {
            inList.add(amount);
          }
        }
        int[] result = new int[] {transactions.length};
        dfs(inList, outList, 0, result, 0);
        return result[0];
      }
      
      private void dfs(List<Integer> ins, List<Integer> outs, int index, int[] result, int count) {
        if (index >= outs.size() || outs.get(index) == 0) {
          result[0] = Math.min(result[0], count);
          return;
        }
        int amount = outs.get(index);
        for (int i = 0; i < ins.size(); i++) {
          if (ins.get(i) != 0) {
            int inAmount = ins.get(i);
            if (amount <= inAmount) {
              ins.set(i, inAmount - amount);
              outs.set(index, 0);
              dfs(ins, outs, index + 1, result, count + 1);
            }
            else {
              ins.set(i, 0);
              outs.set(index, amount - inAmount);
              dfs(ins, outs, index, result, count + 1);
            }
            ins.set(i, inAmount);
            outs.set(index, amount);
          }
        }
      }
      
}
