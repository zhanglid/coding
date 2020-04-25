package com.zhangliang.leetcode;
/*
A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during 
the course of a valid tic-tac-toe game.

The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  
The " " character represents an empty square.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player always places "X" characters, while the second player always places "O" characters.
"X" and "O" characters are always placed into empty squares, never filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.

Example 1:
Input: board = ["O  ", "   ", "   "]
Output: false
Explanation: The first player always plays "X".

Example 2:
Input: board = ["XOX", " X ", "   "]
Output: false
Explanation: Players take turns making moves.

Example 3:
Input: board = ["XXX", "   ", "OOO"]
Output: false

Example 4:
Input: board = ["XOX", "O O", "XOX"]
Output: true
Note:

board is a length-3 array of strings, where each string board[i] has length 3.
Each board[i][j] is a character in the set {" ", "X", "O"}.
*/

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int[] rowStates = new int[board.length];
        int[] colStates = new int[board[0].length()];
        int[] diagStates = new int[2];
        int[] counts = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char x = board[i].charAt(j);
                if (x == 'X') {
                    counts[0]++;
                    rowStates[i]++;
                    colStates[j]++;
                    if (i == j) {
                        diagStates[0]++;
                    }
                    if (i + j == 2) {
                        diagStates[1]++;
                    }
                } else if (x == 'O') {
                    counts[1]++;
                    rowStates[i]--;
                    colStates[j]--;
                    if (i == j) {
                        diagStates[0]--;
                    }
                    if (i + j == 2) {
                        diagStates[1]--;
                    }
                }
            }
        }
        // valid num
        if (counts[0] < counts[1] || counts[0] > counts[1] + 1) {
            return false;
        }
        // valid win state
        boolean isXWin = false;
        boolean isOWin = false;

        for (int state : rowStates) {
            if (state == 3) {
                isXWin = true;
            }
            if (state == -3) {
                isOWin = true;
            }
        }

        for (int state : colStates) {
            if (state == 3) {
                isXWin = true;
            }
            if (state == -3) {
                isOWin = true;
            }
        }

        for (int state : diagStates) {
            if (state == 3) {
                isXWin = true;
            }
            if (state == -3) {
                isOWin = true;
            }
        }

        if (isXWin) {
            return !isOWin && (counts[0] > counts[1]);
        }
        if (isOWin) {
            return !isXWin && (counts[0] == counts[1]);
        }
        return true;
    }
}
