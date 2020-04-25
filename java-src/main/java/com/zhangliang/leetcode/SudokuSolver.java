package com.zhangliang.leetcode;
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes 
of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
*/

public class SudokuSolver {
    private boolean valid(char[] chars) {
        if (chars.length != 9) {
            return false;
        }

        boolean[] checked = new boolean[9];
        for (char x: chars) {
            if (x == '.') {
                continue;
            }
            if (checked[x - '1']) {
                return false;
            }
            checked[x - '1'] = true;
        }

        return true;
    }
    private boolean validSudoku(char[][] board) {
        for (char[] row: board) {
            if (!valid(row)) {
                return false;
            }
        }

        char[] col = new char[9];
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                col[j] = board[j][i];
            }
            if (!valid(col)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int oi = 0; oi < 3; oi++) {
                    for (int oj = 0; oj < 3; oj++) {
                        col[oi * 3 + oj] = board[3 * i + oi][3 * j + oj];
                    }
                }
                if (!valid(col)) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[] findFirstEmpty(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    int[] ans = new int[2];
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return null;
    }
    private boolean helper(char[][] board) {
        if (!validSudoku(board)) {
            return false;
        }

        int[] firstEmptyPos = findFirstEmpty(board);
        if (firstEmptyPos == null) {
            return true;
        }

        for (char c = '1'; c <= '9'; c++) {
            board[firstEmptyPos[0]][firstEmptyPos[1]] = c;
            if (helper(board)) {
                return true;
            }
        }
        board[firstEmptyPos[0]][firstEmptyPos[1]] = '.';
        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board);
    }
}
