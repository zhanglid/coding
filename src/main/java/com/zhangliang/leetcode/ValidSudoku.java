package com.zhangliang.leetcode;
/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be 
validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without 
repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with 
the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
    invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
*/

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0] == null || board[0].length != 9) {
            return false;
        }

        for (char[] row : board) {
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
                char[] area = new char[9];

                // transform area into array
                for (int oi = 0; oi < 3; oi++) {
                    for (int oj = 0; oj < 3; oj++) {
                        area[oi * 3 + oj] = board[i * 3 + oi][j * 3 + oj];
                    }
                }

                if (!valid(area)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean valid(char[] chars) {
        boolean[] bools = new boolean[10];

        for (char x : chars) {
            if (x != '.') {
                if (bools[x - '0']) {
                    return false;
                }
                bools[x - '0'] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku s = new ValidSudoku();
        System.out.println(s.isValidSudoku());
    }
}
