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

    class State {
        int stage;
        int offsetI;
        int offsetJ;
        int dir;

        public void turnLeft() {
            dir = dir - 1;
            if (dir < 0) {
                dir += dirs.length;
            }
        }

        public void turnRight() {
            dir = dir + 1;
            if (dir >= dirs.length) {
                dir -= dirs.length;
            }
        }
    }

    static private final int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    private void turnLeftRobotWithState(Robot robot, State state) {
        robot.turnLeft();
        state.turnLeft();
    }

    private void turnRightRobotWithState(Robot robot, State state) {
        robot.turnRight();
        state.turnRight();
    }

    private State moveIfNotCleaned(Robot robot, State state, Map<Integer, Set<Integer>> cleaned) {
        int nextI = state.offsetI + dirs[state.dir][0];
        int nextJ = state.offsetJ + dirs[state.dir][1];
        if (cleaned.containsKey(nextI) && cleaned.get(nextI).contains(nextJ) || !robot.move()) {
            return null;
        }
        State nextState = new State();
        nextState.dir = state.dir;
        nextState.offsetI = nextI;
        nextState.offsetJ = nextJ;
        return nextState;
    }

    private void clean(Robot robot, State state, Map<Integer, Set<Integer>> cleaned) {
        if (!cleaned.containsKey(state.offsetI)) {
            cleaned.put(state.offsetI, new HashSet<>());
        }
        cleaned.get(state.offsetI).add(state.offsetJ);
        robot.clean();
    }

    public void cleanRoom(Robot robot) {
        Stack<State> states = new Stack<>();
        states.push(new State());
        states.peek().stage--;
        Map<Integer, Set<Integer>> cleaned = new HashMap<>();
        while (!states.isEmpty()) {
            State state = states.pop();
            if (state.stage <= 0) {
                clean(robot, state, cleaned);
            } else if (state.stage == 3) {
                robot.move();
                robot.turnLeft();
                continue;
            }
            state.stage++;
            states.push(state);
            State nextState = moveIfNotCleaned(robot, state, cleaned);
            if (nextState != null) {
                turnLeftRobotWithState(robot, nextState);
                states.push(nextState);
                state.turnRight();
            } else {
                turnRightRobotWithState(robot, state);
            }
        }

        System.out.println(cleaned.toString());
    }
}
