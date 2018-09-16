package com.zhangliang.leetcode;
/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can 
only move up, down, 
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

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.zhangliang.utils.Point;

public class ShortestDistanceFromAllBuildings {
    class PointState {
        public int viewCount;
        public int score;
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        PointState[][] scores = new PointState[grid.length][grid[0].length];

        int houseNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    houseNum++;
                    bfs(scores, grid, i, j, new HashSet<>());
                }
            }
        }

        int ans = -1;

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[0].length; j++) {
                if (grid[i][j] == 0 && scores[i][j] != null && scores[i][j].viewCount == houseNum) {
                    ans = ans == -1 ? scores[i][j].score : Math.min(ans, scores[i][j].score);
                }
            }
        }
        return ans;
    }

    private static final int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private int hash(int i, int j, int col) {
        return i * col + j;
    }

    private void bfs(PointState[][] scores, int[][] grid, int i, int j, Set<Integer> visited) {
        visited.add(hash(i, j, grid[0].length));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(hash(i, j, grid[0].length));

        int score = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int t = 0; t < size; t++) {
                int pos = queue.poll();
                int ci = pos / grid[0].length;
                int cj = pos % grid[0].length;
                if (scores[ci][cj] == null) {
                    scores[ci][cj] = new PointState();
                }
                scores[ci][cj].score += score;
                scores[ci][cj].viewCount++;
                for (int[] dir : dirs) {
                    int ni = ci + dir[0];
                    int nj = cj + dir[1];

                    if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] != 0
                            || visited.contains(hash(ni, nj, grid[0].length))) {
                        continue;
                    }
                    int npos = hash(ni, nj, grid[0].length);
                    visited.add(npos);
                    queue.add(npos);
                }
            }
            score++;
        }
    }
}
