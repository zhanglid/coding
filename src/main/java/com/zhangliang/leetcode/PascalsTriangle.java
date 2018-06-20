package com.zhangliang.leetcode;
/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows < 1) {
            return ans;
        }

        ans.add(Arrays.asList(1));
        List<Integer> prevRow = ans.get(0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for (int j = 1; j < prevRow.size(); j++) {
                curRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }
            curRow.add(1);
            ans.add(curRow);
            prevRow = curRow;
        }

        return ans;
    }
}
