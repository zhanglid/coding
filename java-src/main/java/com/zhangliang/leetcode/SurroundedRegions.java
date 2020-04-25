package com.zhangliang.leetcode;
/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are 
not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border 
will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    private void searchInBoarder(char[][] board, Queue<int[]> queue) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                int[] pos = new int[2];
                pos[0] = 0;
                pos[1] = i;
                queue.add(pos);
            }
            if (board.length != 1 && board[board.length - 1][i] == 'O') {
                int[] pos = new int[2];
                pos[0] = board.length - 1;
                pos[1] = i;
                queue.add(pos);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = 0;
                queue.add(pos);
            }
            if (board[0].length != 1 && board[i][board[0].length - 1] == 'O') {
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = board[0].length - 1;
                queue.add(pos);
            }
        }

    }

    private static final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void broadcastInside(char[][] board, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];
            board[i][j] = 'T';
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length || board[ni][nj] != 'O') {
                    continue;
                }
                int[] nextPos = new int[2];
                nextPos[0] = ni;
                nextPos[1] = nj;
                queue.add(nextPos);
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0] == null || board[0].length < 1) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        searchInBoarder(board, queue);
        broadcastInside(board, queue);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
