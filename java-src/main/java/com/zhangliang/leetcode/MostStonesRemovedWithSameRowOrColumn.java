package com.zhangliang.leetcode;
/*
On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0
 

Note:

1 <= stones.length <= 1000
0 <= stones[i][j] < 10000
*/

import java.util.*;

public class MostStonesRemovedWithSameRowOrColumn {
    private int dfs(int index, int[][] stones, Set<Integer> visited, Map<Integer, List<Integer>> stonesByX,
            Map<Integer, List<Integer>> stonesByY) {
        if (visited.contains(index)) {
            return 0;
        }
        visited.add(index);
        int count = 1;
        for (int stoneIndex : stonesByX.get(stones[index][0])) {
            count += dfs(stoneIndex, stones, visited, stonesByX, stonesByY);
        }
        for (int stoneIndex : stonesByY.get(stones[index][1])) {
            count += dfs(stoneIndex, stones, visited, stonesByX, stonesByY);
        }
        return count;
    }

    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> stoneByX = new HashMap<>();
        Map<Integer, List<Integer>> stoneByY = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            if (!stoneByX.containsKey(stone[0])) {
                stoneByX.put(stone[0], new ArrayList<>());
            }
            stoneByX.get(stone[0]).add(i);
            if (!stoneByY.containsKey(stone[1])) {
                stoneByY.put(stone[1], new ArrayList<>());
            }
            stoneByY.get(stone[1]).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            count += Math.max(0, dfs(i, stones, visited, stoneByX, stoneByY) - 1);
        }
        return count;
    }

}
