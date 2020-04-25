package com.zhangliang.leetcode;
/*
You want to build a house on an empty land which reaches all buildings in 
the shortest amount of distance. You can only move up, down, 
left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7 

Explanation: 
Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
the point (1,2) is an ideal empty land to build a house, as the total 
distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such 
house according to the above rules, return -1.
*/

import java.util.*;

public class ShortestDistanceFromAllBuildings {
    private int hash(int[] point, int[][] grid) {
        return point[0] * grid[0].length + point[1];
    }

    private static final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void bfs(int[] point, int[][][] dists, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(point);
        Set<Integer> visited = new HashSet<>();
        visited.add(hash(point, grid));
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                // Update dist
                dists[cur[0]][cur[1]][0] += dist;
                dists[cur[0]][cur[1]][1] += 1;
                for (int[] dir : dirs) {
                    int[] nextCur = new int[] { cur[0] + dir[0], cur[1] + dir[1] };
                    // Out of bound
                    if (nextCur[0] < 0 || nextCur[0] >= grid.length || nextCur[1] < 0 || nextCur[1] >= grid[0].length) {
                        continue;
                    }
                    // cannot pass
                    if (grid[nextCur[0]][nextCur[1]] != 0) {
                        continue;
                    }
                    // visited
                    int hashCode = hash(nextCur, grid);
                    if (visited.contains(hashCode)) {
                        continue;
                    }
                    queue.add(nextCur);
                    visited.add(hashCode);
                }
            }
            dist++;
        }
    }

    public int shortestDistance(int[][] grid) {
        int[][][] dists = new int[grid.length][grid[0].length][2];
        Queue<int[]> emptyPoints = new LinkedList<>();
        int totalBuildingNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int[] point = new int[] { i, j };
                if (grid[i][j] == 1) {
                    totalBuildingNum++;
                    bfs(point, dists, grid);
                } else if (grid[i][j] == 0) {
                    emptyPoints.add(point);
                }
            }
        }
        int ans = -1;
        while (!emptyPoints.isEmpty()) {
            int[] point = emptyPoints.poll();
            int choice = dists[point[0]][point[1]][0];
            int buildingReached = dists[point[0]][point[1]][1];
            // never
            if (choice == 0 || buildingReached != totalBuildingNum) {
                continue;
            }
            if (ans == -1) {
                ans = choice;
            } else {
                ans = Math.min(ans, choice);
            }
        }
        return ans;
    }
}
