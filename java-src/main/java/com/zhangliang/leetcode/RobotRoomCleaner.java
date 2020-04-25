package com.zhangliang.leetcode;
/*
Given a robot cleaner in a room modeled as a grid.

Each cell in the grid can be empty or blocked.

The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

Design an algorithm to clean the entire room using only the 4 given APIs shown below.

interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}
Example:

Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Notes:

The input is only given to initialize the room and the robot's position internally. You must solve this problem 
"blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the 
room layout and the initial robot's position.
The robot's initial position will always be in an accessible cell.
The initial direction of the robot will be facing up.
All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
Assume all four edges of the grid are all surrounded by wall.
*/

import java.util.*;

public class RobotRoomCleaner {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current
        // cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    private static final int[][] DIRS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    // Top: 0, Right: 1, Bottom: 2, Left: 3. initial: 0
    class StateRobot {
        public int i = 0;
        public int j = 0;
        public int dir = 0;

        Robot robot;

        public StateRobot(Robot robot) {
            this.robot = robot;
        }

        public int[] getNextPos() {
            return new int[] { i + DIRS[dir][0], j + DIRS[dir][1] };
        }

        public boolean move() {
            boolean result = this.robot.move();
            if (result) {
                i += DIRS[dir][0];
                j += DIRS[dir][1];
            }
            return result;
        }

        public void turnLeft() {
            this.robot.turnLeft();
            dir--;
            if (dir < 0) {
                dir += 4;
            }
        }

        public void turnRight() {
            this.robot.turnRight();
            dir++;
            if (dir >= 4) {
                dir -= 4;
            }
        }
    }

    public void cleanRoom(Robot robot) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        visited.put(0, new HashSet<>());
        visited.get(0).add(0);
        StateRobot sr = new StateRobot(robot);
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        while (!stack.isEmpty()) {
            int count = stack.pop();
            if (count == 3) {
                sr.robot.clean();
                sr.move();
                sr.turnLeft();
                continue;
            }
            int[] nextPos = sr.getNextPos();
            stack.push(count + 1);
            if (visited.containsKey(nextPos[0]) && visited.get(nextPos[0]).contains(nextPos[1]) || !sr.move()) {
                sr.turnRight();
                continue;
            }
            sr.turnLeft();
            stack.push(0);
            if (!visited.containsKey(nextPos[0])) {
                visited.put(nextPos[0], new HashSet<>());
            }
            visited.get(nextPos[0]).add(nextPos[1]);
        }
    }
}
