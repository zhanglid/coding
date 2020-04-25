package com.zhangliang.leetcode;
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 1 || k < 1) {
            return ans;
        }

        helper(new ArrayList<>(), ans, k, n);
        return ans;
    }

    private void helper(List<Integer> curList, List<List<Integer>> ans, int target, int limit) {
        if (curList.size() == target) {
            ans.add(new ArrayList<>(curList));
            return;
        }

        int start = 1;
        if (curList.size() > 0) {
            start = curList.get(curList.size() - 1) + 1;
        }

        for (int i = start; i <= limit; i++) {
            curList.add(i);
            helper(curList, ans, target, limit);
            curList.remove(curList.size() - 1);
        }
    }
}
