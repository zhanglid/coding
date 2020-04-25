package com.zhangliang.leetcode;
/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until 
hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the 
number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start 
and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TheMazeII {
    static class Point {
        private static final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        public int i;
        public int j;
        public int dist;
        public int dirIndex;

        public int totalCol;
        public int totalRow;

        public Point(int i, int j, int dirIndex, int[][] maze) {
            this.i = i;
            this.j = j;
            this.dirIndex = dirIndex;
            dist = 0;
            totalCol = maze[0].length;
            totalRow = maze.length;
        }

        public Point(Point other) {
            i = other.i;
            j = other.j;
            dirIndex = other.dirIndex;
            dist = other.dist;
            totalCol = other.totalCol;
            totalRow = other.totalRow;
        }

        public void move() {
            i += dirs[dirIndex][0];
            j += dirs[dirIndex][1];
            dist++;
        }

        public void revert() {
            i -= dirs[dirIndex][0];
            j -= dirs[dirIndex][1];
            dist--;
        }

        public void updateDirIndex(int dirIndex) {
            this.dirIndex = dirIndex;
        }

        public boolean isOutOfBound() {
            return i < 0 || i >= totalRow || j < 0 || j >= totalCol;
        }

        public int hash() {
            return totalCol * i + j + dirIndex * 100 * 100;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length < 1 || maze[0].length < 1 || start == null || start.length < 1
                || destination == null || destination.length < 1) {
            return 0;
        }

        Queue<Point> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int dirIndex = 0; dirIndex < 4; dirIndex++) {
            Point point = new Point(start[0], start[1], dirIndex, maze);
            queue.add(point);
            visited.add(point.hash());
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                point.move();
                if (point.isOutOfBound() || maze[point.i][point.j] == 1) {
                    // hit wall
                    point.revert();
                    if (point.i == destination[0] && point.j == destination[1]) {
                        return point.dist;
                    }
                    for (int dirIndex = 0; dirIndex < 4; dirIndex++) {
                        point.updateDirIndex(dirIndex);
                        point.move();
                        if (!point.isOutOfBound() && maze[point.i][point.j] == 0 && !visited.contains(point.hash())) {
                            visited.add(point.hash());
                            queue.add(new Point(point));
                        }
                        point.revert();
                    }
                } else if (!visited.contains(point.hash())) {
                    visited.add(point.hash());
                    queue.add(point);
                }
            }
        }

        return -1;
    }
}
