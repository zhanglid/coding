package com.zhangliang.leetcode;
/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop 
rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it 
rolls on to the hole.

Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by 
the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 
'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output 
"impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and 
the hole coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)

Output: "lul"
Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

Example 2

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)
Output: "impossible"
Explanation: The ball cannot reach the hole.

Note:
There is only one ball and one hole in the maze.
Both the ball and hole exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TheMazeIII {
    static class State {
        public static final char[] dirStrs = {'r', 'l', 'd', 'u'};
        public static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public StringBuilder path;
        public int dirIndex;
        public int i;
        public int j;

        public State(int i, int j, int dirIndex) {
            this.dirIndex = dirIndex;
            this.i = i;
            this.j = j;
            path = new StringBuilder();
        }

        public State(State other) {
            this.dirIndex = other.dirIndex;
            this.i = other.i;
            this.j = other.j;
            path = new StringBuilder(other.path);
        }

        public void updateDirIndex(int dirIndex) {
            this.dirIndex = dirIndex;
        }

        public void move() {
            this.i += dirs[dirIndex][0];
            this.j += dirs[dirIndex][1];
            char dirChar = dirStrs[dirIndex];
            if (path.length() < 1 || path.charAt(path.length() - 1) != dirChar) {
                path.append(dirChar);
            }
        }
    }

    private int hash(State s, int[][] maze) {
        return s.i * maze[0].length + s.j + s.dirIndex * 1000;
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length < 1 || maze[0].length < 1 || ball == null || ball.length < 1 || hole == null || hole.length < 1) {
            return "impossible";
        }
        Queue<State> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int dirIndex = 0; dirIndex < 4; dirIndex++) {
            State s = new State(ball[0], ball[1], dirIndex);
            queue.add(s);
            visited.add(hash(s, maze));
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            String ans = null;
            Set<Integer> addedVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                State s = queue.poll();
                if (s.i == hole[0] && s.j == hole[1]) {
                    String choice = s.path.toString();
                    if (ans == null || choice.compareTo(ans) < 0) {
                        ans = choice;
                    }
                }

                int[] dir = State.dirs[s.dirIndex];
                int ni = s.i + dir[0];
                int nj = s.j + dir[1];

                if (ni < 0 || ni >= maze.length || nj < 0 || nj >= maze[0].length || maze[ni][nj] == 1) {
                    // hit wall 
                    for (int dirIndex = 0; dirIndex < 4; dirIndex++) {
                        if (dirIndex == s.dirIndex) {
                            continue;
                        }
                        State next = new State(s);
                        next.updateDirIndex(dirIndex);
                        addedVisited.add(hash(next, maze));
                        next.move();
                        if (next.i < 0 || next.i >= maze.length || next.j < 0 || next.j >= maze[0].length || maze[next.i][next.j] == 1) {
                            continue;
                        }
                        if (!visited.contains(hash(next, maze))) {
                            queue.add(next);
                            addedVisited.add(hash(next, maze));
                        }
                    }
                }
                else {
                    s.move();
                    if (!visited.contains(hash(s, maze))) {
                        queue.add(s);
                        addedVisited.add(hash(s, maze));
                    }
                }
            }
            if (ans != null) {
                return ans;
            }
            for (Integer key : addedVisited) {
                visited.add(key);
            }
        }


        return "impossible";
    }
}
