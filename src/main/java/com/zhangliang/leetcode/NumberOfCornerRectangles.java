package com.zhangliang.leetcode;
/*
Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. 
Note that only the corners need to have the value 1. Also, all four 1s used must be 
distinct.

Example 1:

Input: grid = 
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], 
grid[3][2], grid[3][4].
 

Example 2:

Input: grid = 
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 
rectangle.
 

Example 3:

Input: grid = 
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.
 

Note:

The number of rows and columns of grid will each be in the range [1, 200].
Each grid[i][j] will be either 0 or 1.
The number of 1s in the grid will be at most 6000.
*/

import java.util.*;

public class NumberOfCornerRectangles {
    private int lineHash(int i, int j) {
        return i + j * 200;
    }

    public int countCornerRectangles(int[][] grid) {
        Map<Integer, Integer> lines = new HashMap<>();
        for (int[] line : grid) {
            for (int i = 0; i < line.length; i++) {
                if (line[i] == 1) {
                    for (int j = i + 1; j < line.length; j++) {
                        if (line[j] == 1) {
                            int hash = lineHash(i, j);
                            lines.put(hash, lines.getOrDefault(hash, 0) + 1);
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int value : lines.values()) {
            ans += value * (value - 1) / 2;
        }
        return ans;
    }
}
