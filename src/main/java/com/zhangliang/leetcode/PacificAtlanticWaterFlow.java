package com.zhangliang.leetcode;
/*
Given an m x n matrix of non-negative integers representing the height of each unit cell 
in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the 
"Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another 
one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic 
ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in 
above matrix).
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        // use bfs mark all positions are reachable for pacific, again for
        // atlantic. merge the result to get the ans.

        List<int[]> ans = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return ans;
        }

        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            queue.add(new int[] { i, 0 });
            visited.add(i * matrix[0].length);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            queue.add(new int[] { 0, i });
            visited.add(i);
        }
        bfs(pacific, matrix, queue, visited);

        visited.clear();
        queue.clear();
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new int[] { i, matrix[0].length - 1 });
            visited.add(i * matrix[0].length + matrix[0].length - 1);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            queue.add(new int[] { matrix.length - 1, i });
            visited.add((matrix.length - 1) * matrix[0].length + i);
        }
        bfs(atlantic, matrix, queue, visited);

        // go throught the result to get ans
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(new int[] { i, j });
                }
            }
        }

        return ans;
    }

    private static int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void bfs(boolean[][] board, int[][] matrix, Queue<int[]> queue, Set<Integer> visited) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            board[pos[0]][pos[1]] = true;
            int value = matrix[pos[0]][pos[1]];

            for (int[] dir : dirs) {
                int ni = pos[0] + dir[0];
                int nj = pos[1] + dir[1];

                if (ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[0].length
                        || visited.contains(ni * matrix[0].length + nj) || matrix[ni][nj] < value) {
                    continue;
                }

                visited.add(ni * matrix[0].length + nj);
                queue.add(new int[] { ni, nj });
            }
        }
    }
}
