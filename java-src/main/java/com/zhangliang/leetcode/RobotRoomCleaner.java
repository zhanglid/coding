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

    class StateRobot {
        int offsetI;
        int offsetJ;
        int dir;
        private Robot robot;

        public StateRobot(Robot _robot) {
            robot = _robot;
        }

        public boolean move() {
            int nextI = offsetI + dirs[dir][0];
            int nextJ = offsetJ + dirs[dir][1];
            if (!robot.move()) {
                return false;
            }
            offsetI = nextI;
            offsetJ = nextJ;
            return true;
        }

        public boolean moveIfNotCleaned() {
            int nextI = offsetI + dirs[dir][0];
            int nextJ = offsetJ + dirs[dir][1];
            if (cleaned.containsKey(nextI) && cleaned.get(nextI).contains(nextJ) || !robot.move()) {
                return false;
            }
            offsetI = nextI;
            offsetJ = nextJ;
            return true;
        }

        public void turnLeft() {
            robot.turnLeft();
            dir -= 1;
            if (dir < 0) {
                dir += dirs.length;
            }
        }

        public void turnRight() {
            robot.turnRight();
            dir += 1;
            if (dir >= dirs.length) {
                dir -= dirs.length;
            }
        }

        public void clean() {
            robot.clean();
            if (!cleaned.containsKey(offsetI)) {
                cleaned.put(offsetI, new HashSet<>());
            }
            cleaned.get(offsetI).add(offsetJ);
        }
    }

    static final int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    private Map<Integer, Set<Integer>> cleaned = new HashMap<>();

    private void clean(StateRobot robot) {
        robot.clean();
        int oi = robot.offsetI;
        int oj = robot.offsetJ;
        for (int i = 0; i < 3; i++) {
            if (robot.moveIfNotCleaned()) {
                robot.turnLeft();
                clean(robot);
                robot.move();
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
        }
    }

    public void cleanRoom(Robot robot) {
        StateRobot sr = new StateRobot(robot);
        clean(sr);
        if (sr.move()) {
            sr.turnLeft();
            clean(sr);
        }
    }
}
