package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import com.zhangliang.leetcode.RobotRoomCleaner.Robot;

import org.junit.Test;

public class RobotRoomCleanerTest {
    private class TestCase implements Robot {
        private int[][] grid;
        private boolean[][] cleaned;
        private int i;
        private int j;
        private int dir = 0;
        private final int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        public TestCase(int[][] _grid, int _i, int _j) {
            grid = _grid;
            i = _i;
            j = _j;
            cleaned = new boolean[grid.length][grid[0].length];
        }

        public boolean isFinished() {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1 && !cleaned[i][j]) {
                        draw(i, j);
                        return false;
                    }
                }
            }
            return true;
        }

        private void draw(int ti, int tj) {
            for (int i = 0; i < grid.length; i++) {
                if (i == ti) {
                    String[] nums = new String[grid[i].length];
                    for (int j = 0; j < nums.length; j++) {
                        if (j == tj) {
                            nums[j] = "X";
                        } else {
                            nums[j] = Integer.toString(grid[i][j]);
                        }
                    }
                    System.out.println(Arrays.toString(nums));
                } else {
                    System.out.println(Arrays.toString(grid[i]));
                }
            }
        }

        public boolean move() {
            int ni = i + dirs[dir][0];
            int nj = j + dirs[dir][1];
            System.out.println(i + ", " + j + " => " + ", move: " + Arrays.toString(dirs[dir]));
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] != 1) {
                return false;
            }
            i = ni;
            j = nj;
            return true;
        }

        public void turnLeft() {
            int nDir = dir - 1;
            if (nDir < 0) {
                nDir += dirs.length;
            }
            this.dir = nDir;
        }

        public void turnRight() {
            int nDir = dir + 1;
            if (nDir >= dirs.length) {
                nDir -= dirs.length;
            }
            this.dir = nDir;
        }

        public void clean() {
            System.out.println(i + ", " + j);
            cleaned[i][j] = true;
        }
    }

    @Test
    public void testCase() {
        RobotRoomCleaner s = new RobotRoomCleaner();
        TestCase robot = new TestCase(new int[][] { { 1, 1, 1, 1, 1, 0, 1, 1 }, { 1, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1 } }, 0, 2);
        s.cleanRoom(robot);
        assertTrue(robot.isFinished());
    }

    @Test
    public void errCase() {
        RobotRoomCleaner s = new RobotRoomCleaner();
        TestCase robot = new TestCase(new int[][] { { 1, 1 } }, 0, 1);
        s.cleanRoom(robot);
        assertTrue(robot.isFinished());
    }
}
