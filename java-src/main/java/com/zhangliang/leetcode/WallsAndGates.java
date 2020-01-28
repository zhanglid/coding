package com.zhangliang.leetcode;
/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you 
may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it 
should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

import java.util.*;

public class WallsAndGates {
  static private final int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  private List<int[]> extractZeros(int[][] rooms) {
    List<int[]> zeros = new ArrayList<>();
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        if (rooms[i][j] == 0) {
          zeros.add(new int[] { i, j });
        }
      }
    }
    return zeros;
  }

  private void bfs(int[][] rooms, int[] pos) {
    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(pos);
    int dist = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] cur = queue.pollFirst();
        int val = rooms[cur[0]][cur[1]];
        if (val <= dist && dist != 0) {
          continue;
        }
        rooms[cur[0]][cur[1]] = dist;
        for (int[] dir : dirs) {
          int[] next = new int[] { dir[0] + cur[0], dir[1] + cur[1] };
          if (next[0] < 0 || next[0] >= rooms.length || next[1] < 0 || next[1] >= rooms[0].length
              || rooms[next[0]][next[1]] <= 0) {
            continue;
          }
          queue.add(next);
        }
      }
      dist++;
    }
  }

  public void wallsAndGates(int[][] rooms) {
    List<int[]> zeros = extractZeros(rooms);
    for (int[] pos : zeros) {
      bfs(rooms, pos);
    }
  }
}
