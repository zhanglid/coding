package com.zhangliang.leetcode;
/*
On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.

A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it 
is impossible for the state of the board to be solved, return -1.

Examples:

Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.

Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.

Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]

Input: board = [[3,2,4],[1,5,0]]
Output: 14
Note:

board will be a 2 x 3 array as described above.
board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].

*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    class State {
        int[][] board;
        int i;
        int j;

        public State(int[][] board) {
            this.board = new int[2][3];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    this.board[i][j] = board[i][j];
                    if (board[i][j] == 0) {
                        this.i = i;
                        this.j = j;
                    }
                }
            }
        }
    }

    private String hash(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        return sb.toString();
    }

    private static final String TARGET = "123450";
    private static final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length != 2 || board[0].length != 3) {
            return -1;
        }

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(board));
        Set<String> visited = new HashSet<>();
        visited.add(hash(board));
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State s = queue.poll();
                if (hash(s.board).equals(TARGET)) {
                    return count;
                }
                for (int[] dir : dirs) {
                    int ni = s.i + dir[0];
                    int nj = s.j + dir[1];

                    if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) {
                        continue;
                    }

                    int tmp = s.board[ni][nj];
                    s.board[ni][nj] = 0;
                    s.board[s.i][s.j] = tmp;

                    State next = new State(s.board);
                    String key = hash(s.board);
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.add(next);
                    }
                    s.board[s.i][s.j] = 0;
                    s.board[ni][nj] = tmp;
                }
            }
            count++;
        }

        return -1;
    }
}
