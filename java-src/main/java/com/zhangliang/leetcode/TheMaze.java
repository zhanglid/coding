package com.zhangliang.leetcode;
/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty 
spaces by rolling up, down, left or right, but it won't stop rolling until hitting a 
wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the 
ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty 
space. You may assume that the borders of the maze are all walls. The start and 
destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at 
the same position initially.
The given maze does not contain border (like the red rectangle in the example 
pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the 
maze won't exceed 100.
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TheMaze {
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length < 1 || maze[0].length < 1 || start == null || start.length < 1 || destination == null || destination.length < 1) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start[0] * maze.length + start[1]);
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];
            if (i == destination[0] && j == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int ni = i;
                int nj = j;

                while(ni >= 0 && ni < maze.length && nj >=0 && nj < maze[0].length && maze[ni][nj] != 1) {
                    ni += dir[0];
                    nj += dir[1];
                }
                ni -= dir[0];
                nj -= dir[1];

                if (ni == i && nj == j || visited.contains(ni * maze[0].length + nj)) {
                    continue;
                }

                visited.add(ni * maze[0].length + nj);
                queue.add(new int[]{ni, nj});
            }
        }

        return false;
    }
}
